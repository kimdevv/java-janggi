package model.piece;

import model.position.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PiecesTest {

    @Test
    void RED_팀의_기물들을_생성한다() {
        // Given
        Pieces redPieces = Pieces.initializerRedTeamPieces();

        // When & Then
        assertThat(redPieces.getPieces()).containsExactlyInAnyOrder(
                new General(new Position(1, 4)),
                new Guard(new Position(0, 3)),
                new Guard(new Position(0, 5)),
                new Elephant(new Position(0, 2)),
                new Elephant(new Position(0, 6)),
                new Horse(new Position(0, 1)),
                new Horse(new Position(0, 7)),
                new Chariot(new Position(0, 0)),
                new Chariot(new Position(0, 8)),
                new Cannon(new Position(2, 1)),
                new Cannon(new Position(2, 7)),
                new Byeong(new Position(3, 0)),
                new Byeong(new Position(3, 2)),
                new Byeong(new Position(3, 4)),
                new Byeong(new Position(3, 6)),
                new Byeong(new Position(3, 8))
        );
    }

    @Test
    void GREEN_팀의_기물들을_생성한다() {
        // Given
        Pieces greenPieces = Pieces.initializerGreenTeamPieces();

        // When & Then
        assertThat(greenPieces.getPieces()).containsExactlyInAnyOrder(
                new General(new Position(8, 4)),
                new Guard(new Position(9, 3)),
                new Guard(new Position(9, 5)),
                new Elephant(new Position(9, 2)),
                new Elephant(new Position(9, 6)),
                new Horse(new Position(9, 1)),
                new Horse(new Position(9, 7)),
                new Chariot(new Position(9, 0)),
                new Chariot(new Position(9, 8)),
                new Cannon(new Position(7, 1)),
                new Cannon(new Position(7, 7)),
                new Jol(new Position(6, 0)),
                new Jol(new Position(6, 2)),
                new Jol(new Position(6, 4)),
                new Jol(new Position(6, 6)),
                new Jol(new Position(6, 8))
        );
    }
}
