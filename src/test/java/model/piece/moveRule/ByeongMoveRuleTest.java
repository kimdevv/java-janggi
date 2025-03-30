package model.piece.moveRule;

import model.piece.position.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ByeongMoveRuleTest {

    private MoveRule byeongMoveRule;

    @BeforeEach
    void init() {
        byeongMoveRule = new ByeongMoveRule();
    }

    @Test
    void 수평_방향으로의_병의_움직임을_검사한다() {
        // Given
        Position startPosition = new Position(5, 5);
        Position destination = new Position(5, 4);
        Position destination2 = new Position(5, 6);

        // When & Then
        assertThat(byeongMoveRule.calculateRouteToDestination(startPosition, destination))
                .containsExactlyInAnyOrder(new Position(5, 4));
        assertThat(byeongMoveRule.calculateRouteToDestination(startPosition, destination2))
                .containsExactlyInAnyOrder(new Position(5, 6));
    }

    @Test
    void 수직_방향으로의_병의_움직임을_검사한다() {
        // Given
        Position startPosition = new Position(5, 5);
        Position destination = new Position(6, 5);

        // When & Then
        assertThat(byeongMoveRule.calculateRouteToDestination(startPosition, destination))
                .containsExactlyInAnyOrder(new Position(6, 5));
    }

    @Test
    void 병_기물이_이동할_수_없는_위치로는_경로를_계산할_수_없다() {
        // Given
        Position startPosition = new Position(5, 5);
        Position invalidDestination = new Position(7, 7);

        // When & Then
        assertThatThrownBy(() -> byeongMoveRule.calculateRouteToDestination(startPosition, invalidDestination))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("현재 기물이 이동할 수 없는 위치입니다.");
    }

    @Test
    void 궁성_내부에서는_왼쪽아래로_이동할_수_있다() {
        // Given
        Position startPosition = new Position(8, 4);
        Position destination = new Position(9, 3);

        // When & Then
        assertThat(byeongMoveRule.calculateRouteToDestination(startPosition, destination))
                .containsExactlyInAnyOrder(new Position(9, 3));
    }

    @Test
    void 궁성_내부에서는_오른쪽아래로_이동할_수_있다() {
        // Given
        Position startPosition = new Position(8, 4);
        Position destination = new Position(9, 5);

        // When & Then
        assertThat(byeongMoveRule.calculateRouteToDestination(startPosition, destination))
                .containsExactlyInAnyOrder(new Position(9, 5));
    }
}
