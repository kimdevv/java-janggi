package model.piece;

import model.piece.moveRule.ByeongMoveRule;
import model.piece.moveRule.CannonMoveRule;
import model.piece.moveRule.ChariotMoveRule;
import model.piece.moveRule.ElephantMoveRule;
import model.piece.moveRule.GeneralMoveRule;
import model.piece.moveRule.GuardMoveRule;
import model.piece.moveRule.HorseMoveRule;
import model.piece.moveRule.JolMoveRule;

import java.util.List;

import static model.piece.position.DefaultPiecePositions.*;

public class DefaultPiecesGenerator {

    public static List<Piece> generateRedTeamPieces() {
        return List.of(
                new Piece(GENERAL_RED.getPieceType(), new GeneralMoveRule(GENERAL_RED.getPosition())),
                new Piece(GUARD_LEFT_RED.getPieceType(), new GuardMoveRule(GUARD_LEFT_RED.getPosition())),
                new Piece(GUARD_RIGHT_RED.getPieceType(), new GuardMoveRule(GUARD_RIGHT_RED.getPosition())),
                new Piece(ELEPHANT_LEFT_RED.getPieceType(), new ElephantMoveRule(ELEPHANT_LEFT_RED.getPosition())),
                new Piece(ELEPHANT_RIGHT_RED.getPieceType(), new ElephantMoveRule(ELEPHANT_RIGHT_RED.getPosition())),
                new Piece(HORSE_LEFT_RED.getPieceType(), new HorseMoveRule(HORSE_LEFT_RED.getPosition())),
                new Piece(HORSE_RIGHT_RED.getPieceType(), new HorseMoveRule(HORSE_RIGHT_RED.getPosition())),
                new Piece(CHARIOT_LEFT_RED.getPieceType(), new ChariotMoveRule(CHARIOT_LEFT_RED.getPosition())),
                new Piece(CHARIOT_RIGHT_RED.getPieceType(), new ChariotMoveRule(CHARIOT_RIGHT_RED.getPosition())),
                new Piece(CANNON_LEFT_RED.getPieceType(), new CannonMoveRule(CANNON_LEFT_RED.getPosition())),
                new Piece(CANNON_RIGHT_RED.getPieceType(), new CannonMoveRule(CANNON_RIGHT_RED.getPosition())),
                new Piece(BYEONG_FIRST_RED.getPieceType(), new ByeongMoveRule(BYEONG_FIRST_RED.getPosition())),
                new Piece(BYEONG_SECOND_RED.getPieceType(), new ByeongMoveRule(BYEONG_SECOND_RED.getPosition())),
                new Piece(BYEONG_THIRD_RED.getPieceType(), new ByeongMoveRule(BYEONG_THIRD_RED.getPosition())),
                new Piece(BYEONG_FOURTH_RED.getPieceType(), new ByeongMoveRule(BYEONG_FOURTH_RED.getPosition())),
                new Piece(BYEONG_FIFTH_RED.getPieceType(), new ByeongMoveRule(BYEONG_FIFTH_RED.getPosition()))
        );
    }

    public static List<Piece> generateGreenTeamPieces() {
        return List.of(
                new Piece(GENERAL_GREEN.getPieceType(), new GeneralMoveRule(GENERAL_GREEN.getPosition())),
                new Piece(GUARD_LEFT_GREEN.getPieceType(), new GuardMoveRule(GUARD_LEFT_GREEN.getPosition())),
                new Piece(GUARD_RIGHT_GREEN.getPieceType(), new GuardMoveRule(GUARD_RIGHT_GREEN.getPosition())),
                new Piece(ELEPHANT_LEFT_GREEN.getPieceType(), new ElephantMoveRule(ELEPHANT_LEFT_GREEN.getPosition())),
                new Piece(ELEPHANT_RIGHT_GREEN.getPieceType(), new ElephantMoveRule(ELEPHANT_RIGHT_GREEN.getPosition())),
                new Piece(HORSE_LEFT_GREEN.getPieceType(), new HorseMoveRule(HORSE_LEFT_GREEN.getPosition())),
                new Piece(HORSE_RIGHT_GREEN.getPieceType(), new HorseMoveRule(HORSE_RIGHT_GREEN.getPosition())),
                new Piece(CHARIOT_LEFT_GREEN.getPieceType(), new ChariotMoveRule(CHARIOT_LEFT_GREEN.getPosition())),
                new Piece(CHARIOT_RIGHT_GREEN.getPieceType(), new ChariotMoveRule(CHARIOT_RIGHT_GREEN.getPosition())),
                new Piece(CANNON_LEFT_GREEN.getPieceType(), new CannonMoveRule(CANNON_LEFT_GREEN.getPosition())),
                new Piece(CANNON_RIGHT_GREEN.getPieceType(), new CannonMoveRule(CANNON_RIGHT_GREEN.getPosition())),
                new Piece(JOL_FIRST_GREEN.getPieceType(), new JolMoveRule(JOL_FIRST_GREEN.getPosition())),
                new Piece(JOL_SECOND_GREEN.getPieceType(), new JolMoveRule(JOL_SECOND_GREEN.getPosition())),
                new Piece(JOL_THIRD_GREEN.getPieceType(), new JolMoveRule(JOL_THIRD_GREEN.getPosition())),
                new Piece(JOL_FOURTH_GREEN.getPieceType(), new JolMoveRule(JOL_FOURTH_GREEN.getPosition())),
                new Piece(JOL_FIFTH_GREEN.getPieceType(), new JolMoveRule(JOL_FIFTH_GREEN.getPosition()))
        );
    }
}
