package model.board;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class HorseAndElephantRowOfPositionTest {

    @CsvSource({
            "1, 마상상마",
            "2, 상마마상",
            "3, 마상마상",
            "4, 상마상마"
    })
    @ParameterizedTest
    void 번호_1부터_4를_입력받으면_그에_해당하는_Horse와_Elephant_위치_Enum을_생성한다(int number, HorseAndElephantRowOfPosition expected) {
        // Given
        // When
        HorseAndElephantRowOfPosition horseAndElephantRowOfPosition = HorseAndElephantRowOfPosition.from(number);

        // Then
        assertThat(horseAndElephantRowOfPosition).isEqualTo(expected);
    }

    @Test
    void 잘못된_번호를_입력하면_예외가_발생한다() {
        // Given
        int invalidNumber = 5;

        // When & Then
        assertThatThrownBy(() -> HorseAndElephantRowOfPosition.from(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 번호를 입력하셨습니다.");
    }
}
