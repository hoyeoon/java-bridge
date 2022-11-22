package bridge.game;

import bridge.Result;
import bridge.type.BridgeResultType;
import bridge.type.CommandType;
import bridge.type.GameResultType;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {

    private static List<String> movedSpaces = new ArrayList<>();
    private static int totalGameCount = 1;

    private final BridgeGame bridgeGame;

    public BridgeController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        OutputView.printGameStartMessage();
        String startCommand = CommandType.RETRY.getCommandType();
        List<String> bridge = bridgeModule(); System.out.println("bridge = " + bridge);
        game(startCommand, bridge);
    }

    private List<String> bridgeModule() {
        OutputView.printBridgeSizeInputMessage();
        return bridgeGame.generateBridge(InputView.readBridgeSize());
    }

    private void game(String command, List<String> bridge) {
        List<Result> results;
        do {
            results = moveModule(bridge);
            if (isFailure(results)) {
                command = retryModule();
                continue;
            }
            if (isFinish(bridge, results)) {
                break;
            }
        } while(!isQuitCommand(command, results));
    }

    private List<Result> moveModule(List<String> bridge) {
        OutputView.printMovingSpaceInputMessage();
        movedSpaces.add(InputView.readMoving());
        List<Result> results = bridgeGame.move(bridge, movedSpaces);
        OutputView.printMap(results);

        return results;
    }

    private String retryModule() {
        OutputView.printGameRetryInputMessage();
        totalGameCount = bridgeGame.retry(totalGameCount);
        movedSpaces = initMovedSpaces();

        return InputView.readGameCommand();
    }

    private List<String> initMovedSpaces() {
        return new ArrayList<>();
    }

    private boolean isQuitCommand(String command, List<Result> results) {
        if(CommandType.QUIT.getCommandType().equals(command)) {
            System.out.println("Q 눌러서 종료");
            OutputView.printResult(GameResultType.FAILURE.getResult(), totalGameCount, results);
            return true;
        }
        return false;
    }

    private boolean isFinish(List<String> bridge, List<Result> results) {
        if(bridge.size() == results.size()) {
            System.out.println("끝까지 와서 종료");
            OutputView.printResult(GameResultType.SUCCESS.getResult(), totalGameCount, results);
            return true;
        }
        return false;
    }

    private boolean isFailure(List<Result> results) {
        return BridgeResultType.FAILURE.getResult().equals(results.get(results.size() - 1).getResult());
    }
}
