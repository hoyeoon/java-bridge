package bridge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {

    @Test
    public void 다리건너기_결과_테스트() {

        // given
        List<String> bridgeShape = Arrays.asList("U", "D", "D");

        // when
        List<String> movedSpaces = Arrays.asList("U", "U", "U");

        // then
        BridgeResult bridgeResult = new BridgeResult();
        List<Result> results = bridgeResult.makeResult(bridgeShape, movedSpaces);
        assertThat(results.size()).isEqualTo(2);
        assertThat(results.get(1).getResult()).isEqualTo("X");
    }
}
