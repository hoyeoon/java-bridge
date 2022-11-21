package bridge;

import bridge.type.MessageType;
import bridge.type.OutputFormatType;

import java.util.List;

import static bridge.type.MoveType.DOWN;
import static bridge.type.MoveType.UP;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final char NEWLINE_CHARACTER = '\n';

    private final List<Result> results;

    public BridgeGame(List<Result> results) {
        validate(results);
        this.results = results;
    }

    private void validate(List<Result> results) {
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move() {
        StringBuilder map = new StringBuilder();
        map.append(makeSpaceMap(UP.getMove(), results)).append(NEWLINE_CHARACTER);
        map.append(makeSpaceMap(DOWN.getMove(), results)).append(NEWLINE_CHARACTER);

        return map.toString();
    }

    private String makeSpaceMap(String moveType, List<Result> results) {
        StringBuilder spaceMap = new StringBuilder(OutputFormatType.START_BRACKET.getOutputFormat());
        for(Result result : results) {
            if(!moveType.equals(result.getMovedSpace())) {
                spaceMap.append(OutputFormatType.SPACE.getOutputFormat()).append(OutputFormatType.SEPARATOR.getOutputFormat());
                continue;
            }
            spaceMap.append(result.getResult()).append(OutputFormatType.SEPARATOR.getOutputFormat());
        }
        spaceMap.replace(spaceMap.length() - 3, spaceMap.length(), "");

        return spaceMap.append(OutputFormatType.END_BRACKET.getOutputFormat()).toString();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String retryType) {

    }

    private String makeFinalResult(String gameResultType, int totalTryCount) {
        StringBuilder result = new StringBuilder();
        BridgeGame bridgeGame = new BridgeGame(results);
        result.append(MessageType.GAME_END.getMessage()).append(NEWLINE_CHARACTER);
        result.append(bridgeGame.move()).append(NEWLINE_CHARACTER);
        result.append(MessageType.GAME_SUCCESS_OR_NOT.getMessage()).append(gameResultType).append(NEWLINE_CHARACTER);
        result.append(MessageType.TOTAL_TRY_COUNT.getMessage()).append(totalTryCount);

        return result.toString();
    }
}
