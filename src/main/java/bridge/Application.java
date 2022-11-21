package bridge;

import bridge.type.BridgeResultType;
import bridge.type.CommandType;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();

    public static void main(String[] args) {
        outputView.printGameStartMessage();
        List<String> bridgeShape = initBridgeShape(); System.out.println("bridgeShape = " + bridgeShape);
        List<String> movedSpaces = initMovedSpaces();

        game(bridgeShape, movedSpaces);
    }

    private static void game(List<String> bridgeShape, List<String> movedSpaces) {
        while(true) {
            List<Result> results = movingModule(bridgeShape, movedSpaces);
            System.out.println("000000000000000000000");

            if (isFailure(results)) {
                outputView.printGameRetryInputMessage();

                if (isQuitCommand()) {
                    break;
                }

                movedSpaces = initMovedSpaces();
                continue;
            }

            if (isFinish(bridgeShape, results)) {
                break;
            }
        }
    }

    private static List<String> initBridgeShape() {
        return new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(inputView.readBridgeSize());
    }

    private static List<String> initMovedSpaces() {
        return new ArrayList<>();
    }

    private static boolean isQuitCommand() {
        if(CommandType.QUIT.getCommandType().equals(inputView.readGameCommand())) {
            System.out.println("Q 눌러서 종료");
            return true;
        }
        return false;
    }

    private static boolean isFinish(List<String> bridgeShape, List<Result> results) {
        if(bridgeShape.size() == results.size()) {
            System.out.println("끝까지 와서 종료");
            return true;
        }
        return false;
    }

    private static boolean isFailure(List<Result> results) {
        return BridgeResultType.FAILURE.getResult().equals(results.get(results.size() - 1).getResult());
    }

    private static List<Result> movingModule(List<String> bridgeShape, List<String> movedSpaces) {
        outputView.printMovingSpaceInputMessage();
        movedSpaces.add(inputView.readMoving());
        List<Result> results = new BridgeResult().makeResult(bridgeShape, movedSpaces);
        outputView.printMap(results);

        return results;
    }
}
