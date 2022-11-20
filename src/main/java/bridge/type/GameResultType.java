package bridge.type;

public enum GameResultType {
    SUCCESS("성공"),
    FAILURE("실패");

    private final String result;

    GameResultType(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
