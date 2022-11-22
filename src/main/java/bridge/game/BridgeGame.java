package bridge.game;

import bridge.BridgeMaker;
import bridge.Result;
import bridge.type.CommandType;

import java.util.ArrayList;
import java.util.List;

import static bridge.type.BridgeResultType.FAILURE;
import static bridge.type.BridgeResultType.SUCCESS;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;

    public BridgeGame(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<Result> move(List<String> bridge, List<String> movedSpaces) {
        List<Result> results = new ArrayList<>();

        for(int i = 0; i < movedSpaces.size(); i++) {
            if(!movedSpaces.get(i).equals(bridge.get(i))) {
                results.add(new Result(FAILURE.getResult(), movedSpaces.get(i)));
                break;
            }
            results.add(new Result(SUCCESS.getResult(), movedSpaces.get(i)));
        }
        return results;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry(String command, int totalGameCount) {
        if(CommandType.RETRY.getCommandType().equals(command)) {
            totalGameCount++;
        }
        return totalGameCount;
    }

    public List<String> generateBridge(int bridgeSize) {
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
