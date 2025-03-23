package model.piece;

import model.piece.Guard;
import model.piece.Piece;
import model.piece.PieceType;
import model.position.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GuardTest {

    private Piece guard;

    @BeforeEach
    void init() {
        guard = new Guard(new Position(5, 5));
    }

    @Test
    void 사_기물의_PieceType을_반환한다() {
        // Given
        // When & Then
        assertThat(guard.getPieceType()).isEqualTo(PieceType.GUARD);
    }

    @Test
    void 사_기물이_수평_방향으로_움직일_수_있는_위치로_가는_경로를_계산한다() {
        // Given
        Position destination = new Position(5, 4);
        Position destination2 = new Position(5, 6);

        // When & Then
        assertThat(guard.calculateRouteToDestination(destination))
                .containsExactlyInAnyOrder(new Position(5, 4));
        assertThat(guard.calculateRouteToDestination(destination2))
                .containsExactlyInAnyOrder(new Position(5, 6));
    }

    @Test
    void 사_기물이_대각선_방향으로_움직일_수_있는_위치로_가는_경로를_계산한다() {
        // Given
        Position destination = new Position(4, 4);
        Position destination2 = new Position(4, 6);
        Position destination3 = new Position(6, 4);
        Position destination4 = new Position(6, 6);

        // When & Then
        assertThat(guard.calculateRouteToDestination(destination))
                .containsExactlyInAnyOrder(new Position(4, 4));
        assertThat(guard.calculateRouteToDestination(destination2))
                .containsExactlyInAnyOrder(new Position(4, 6));
        assertThat(guard.calculateRouteToDestination(destination3))
                .containsExactlyInAnyOrder(new Position(6, 4));
        assertThat(guard.calculateRouteToDestination(destination4))
                .containsExactlyInAnyOrder(new Position(6, 6));
    }

    @Test
    void 사_기물이_수직_방향으로_움직일_수_있는_위치로_가는_경로를_계산한다() {
        // Given
        Position destination = new Position(4, 5);
        Position destination2 = new Position(6, 5);

        // When & Then
        assertThat(guard.calculateRouteToDestination(destination))
                .containsExactlyInAnyOrder(new Position(4, 5));
        assertThat(guard.calculateRouteToDestination(destination2))
                .containsExactlyInAnyOrder(new Position(6, 5));
    }

    @Test
    void 사_기물이_이동할_수_없는_위치로는_경로를_계산할_수_없다() {
        // Given
        Position invalidDestination = new Position(7, 7);

        // When & Then
        assertThatThrownBy(() -> guard.calculateRouteToDestination(invalidDestination))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("현재 기물이 이동할 수 없는 위치입니다.");
    }
}
