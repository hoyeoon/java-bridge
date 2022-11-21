package bridge.type;

public enum MoveType {
    DOWN("D"),
    UP("U");

    private final String move;

    MoveType(String move) {
        this.move = move;
    }

    public String getMove() {
        return move;
    }
}
