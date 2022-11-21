package bridge.type;

public enum CommandType {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    CommandType(String command) {
        this.command = command;
    }

    public String getCommandType() {
        return command;
    }
}
