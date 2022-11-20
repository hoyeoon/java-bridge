package bridge.type;

public enum MessageType {
    GAME_START("다리 건너기 게임을 시작합니다."),
    BRIDGE_LENGTH_INPUT("다리의 길이를 입력해주세요."),
    MOVE_SPACE_INPUT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GAME_RETRY_INPUT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_END("최종 게임 결과"),
    GAME_SUCCESS_OR_NOT("게임 성공 여부: "),
    TOTAL_TRY_COUNT("총 시도한 횟수: ");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
