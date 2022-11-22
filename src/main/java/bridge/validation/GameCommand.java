package bridge.validation;

import bridge.type.CommandType;
import bridge.type.ErrorType;

public class GameCommand {

    private final String gameCommand;

    public GameCommand(String gameCommand) {
        this.gameCommand = validate(gameCommand);
    }

    private String validate(String gameCommand) {
        if(!CommandType.RETRY.getCommandType().equals(gameCommand) && !CommandType.QUIT.getCommandType().equals(gameCommand)) {
            throw new IllegalArgumentException(ErrorType.INVALID_GAME_COMMAND.getError());
        }
        return gameCommand;
    }

    public String getGameCommand() {
        return gameCommand;
    }
}
