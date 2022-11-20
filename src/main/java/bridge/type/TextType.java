package bridge.type;

public enum TextType {
    GAME_START_TEXT("다리 건너기 게임을 시작합니다."),
    BRIDGE_LENGTH_INPUT_TEXT("다리의 길이를 입력해주세요."),
    MOVE_SPACE_INPUT_TEXT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GAME_RETRY_INPUT_TEXT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_END_TEXT("최종 게임 결과"),
    GAME_SUCCESS_OR_NOT_TEXT("게임 성공 여부: "),
    TOTAL_TRY_COUNT_TEXT("총 시도한 횟수: ");

    private final String text;

    TextType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
