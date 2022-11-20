package bridge.type;

public enum BridgeResultType {
    SUCCESS("O"),
    FAILURE("X");

    private final String result;

    BridgeResultType(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
