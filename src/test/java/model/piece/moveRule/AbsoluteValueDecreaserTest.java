package model.piece.moveRule;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AbsoluteValueDecreaserTest {

    @Test
    void 양수는_1_감소시킨다() {
        // Given
        int number = 5;

        // When & Then
        Assertions.assertThat(AbsoluteValueDecreaser.decreaseOne(number)).isEqualTo(4);
    }

    @Test
    void 음수는_1_증가시킨다() {
        // Given
        int number = -5;

        // When & Then
        Assertions.assertThat(AbsoluteValueDecreaser.decreaseOne(number)).isEqualTo(-4);
    }

    @Test
    void _0은_그대로_반환한다() {
        // Given
        int number = 0;

        // When & Then
        Assertions.assertThat(AbsoluteValueDecreaser.decreaseOne(number)).isEqualTo(0);
    }
}
