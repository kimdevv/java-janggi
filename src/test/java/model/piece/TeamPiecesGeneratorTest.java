package model.piece;

import org.junit.jupiter.api.Test;

import static model.piece.position.DefaultPiecePositions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TeamPiecesGeneratorTest {

    @Test
    void GREEN_팀의_기물_리스트를_생성한다() {
        // Given
        // When
        // Then
        assertThat(TeamPiecesGenerator.generateGreenTeamPieces())
                .containsExactlyInAnyOrder(
                        new Piece(PieceProfile.generateFromPieceType(PieceType.GENERAL), GENERAL_GREEN.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.GUARD), GUARD_LEFT_GREEN.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.GUARD), GUARD_RIGHT_GREEN.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.ELEPHANT), ELEPHANT_LEFT_GREEN.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.ELEPHANT), ELEPHANT_RIGHT_GREEN.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.HORSE), HORSE_LEFT_GREEN.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.HORSE), HORSE_RIGHT_GREEN.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.CHARIOT), CHARIOT_LEFT_GREEN.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.CHARIOT), CHARIOT_RIGHT_GREEN.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.CANNON), CANNON_LEFT_GREEN.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.CANNON), CANNON_RIGHT_GREEN.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.JOL), JOL_FIRST_GREEN.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.JOL), JOL_SECOND_GREEN.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.JOL), JOL_THIRD_GREEN.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.JOL), JOL_FOURTH_GREEN.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.JOL), JOL_FIFTH_GREEN.getPosition())
                );
    }

    @Test
    void RED_팀의_기물_리스트를_생성한다() {
        // Given
        // When
        // Then
        assertThat(TeamPiecesGenerator.generateRedTeamPieces())
                .containsExactlyInAnyOrder(
                        new Piece(PieceProfile.generateFromPieceType(PieceType.GENERAL), GENERAL_RED.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.GUARD), GUARD_LEFT_RED.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.GUARD), GUARD_RIGHT_RED.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.ELEPHANT), ELEPHANT_LEFT_RED.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.ELEPHANT), ELEPHANT_RIGHT_RED.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.HORSE), HORSE_LEFT_RED.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.HORSE), HORSE_RIGHT_RED.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.CHARIOT), CHARIOT_LEFT_RED.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.CHARIOT), CHARIOT_RIGHT_RED.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.CANNON), CANNON_LEFT_RED.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.CANNON), CANNON_RIGHT_RED.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.BYEONG), BYEONG_FIRST_RED.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.BYEONG), BYEONG_SECOND_RED.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.BYEONG), BYEONG_THIRD_RED.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.BYEONG), BYEONG_FOURTH_RED.getPosition()),
                        new Piece(PieceProfile.generateFromPieceType(PieceType.BYEONG), BYEONG_FIFTH_RED.getPosition())
                );
    }
}
