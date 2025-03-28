package model.piece.position;

import model.piece.position.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    void 행을_변경한다() {
        // Given
        Position position = new Position(5, 5);

        // When & Then
        assertThat(position.changeRow(2)).isEqualTo(new Position(7, 5));
    }

    @Test
    void 열을_변경한다() {
        // Given
        Position position = new Position(5, 5);

        // When & Then
        assertThat(position.changeColumn(2)).isEqualTo(new Position(5, 7));
    }

    @Test
    void 행과_열을_변경한다() {
        // Given
        Position position = new Position(5, 5);

        // When & Then
        assertThat(position.changeRowAndColumn(2, 1)).isEqualTo(new Position(7, 6));
    }

    @Test
    void 두_Position의_행_차이를_계산한다() {
        // Given
        Position position1 = new Position(5, 3);
        Position position2 = new Position(2, 1);

        // When & Then
        assertThat(position1.calculateRowDifference(position2)).isEqualTo(3);
    }

    @Test
    void 두_Position의_열_차이를_계산한다() {
        // Given
        Position position1 = new Position(5, 3);
        Position position2 = new Position(2, 1);

        // When & Then
        assertThat(position1.calculateColumnDifference(position2)).isEqualTo(2);
    }

    @Test
    void 해당_step만큼_움직일_수_있다면_움직인_Position을_반환한다() {
        // Given
        Position position = new Position(5, 5);

        // When & Then
        assertThat(position.changeRowAndColumnIfPositionInBoard(3, -3))
                .isEqualTo(new Position(8, 2));
    }

    @CsvSource({
            "5, 0",
            "0, 4",
            "5, 4"
    })
    @ParameterizedTest
    void 해당_step만큼_움직일_수_없다면_예외를_발생시킨다(int rowStep, int columnStep) {
        // Given
        Position position = new Position(5, 5);

        // When & Then
        assertThatThrownBy(() -> position.changeRowAndColumnIfPositionInBoard(rowStep, columnStep))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("10x9 범위를 벗어났습니다.");
    }
}
