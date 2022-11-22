package bridge.type;

public enum ErrorType {
    ERROR("[ERROR] "),
    INVALID_INPUT(ERROR.getError() + "잘못된 입력입니다.\n"),
    INVALID_BRIDGE_SIZE(ERROR.getError() + "다리 길이는 3부터 20 사이의 숫자여야 합니다.\n"),
    INVALID_MOVING_SPACE(ERROR.getError() + "이동할 칸은 U 또는 D여야 합니다.\n"),
    INVALID_GAME_COMMAND(ERROR.getError() + "게임 재시작/종료 여부는 R 또는 Q여야 합니다.\n");

    private final String error;

    ErrorType(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
