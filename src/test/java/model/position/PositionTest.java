package model.position;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    void 행이_9를_초과하면_예외를_던진다() {
        // When & Then
        assertThatThrownBy(() -> new Position(10, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("10x9 범위를 벗어났습니다.");
    }

    @Test
    void 열이_8을_초과하면_예외를_던진다() {
        // When & Then
        assertThatThrownBy(() -> new Position(0, 9))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("10x9 범위를 벗어났습니다.");
    }

    @CsvSource({
            "1, true",
            "2, false"
    })
    @ParameterizedTest
    void 행을_주어진_숫자_만큼_변경할_수_있는지_검사한다(int step, boolean expected) {
        // Given
        Position position = new Position(8, 0);

        // When & Then
        assertThat(position.canChangeOfRow(step)).isEqualTo(expected);
    }

    @CsvSource({
            "1, true",
            "2, false"
    })
    @ParameterizedTest
    void 열을_주어진_숫자_만큼_변경할_수_있는지_검사한다(int step, boolean expected) {
        // Given
        Position position = new Position(0, 7);

        // When & Then
        assertThat(position.canChangeOfColumn(step)).isEqualTo(expected);
    }

    @CsvSource({
            "1, 1, true",
            "1, 2, false",
            "2, 1, false"
    })
    @ParameterizedTest
    void 행과_열을_주어진_숫자_만큼_변경할_수_있는지_검사한다(int rowStep, int columnStep, boolean expected) {
        // Given
        Position position = new Position(8, 7);

        // When & Then
        assertThat(position.canChangeOfRowAndColumn(rowStep, columnStep)).isEqualTo(expected);
    }

    @Test
    void 열을_변경한다() {
        // Given
        Position position = new Position(5, 5);

        // When & Then
        assertThat(position.changeColumn(2)).isEqualTo(new Position(5, 7));
    }

    @Test
    void 행을_변경한다() {
        // Given
        Position position = new Position(5, 5);

        // When & Then
        assertThat(position.changeRowAndColumn(2, 1)).isEqualTo(new Position(7, 6));
    }
}
