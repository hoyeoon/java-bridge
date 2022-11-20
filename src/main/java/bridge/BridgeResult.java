package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.type.ResultType.FAILURE;
import static bridge.type.ResultType.SUCCESS;

public class BridgeResult {

    public List<Result> makeResult(List<String> bridgeShape, List<String> movedSpaces) {
        List<Result> result = new ArrayList<>();

        for(int i = 0; i < movedSpaces.size(); i++) {
            if(!movedSpaces.get(i).equals(bridgeShape.get(i))) {
                result.add(new Result(FAILURE.getResult(), movedSpaces.get(i)));
                break;
            }
            result.add(new Result(SUCCESS.getResult(), movedSpaces.get(i)));
        }
        return result;
    }
}
