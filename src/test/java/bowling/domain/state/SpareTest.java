package bowling.domain.state;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import bowling.domain.state.progress.Ready;
import bowling.domain.state.progress.Running;
import bowling.domain.state.result.Spare;

public class SpareTest {

    @Test
    void 생성_예외_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Spare.of(BowlingPin.of(0)));
    }

    @Test
    void 상태_생성_테스트() {
        // given
        State state = Running.of(BowlingPin.of(5)).bowl(BowlingPin.of(5));
        // when & then
        assertThat(state).isInstanceOf(Spare.class);
    }

    @Test
    void 상태_종료_여부_테스트() {
        // given
        State state = new Ready().bowl(BowlingPin.of(5)).bowl(BowlingPin.of(5));
        State state2 = Running.of(BowlingPin.of(5)).bowl(BowlingPin.of(5));
        State state3 = Spare.of(BowlingPin.of(5));
        // when & then
        assertThat(state.isDone()).isTrue();
        assertThat(state2.isDone()).isTrue();
        assertThat(state3.isDone()).isTrue();
    }
}
