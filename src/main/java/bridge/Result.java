package bridge;

public class Result {
    private final String result;
    private final String movedSpace;

    Result(String result, String movedSpace) {
        this.result = result;
        this.movedSpace = movedSpace;
    }

    public String getResult() {
        return result;
    }

    public String getMovedSpace() {
        return movedSpace;
    }
}
