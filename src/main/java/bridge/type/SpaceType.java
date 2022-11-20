package bridge.type;

public enum SpaceType {
    DOWN("D"),
    UP("U");

    private final String space;

    SpaceType(String space) {
        this.space = space;
    }

    public String getSpace() {
        return space;
    }
}
