package bridge.validation;

import bridge.type.ErrorType;

public class BridgeSize {

    public static final int MINIMUM_BRIDGE_SIZE = 3;
    public static final int MAXIMUM_BRIDGE_SIZE = 20;

    private final int bridgeSize;

    public BridgeSize(String bridgeSize) {
        this.bridgeSize = validate(bridgeSize);
    }

    private int validate(String value) {
        int bridgeSize = validateNumber(value);
        validateRange(bridgeSize);
        return bridgeSize;
    }

    private void validateRange(int bridgeSize) {
        if(bridgeSize < MINIMUM_BRIDGE_SIZE || bridgeSize > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ErrorType.INVALID_BRIDGE_SIZE.getError());
        }
    }

    private int validateNumber(String value) {
        try {
            return Integer.parseInt(value);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(ErrorType.INVALID_INPUT.getError());
        }
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
