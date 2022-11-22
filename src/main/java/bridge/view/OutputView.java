package bridge.view;

import bridge.Result;
import bridge.type.MessageType;
import bridge.type.OutputFormatType;

import java.util.List;

import static bridge.type.MoveType.DOWN;
import static bridge.type.MoveType.UP;

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
    public static void printMap(List<Result> results) {
        System.out.println(makeTotalSpaceMap(results));
    }

    public static String makeTotalSpaceMap(List<Result> results) {
        StringBuilder map = new StringBuilder();
        map.append(makeSpaceMap(UP.getMove(), results)).append(NEWLINE_CHARACTER);
        map.append(makeSpaceMap(DOWN.getMove(), results)).append(NEWLINE_CHARACTER);

        return map.toString();
    }

    private static String makeSpaceMap(String moveType, List<Result> results) {
        StringBuilder spaceMap = new StringBuilder();
        spaceMap.append(OutputFormatType.START_BRACKET.getOutputFormat());

        for(Result result : results) {
            makeSpace(moveType, spaceMap, result);
        }
        removeLastSeparator(spaceMap);
        spaceMap.append(OutputFormatType.END_BRACKET.getOutputFormat());

        return spaceMap.toString();
    }

    private static void makeSpace(String moveType, StringBuilder spaceMap, Result result) {
        if(!moveType.equals(result.getMovedSpace())) {
            spaceMap.append(OutputFormatType.SPACE.getOutputFormat());
            spaceMap.append(OutputFormatType.SEPARATOR.getOutputFormat());
            return;
        }
        spaceMap.append(result.getResult());
        spaceMap.append(OutputFormatType.SEPARATOR.getOutputFormat());
    }

    private static void removeLastSeparator(StringBuilder spaceMap) {
        spaceMap.replace(spaceMap.length() - 3, spaceMap.length(), "");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(String gameResultType, int totalGameCount, List<Result> results) {
        StringBuilder result = new StringBuilder();
        result.append(MessageType.GAME_END.getMessage()).append(NEWLINE_CHARACTER);
        result.append(makeTotalSpaceMap(results)).append(NEWLINE_CHARACTER);
        result.append(MessageType.GAME_SUCCESS_OR_NOT.getMessage()).append(gameResultType).append(NEWLINE_CHARACTER);
        result.append(MessageType.TOTAL_TRY_COUNT.getMessage()).append(totalGameCount);

        System.out.println(result);
    }

    public static void printGameStartMessage() {
        System.out.println(MessageType.GAME_START.getMessage() + NEWLINE_CHARACTER);
    }

    public static void printBridgeSizeInputMessage() {
        System.out.println(MessageType.BRIDGE_LENGTH_INPUT.getMessage());
    }

    public static void printMovingSpaceInputMessage() {
        System.out.println(MessageType.MOVE_SPACE_INPUT.getMessage());
    }

    public static void printGameCommandInputMessage() {
        System.out.println(MessageType.GAME_COMMAND_INPUT.getMessage());
    }

    public static void printError(RuntimeException e) {
        System.err.println(e.getMessage());
    }

    public static void printNewlineCharacter() {
        System.out.println();
    }
}
