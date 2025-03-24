package model.piece;

import model.position.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 해당_위치에_기물이_있다면_찾는다() {
        // Given
        Pieces pieces = Pieces.initializerRedTeamPieces();

        // When & Then
        assertThat(pieces.findPieceAt(new Position(1, 4)))
                .isEqualTo(new General(new Position(1, 4)));
    }

    @Test
    void 기물이_존재하지_않는_위치로_기물을_찾으면_예외가_발생한다() {
        // Given
        Pieces pieces = Pieces.initializerRedTeamPieces();

        // When & Then
        assertThatThrownBy(() -> pieces.findPieceAt(new Position(2, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 위치에 기물이 존재하지 않습니다.");
    }

    @CsvSource({
            "1, 4, true",
            "2, 4, false"
    })
    @ParameterizedTest
    void 기물이_존재하는지_확인한다(int row, int column, boolean expected) {
        // Given
        Pieces pieces = Pieces.initializerRedTeamPieces();
        Position position = new Position(row, column);

        // When & Then
        assertThat(pieces.isPieceExistAt(position)).isEqualTo(expected);
    }

    @Test
    void 해당_경로에_기물이_존재하는지_확인한다() {
        // Given
        Pieces pieces = Pieces.initializerRedTeamPieces();
        List<Position> route = List.of(
                new Position(0, 4),
                new Position(1, 4),
                new Position(2, 4)
        );

        // When & Then
        assertThat(pieces.isPieceExistAtRoute(route)).isEqualTo(true);
    }

    @Test
    void 해당_경로에_기물이_존재하지_않는_경우() {
        // Given
        Pieces pieces = Pieces.initializerRedTeamPieces();
        List<Position> route = List.of(
                new Position(4, 0),
                new Position(4, 1),
                new Position(4, 2),
                new Position(4, 3),
                new Position(4, 4)
        );

        // When & Then
        assertThat(pieces.isPieceExistAtRoute(route)).isEqualTo(false);
    }

    @Test
    void 주어진_위치의_기물을_삭제한다() {
        // Given
        Pieces pieces = Pieces.initializerRedTeamPieces();

        // When
        pieces.removePieceAt(new Position(1, 4));

        // Then
        assertThat(pieces.getPieces()).containsExactlyInAnyOrder(
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
    void 해당_경로_내에_있는_기물의_수를_계산한다() {
        // Given
        Pieces pieces = Pieces.initializerRedTeamPieces();

        // When
        int countOfPiecesAtRoute = pieces.countPiecesAtRoute(List.of(
                new Position(0, 0),
                new Position(0, 1),
                new Position(0, 2),
                new Position(0, 3),
                new Position(0, 4),
                new Position(0, 5)
        ));

        // Then
        assertThat(countOfPiecesAtRoute).isEqualTo(5);
    }

    @Test
    void 해당_경로에_포가_있는지_검사한다() {
        // Given
        Pieces pieces = Pieces.initializerRedTeamPieces();
        List<Position> routeIncludeCannon = List.of(
                new Position(1, 1),
                new Position(2, 1),
                new Position(3, 1),
                new Position(4, 1)
        );
        List<Position> routeExcludeCannon = List.of(
                new Position(3, 1),
                new Position(4, 1),
                new Position(5, 1),
                new Position(6, 1)
        );

        // When & Then
        assertThat(pieces.isCannonExistAtRoute(routeIncludeCannon)).isTrue();
        assertThat(pieces.isCannonExistAtRoute(routeExcludeCannon)).isFalse();
    }
}
