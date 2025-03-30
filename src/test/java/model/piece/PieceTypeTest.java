package model.piece;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PieceTypeTest {

    @Test
    void 타입의_이름으로부터_궁의_PieceType을_찾아서_가져온다() {
        // Given
        String typeName = "GENERAL";

        // When & Then
        assertThat(PieceType.findByName(typeName)).isEqualTo(PieceType.GENERAL);
    }

    @Test
    void 타입의_이름으로부터_사의_PieceType을_찾아서_가져온다() {
        // Given
        String typeName = "GUARD";

        // When & Then
        assertThat(PieceType.findByName(typeName)).isEqualTo(PieceType.GUARD);
    }

    @Test
    void 타입의_이름으로부터_졸의_PieceType을_찾아서_가져온다() {
        // Given
        String typeName = "JOL";

        // When & Then
        assertThat(PieceType.findByName(typeName)).isEqualTo(PieceType.JOL);
    }

    @Test
    void 타입의_이름으로부터_병의_PieceType을_찾아서_가져온다() {
        // Given
        String typeName = "BYEONG";

        // When & Then
        assertThat(PieceType.findByName(typeName)).isEqualTo(PieceType.BYEONG);
    }

    @Test
    void 타입의_이름으로부터_차의_PieceType을_찾아서_가져온다() {
        // Given
        String typeName = "CHARIOT";

        // When & Then
        assertThat(PieceType.findByName(typeName)).isEqualTo(PieceType.CHARIOT);
    }

    @Test
    void 타입의_이름으로부터_포의_PieceType을_찾아서_가져온다() {
        // Given
        String typeName = "CANNON";

        // When & Then
        assertThat(PieceType.findByName(typeName)).isEqualTo(PieceType.CANNON);
    }

    @Test
    void 타입의_이름으로부터_마의_PieceType을_찾아서_가져온다() {
        // Given
        String typeName = "HORSE";

        // When & Then
        assertThat(PieceType.findByName(typeName)).isEqualTo(PieceType.HORSE);
    }

    @Test
    void 타입의_이름으로부터_상의_PieceType을_찾아서_가져온다() {
        // Given
        String typeName = "ELEPHANT";

        // When & Then
        assertThat(PieceType.findByName(typeName)).isEqualTo(PieceType.ELEPHANT);
    }
}
