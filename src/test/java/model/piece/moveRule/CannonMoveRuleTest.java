package model.piece.moveRule;

import model.piece.position.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CannonMoveRuleTest {

    private MoveRule cannonMoveRule;

    @BeforeEach
    void init() {
        cannonMoveRule = new CannonMoveRule();
    }

    @Test
    void 수평_방향으로의_포의_움직임을_검사한다() {
        // Given
        Position startPosition = new Position(5, 5);
        Position destination = new Position(5, 0);
        Position destination2 = new Position(5, 1);
        Position destination3 = new Position(5, 2);
        Position destination4 = new Position(5, 3);
        Position destination5 = new Position(5, 7);
        Position destination6 = new Position(5, 8);

        // When & Then
        assertThat(cannonMoveRule.calculateRouteToDestination(startPosition, destination))
                .containsExactlyInAnyOrder(new Position(5, 0), new Position(5, 1), new Position(5, 2), new Position(5, 3), new Position(5, 4));
        assertThat(cannonMoveRule.calculateRouteToDestination(startPosition, destination2))
                .containsExactlyInAnyOrder(new Position(5, 1), new Position(5, 2), new Position(5, 3), new Position(5, 4));
        assertThat(cannonMoveRule.calculateRouteToDestination(startPosition, destination3))
                .containsExactlyInAnyOrder(new Position(5, 2), new Position(5, 3), new Position(5, 4));
        assertThat(cannonMoveRule.calculateRouteToDestination(startPosition, destination4))
                .containsExactlyInAnyOrder(new Position(5, 3), new Position(5, 4));
        assertThat(cannonMoveRule.calculateRouteToDestination(startPosition, destination5))
                .containsExactlyInAnyOrder(new Position(5, 6), new Position(5, 7));
        assertThat(cannonMoveRule.calculateRouteToDestination(startPosition, destination6))
                .containsExactlyInAnyOrder(new Position(5, 6), new Position(5, 7), new Position(5, 8));
    }

    @Test
    void 수직_방향으로의_포의_움직임을_검사한다() {
        // Given
        Position startPosition = new Position(5, 5);
        Position destination = new Position(0, 5);
        Position destination2 = new Position(1, 5);
        Position destination3 = new Position(2, 5);
        Position destination4 = new Position(3, 5);
        Position destination5 = new Position(7, 5);
        Position destination6 = new Position(8, 5);
        Position destination7 = new Position(9, 5);

        // When & Then
        assertThat(cannonMoveRule.calculateRouteToDestination(startPosition, destination))
                .containsExactlyInAnyOrder(new Position(0, 5), new Position(1, 5), new Position(2, 5), new Position(3, 5), new Position(4, 5));
        assertThat(cannonMoveRule.calculateRouteToDestination(startPosition, destination2))
                .containsExactlyInAnyOrder(new Position(1, 5), new Position(2, 5), new Position(3, 5), new Position(4, 5));
        assertThat(cannonMoveRule.calculateRouteToDestination(startPosition, destination3))
                .containsExactlyInAnyOrder(new Position(2, 5), new Position(3, 5), new Position(4, 5));
        assertThat(cannonMoveRule.calculateRouteToDestination(startPosition, destination4))
                .containsExactlyInAnyOrder(new Position(3, 5), new Position(4, 5));
        assertThat(cannonMoveRule.calculateRouteToDestination(startPosition, destination5))
                .containsExactlyInAnyOrder(new Position(6, 5), new Position(7, 5));
        assertThat(cannonMoveRule.calculateRouteToDestination(startPosition, destination6))
                .containsExactlyInAnyOrder(new Position(6, 5), new Position(7, 5), new Position(8, 5));
        assertThat(cannonMoveRule.calculateRouteToDestination(startPosition, destination7))
                .containsExactlyInAnyOrder(new Position(6, 5), new Position(7, 5), new Position(8, 5), new Position(9, 5));
    }

    @CsvSource({
            "4, 5",
            "5, 4",
            "6, 6"
    })
    @ParameterizedTest
    void 포_기물이_이동할_수_없는_위치로는_경로를_계산할_수_없다(int row, int column) {
        // Given
        Position startPosition = new Position(5, 5);
        Position invalidDestination = new Position(row, column);

        // When & Then
        assertThatThrownBy(() -> cannonMoveRule.calculateRouteToDestination(startPosition, invalidDestination))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("현재 기물이 이동할 수 없는 위치입니다.");
    }
}
