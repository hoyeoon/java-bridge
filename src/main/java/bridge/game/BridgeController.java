package bridge.game;

import bridge.Result;
import bridge.validation.BridgeSize;
import bridge.validation.GameCommand;
import bridge.validation.MovingSpace;
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

    private List<String> bridgeModule() {
        int bridgeSize = getReadBridgeSize().getBridgeSize();
        OutputView.printNewlineCharacter();
        return bridgeGame.generateBridge(bridgeSize);
    }

    private BridgeSize getReadBridgeSize() {
        try {
            OutputView.printBridgeSizeInputMessage();
            return InputView.readBridgeSize();
        } catch(IllegalArgumentException e) {
            OutputView.printError(e);
            return getReadBridgeSize();
        }
    }

    private List<Result> moveModule(List<String> bridge) {
        String moveType = getReadMovingSpace().getMovingSpace();
        movedSpaces.add(moveType);
        List<Result> results = bridgeGame.move(bridge, movedSpaces);
        OutputView.printMap(results);
        return results;
    }

    private MovingSpace getReadMovingSpace() {
        try {
            OutputView.printMovingSpaceInputMessage();
            return InputView.readMoving();
        } catch(IllegalArgumentException e) {
            OutputView.printError(e);
            return getReadMovingSpace();
        }
    }

    private String retryModule() {
        String command = getReadGameCommand().getGameCommand();
        totalGameCount = bridgeGame.retry(command, totalGameCount);
        movedSpaces = initMovedSpaces();
        return command;
    }

    private GameCommand getReadGameCommand() {
        try {
            OutputView.printGameCommandInputMessage();
            return InputView.readGameCommand();
        } catch(IllegalArgumentException e) {
            OutputView.printError(e);
            return getReadGameCommand();
        }
    }

    private List<String> initMovedSpaces() {
        return new ArrayList<>();
    }

    private boolean isQuitCommand(String command, List<Result> results) {
        if(CommandType.QUIT.getCommandType().equals(command)) {
            OutputView.printResult(GameResultType.FAILURE.getResult(), totalGameCount, results);
            return true;
        }
        return false;
    }

    private boolean isFinish(List<String> bridge, List<Result> results) {
        if(bridge.size() == results.size()) {
            OutputView.printResult(GameResultType.SUCCESS.getResult(), totalGameCount, results);
            return true;
        }
        return false;
    }

    private boolean isFailure(List<Result> results) {
        return BridgeResultType.FAILURE.getResult().equals(results.get(results.size() - 1).getResult());
    }
}
