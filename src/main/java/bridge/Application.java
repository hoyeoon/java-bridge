package bridge;

import bridge.game.BridgeController;
import bridge.game.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker);
        BridgeController bridgeController = new BridgeController(bridgeGame);
        bridgeController.run();
    }
}
