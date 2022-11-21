package bridge.view;

import bridge.BridgeGame;
import bridge.Result;
import bridge.type.MessageType;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final char NEWLINE_CHARACTER = '\n';

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        System.out.println(bridgeGame.move());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String gameResultType, int totalTryCount, List<Result> results) {
        BridgeGame bridgeGame = new BridgeGame(results);

    }

    public void printGameStartMessage() {
        System.out.println(MessageType.GAME_START.getMessage() + NEWLINE_CHARACTER);
        printBridgeSizeInputMessage();
    }

    private void printBridgeSizeInputMessage() {
        System.out.println(MessageType.BRIDGE_LENGTH_INPUT.getMessage());
    }

    public void printMovingSpaceInputMessage() {
        System.out.println(MessageType.MOVE_SPACE_INPUT.getMessage());
    }
}
