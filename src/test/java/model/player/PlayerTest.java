package model.player;

import model.piece.Piece;
import model.piece.PieceType;
import model.piece.Pieces;
import model.piece.moveRule.ByeongMoveRule;
import model.piece.moveRule.CannonMoveRule;
import model.piece.moveRule.ChariotMoveRule;
import model.piece.moveRule.ElephantMoveRule;
import model.piece.moveRule.GeneralMoveRule;
import model.piece.moveRule.GuardMoveRule;
import model.piece.moveRule.HorseMoveRule;
import model.piece.position.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @Test
    void 플레이어가_가진_기물에서_해당_위치에_기물이_있다면_찾는다() {
        // Given
        Pieces pieces = Pieces.initializeRedTeamPieces();
        Player player = new Player(pieces, Team.RED);

        // When & Then
        assertThat(player.findPieceAt(new Position(1, 4)))
                .isEqualTo(new Piece(PieceType.GENERAL, new GeneralMoveRule(new Position(1, 4))));
    }

    @Test
    void 플레이어가_가진_기물에서_기물이_존재하지_않는_위치로_기물을_찾으면_예외가_발생한다() {
        // Given
        Pieces pieces = Pieces.initializeRedTeamPieces();
        Player player = new Player(pieces, Team.RED);

        // When & Then
        assertThatThrownBy(() -> player.findPieceAt(new Position(2, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 위치에 기물이 존재하지 않습니다.");
    }

    @Test
    void 플레이어가_가진_기물에서_해당_경로에_기물이_존재하는지_확인한다() {
        // Given
        Pieces pieces = Pieces.initializeRedTeamPieces();
        Player player = new Player(pieces, Team.RED);
        List<Position> route = List.of(
                new Position(0, 4),
                new Position(1, 4),
                new Position(2, 4)
        );

        // When & Then
        assertThat(player.isPieceExistAtRoute(route)).isEqualTo(true);
    }

    @Test
    void 플레이어가_가진_기물에서_해당_경로에_기물이_존재하지_않는_경우() {
        // Given
        Pieces pieces = Pieces.initializeRedTeamPieces();
        Player player = new Player(pieces, Team.RED);
        List<Position> route = List.of(
                new Position(4, 0),
                new Position(4, 1),
                new Position(4, 2),
                new Position(4, 3),
                new Position(4, 4)
        );

        // When & Then
        assertThat(player.isPieceExistAtRoute(route)).isEqualTo(false);
    }

    @CsvSource({
            "1, 4, true",
            "2, 4, false"
    })
    @ParameterizedTest
    void 플레이어가_가진_기물에서_해당_위치에_궁이_존재하는지_확인한다(int row, int column, boolean expected) {
        // Given
        Pieces pieces = Pieces.initializeRedTeamPieces();
        Player player = new Player(pieces, Team.RED);
        Position position = new Position(row, column);

        // When & Then
        assertThat(player.isGeneralExistAt(position)).isEqualTo(expected);
    }

    @CsvSource({
            "1, 4, true",
            "2, 4, false"
    })
    @ParameterizedTest
    void 플레이어가_가진_기물에서_해당_위치에_기물이_존재하는지_확인한다(int row, int column, boolean expected) {
        // Given
        Pieces pieces = Pieces.initializeRedTeamPieces();
        Player player = new Player(pieces, Team.RED);
        Position position = new Position(row, column);

        // When & Then
        assertThat(player.isPieceExistAt(position)).isEqualTo(expected);
    }

    @Test
    void 플레이어가_가진_기물에서_주어진_위치의_기물을_삭제한다() {
        // Given
        Pieces pieces = Pieces.initializeRedTeamPieces();
        Player player = new Player(pieces, Team.RED);

        // When
        player.removePieceAt(new Position(1, 4));

        // Then
        assertThat(player.getPieces().getPieces()).containsExactlyInAnyOrder(
                new Piece(PieceType.GUARD, new GuardMoveRule(new Position(0, 3))),
                new Piece(PieceType.GUARD, new GuardMoveRule(new Position(0, 5))),
                new Piece(PieceType.ELEPHANT, new ElephantMoveRule(new Position(0, 2))),
                new Piece(PieceType.ELEPHANT, new ElephantMoveRule(new Position(0, 6))),
                new Piece(PieceType.HORSE, new HorseMoveRule(new Position(0, 1))),
                new Piece(PieceType.HORSE, new HorseMoveRule(new Position(0, 7))),
                new Piece(PieceType.CHARIOT, new ChariotMoveRule(new Position(0, 0))),
                new Piece(PieceType.CHARIOT, new ChariotMoveRule(new Position(0, 8))),
                new Piece(PieceType.CANNON, new CannonMoveRule(new Position(2, 1))),
                new Piece(PieceType.CANNON, new CannonMoveRule(new Position(2, 7))),
                new Piece(PieceType.BYEONG, new ByeongMoveRule(new Position(3, 0))),
                new Piece(PieceType.BYEONG, new ByeongMoveRule(new Position(3, 2))),
                new Piece(PieceType.BYEONG, new ByeongMoveRule(new Position(3, 4))),
                new Piece(PieceType.BYEONG, new ByeongMoveRule(new Position(3, 6))),
                new Piece(PieceType.BYEONG, new ByeongMoveRule(new Position(3, 8)))
        );
    }

    @Test
    void 플레이어가_가진_기물에서_해당_경로_내에_있는_기물의_수를_계산한다() {
        // Given
        Pieces pieces = Pieces.initializeRedTeamPieces();
        Player player = new Player(pieces, Team.RED);

        // When
        int countOfPiecesAtRoute = player.countPiecesAtRoute(List.of(
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
    void 플레이어가_가진_기물에서_해당_경로에_포가_있는지_검사한다() {
        // Given
        Pieces pieces = Pieces.initializeRedTeamPieces();
        Player player = new Player(pieces, Team.RED);
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
        assertThat(player.isCannonExistAtRoute(routeIncludeCannon)).isTrue();
        assertThat(player.isCannonExistAtRoute(routeExcludeCannon)).isFalse();
    }

    @CsvSource({
            "2, 1, true",
            "3, 1, false"
    })
    @ParameterizedTest
    void 플레이어가_가진_기물에서_해당_위치에_포가_있는지_검사한다(int row, int column, boolean expected) {
        // Given
        Pieces pieces = Pieces.initializeRedTeamPieces();
        Player player = new Player(pieces, Team.RED);
        Position position = new Position(row, column);

        // When & Then
        assertThat(player.isCannonExistAt(position)).isEqualTo(expected);
    }
}
