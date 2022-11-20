package bridge.type;

public enum ResultType {
    SUCCESS("O"),
    FAILURE("X");

    private final String result;

    ResultType(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
