package bridge;

import bridge.game.BridgeGame;
import bridge.view.OutputView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {

    @Test
    public void 다리건너기_결과_테스트() {

        // given
        List<String> bridges = Arrays.asList("U", "D", "D");

        // when
        List<String> movedSpaces = Arrays.asList("U", "U", "U");

        // then
        BridgeGame bridgeGame = new BridgeGame(null);
        List<Result> results = bridgeGame.move(bridges, movedSpaces);
        assertThat(results.size()).isEqualTo(2);
        assertThat(results.get(1).getResult()).isEqualTo("X");

        for(Result result : results) {
            System.out.println(result.getResult() + ", " + result.getMovedSpace());
        }
    }

    @Test
    public void 다리건너기_출력_테스트() {

        List<Result> results = Arrays.asList(new Result("O", "U"), new Result("X", "U"));
        OutputView outputView = new OutputView();
        outputView.printMap(results);
    }

    @Test
    public void 결과_출력_테스트() {

        List<Result> results = Arrays.asList(new Result("O", "U"), new Result("X", "U"));
        OutputView outputView = new OutputView();
        outputView.printResult("실패", 1, results);
    }
}
