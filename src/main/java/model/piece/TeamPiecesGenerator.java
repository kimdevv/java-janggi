package model.piece;

import java.util.List;

import static model.piece.position.DefaultPiecePositions.*;

public class TeamPiecesGenerator {

    public static List<Piece> generateRedTeamPieces() {
        return List.of(
                Piece.generateGeneral(GENERAL_RED.getPosition()),
                Piece.generateGuard(GUARD_LEFT_RED.getPosition()),
                Piece.generateGuard(GUARD_RIGHT_RED.getPosition()),
                Piece.generateElephant(ELEPHANT_LEFT_RED.getPosition()),
                Piece.generateElephant(ELEPHANT_RIGHT_RED.getPosition()),
                Piece.generateHorse(HORSE_LEFT_RED.getPosition()),
                Piece.generateHorse(HORSE_RIGHT_RED.getPosition()),
                Piece.generateChariot(CHARIOT_LEFT_RED.getPosition()),
                Piece.generateChariot(CHARIOT_RIGHT_RED.getPosition()),
                Piece.generateCannon(CANNON_LEFT_RED.getPosition()),
                Piece.generateCannon(CANNON_RIGHT_RED.getPosition()),
                Piece.generateByeong(BYEONG_FIRST_RED.getPosition()),
                Piece.generateByeong(BYEONG_SECOND_RED.getPosition()),
                Piece.generateByeong(BYEONG_THIRD_RED.getPosition()),
                Piece.generateByeong(BYEONG_FOURTH_RED.getPosition()),
                Piece.generateByeong(BYEONG_FIFTH_RED.getPosition())
        );
    }

    public static List<Piece> generateGreenTeamPieces() {
        return List.of(
                Piece.generateGeneral(GENERAL_GREEN.getPosition()),
                Piece.generateGuard(GUARD_LEFT_GREEN.getPosition()),
                Piece.generateGuard(GUARD_RIGHT_GREEN.getPosition()),
                Piece.generateElephant(ELEPHANT_LEFT_GREEN.getPosition()),
                Piece.generateElephant(ELEPHANT_RIGHT_GREEN.getPosition()),
                Piece.generateHorse(HORSE_LEFT_GREEN.getPosition()),
                Piece.generateHorse(HORSE_RIGHT_GREEN.getPosition()),
                Piece.generateChariot(CHARIOT_LEFT_GREEN.getPosition()),
                Piece.generateChariot(CHARIOT_RIGHT_GREEN.getPosition()),
                Piece.generateCannon(CANNON_LEFT_GREEN.getPosition()),
                Piece.generateCannon(CANNON_RIGHT_GREEN.getPosition()),
                Piece.generateJol(JOL_FIRST_GREEN.getPosition()),
                Piece.generateJol(JOL_SECOND_GREEN.getPosition()),
                Piece.generateJol(JOL_THIRD_GREEN.getPosition()),
                Piece.generateJol(JOL_FOURTH_GREEN.getPosition()),
                Piece.generateJol(JOL_FIFTH_GREEN.getPosition())
        );
    }
}
