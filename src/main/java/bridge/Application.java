package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final BridgeResult bridgeResult = new BridgeResult();
    private static final List<String> movedSpaces = new ArrayList<>();

    public static void main(String[] args) {
        outputView.printGameStartMessage();
        List<String> bridgeShape = bridgeMaker.makeBridge(inputView.readBridgeSize());
        System.out.println("bridgeShape = " + bridgeShape);

        movingModule(bridgeShape);

    }

    private static void movingModule(List<String> bridgeShape) {
        outputView.printMovingSpaceInputMessage();
        movedSpaces.add(inputView.readMoving());
        outputView.printMap(new BridgeGame(bridgeResult.makeResult(bridgeShape, movedSpaces)));
    }
}
