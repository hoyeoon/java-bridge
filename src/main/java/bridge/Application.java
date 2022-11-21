package bridge;

import bridge.type.BridgeResultType;
import bridge.type.CommandType;
import bridge.type.GameResultType;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static List<String> movedSpaces = initMovedSpaces();
    private static int totalGameCount = 1;

    public static void main(String[] args) {
        outputView.printGameStartMessage();
        List<String> bridgeShape = initBridgeShape(); System.out.println("bridgeShape = " + bridgeShape);
        game(CommandType.RETRY.getCommandType(), bridgeShape);
    }

    private static void game(String command, List<String> bridgeShape) {
        List<Result> results;
        do {
            results = moveModule(bridgeShape);
            if (isFailure(results)) {
                command = retryModule();
                continue;
            }
            if (isFinish(bridgeShape, results)) {
                break;
            }
        } while(!isQuitCommand(command, results));
    }

    private static List<Result> moveModule(List<String> bridgeShape) {
        outputView.printMovingSpaceInputMessage();
        movedSpaces.add(inputView.readMoving());
        List<Result> results = new BridgeGame().move(bridgeShape, movedSpaces);
        outputView.printMap(results);

        return results;
    }

    private static String retryModule() {
        outputView.printGameRetryInputMessage();
        totalGameCount = new BridgeGame().retry(totalGameCount);
        movedSpaces = initMovedSpaces();

        return inputView.readGameCommand();
    }

    private static List<String> initBridgeShape() {
        return new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(inputView.readBridgeSize());
    }

    private static List<String> initMovedSpaces() {
        return new ArrayList<>();
    }

    private static boolean isQuitCommand(String command, List<Result> results) {
        if(CommandType.QUIT.getCommandType().equals(command)) {
            System.out.println("Q 눌러서 종료");
            outputView.printResult(GameResultType.FAILURE.getResult(), totalGameCount, results);
            return true;
        }
        return false;
    }

    private static boolean isFinish(List<String> bridgeShape, List<Result> results) {
        if(bridgeShape.size() == results.size()) {
            System.out.println("끝까지 와서 종료");
            outputView.printResult(GameResultType.SUCCESS.getResult(), totalGameCount, results);
            return true;
        }
        return false;
    }

    private static boolean isFailure(List<Result> results) {
        return BridgeResultType.FAILURE.getResult().equals(results.get(results.size() - 1).getResult());
    }
}
