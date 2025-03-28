package model.piece;

import java.util.List;

import static model.piece.position.DefaultPiecePositions.*;

public class TeamPiecesGenerator {

    public static List<Piece> generateRedTeamPieces() {
        return List.of(
                new Piece(PieceProfile.generateGeneralProfile(), GENERAL_RED.getPosition()),
                new Piece(PieceProfile.generateGuardProfile(), GUARD_LEFT_RED.getPosition()),
                new Piece(PieceProfile.generateGuardProfile(), GUARD_RIGHT_RED.getPosition()),
                new Piece(PieceProfile.generateElephantProfile(), ELEPHANT_LEFT_RED.getPosition()),
                new Piece(PieceProfile.generateElephantProfile(), ELEPHANT_RIGHT_RED.getPosition()),
                new Piece(PieceProfile.generateHorseProfile(), HORSE_LEFT_RED.getPosition()),
                new Piece(PieceProfile.generateHorseProfile(), HORSE_RIGHT_RED.getPosition()),
                new Piece(PieceProfile.generateChariotProfile(), CHARIOT_LEFT_RED.getPosition()),
                new Piece(PieceProfile.generateChariotProfile(), CHARIOT_RIGHT_RED.getPosition()),
                new Piece(PieceProfile.generateCannonProfile(), CANNON_LEFT_RED.getPosition()),
                new Piece(PieceProfile.generateCannonProfile(), CANNON_RIGHT_RED.getPosition()),
                new Piece(PieceProfile.generateByeongProfile(), BYEONG_FIRST_RED.getPosition()),
                new Piece(PieceProfile.generateByeongProfile(), BYEONG_SECOND_RED.getPosition()),
                new Piece(PieceProfile.generateByeongProfile(), BYEONG_THIRD_RED.getPosition()),
                new Piece(PieceProfile.generateByeongProfile(), BYEONG_FOURTH_RED.getPosition()),
                new Piece(PieceProfile.generateByeongProfile(), BYEONG_FIFTH_RED.getPosition())
        );
    }

    public static List<Piece> generateGreenTeamPieces() {
        return List.of(
                new Piece(PieceProfile.generateGeneralProfile(), GENERAL_GREEN.getPosition()),
                new Piece(PieceProfile.generateGuardProfile(), GUARD_LEFT_GREEN.getPosition()),
                new Piece(PieceProfile.generateGuardProfile(), GUARD_RIGHT_GREEN.getPosition()),
                new Piece(PieceProfile.generateElephantProfile(), ELEPHANT_LEFT_GREEN.getPosition()),
                new Piece(PieceProfile.generateElephantProfile(), ELEPHANT_RIGHT_GREEN.getPosition()),
                new Piece(PieceProfile.generateHorseProfile(), HORSE_LEFT_GREEN.getPosition()),
                new Piece(PieceProfile.generateHorseProfile(), HORSE_RIGHT_GREEN.getPosition()),
                new Piece(PieceProfile.generateChariotProfile(), CHARIOT_LEFT_GREEN.getPosition()),
                new Piece(PieceProfile.generateChariotProfile(), CHARIOT_RIGHT_GREEN.getPosition()),
                new Piece(PieceProfile.generateCannonProfile(), CANNON_LEFT_GREEN.getPosition()),
                new Piece(PieceProfile.generateCannonProfile(), CANNON_RIGHT_GREEN.getPosition()),
                new Piece(PieceProfile.generateJolProfile(), JOL_FIRST_GREEN.getPosition()),
                new Piece(PieceProfile.generateJolProfile(), JOL_SECOND_GREEN.getPosition()),
                new Piece(PieceProfile.generateJolProfile(), JOL_THIRD_GREEN.getPosition()),
                new Piece(PieceProfile.generateJolProfile(), JOL_FOURTH_GREEN.getPosition()),
                new Piece(PieceProfile.generateJolProfile(), JOL_FIFTH_GREEN.getPosition())
        );
    }
}
