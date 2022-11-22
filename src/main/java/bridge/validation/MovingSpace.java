package bridge.validation;

import bridge.type.ErrorType;
import bridge.type.MoveType;

public class MovingSpace {

    private final String movingSpace;

    public MovingSpace(String movingSpace) {
        this.movingSpace = validate(movingSpace);
    }

    private String validate(String movingSpace) {
        if(!MoveType.UP.getMove().equals(movingSpace) && !MoveType.DOWN.getMove().equals(movingSpace)) {
            throw new IllegalArgumentException(ErrorType.INVALID_MOVING_SPACE.getError());
        }
        return movingSpace;
    }

    public String getMovingSpace() {
        return movingSpace;
    }
}
