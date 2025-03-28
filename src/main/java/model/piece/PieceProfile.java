package model.piece;

import model.piece.moveRule.ByeongMoveRule;
import model.piece.moveRule.CannonMoveRule;
import model.piece.moveRule.ChariotMoveRule;
import model.piece.moveRule.ElephantMoveRule;
import model.piece.moveRule.GeneralMoveRule;
import model.piece.moveRule.GuardMoveRule;
import model.piece.moveRule.HorseMoveRule;
import model.piece.moveRule.JolMoveRule;
import model.piece.moveRule.MoveRule;
import model.piece.position.Position;

import java.util.List;
import java.util.Objects;

public class PieceProfile {

    private final PieceType pieceType;
    private final MoveRule moveRule;

    private PieceProfile(final PieceType pieceType, final MoveRule moveRule) {
        this.pieceType = pieceType;
        this.moveRule = moveRule;
    }
    
    public static PieceProfile generateGeneralProfile() {
        return new PieceProfile(PieceType.GENERAL, new GeneralMoveRule());
    }

    public static PieceProfile generateGuardProfile() {
        return new PieceProfile(PieceType.GUARD, new GuardMoveRule());
    }

    public static PieceProfile generateElephantProfile() {
        return new PieceProfile(PieceType.ELEPHANT, new ElephantMoveRule());
    }

    public static PieceProfile generateHorseProfile() {
        return new PieceProfile(PieceType.HORSE, new HorseMoveRule());
    }

    public static PieceProfile generateChariotProfile() {
        return new PieceProfile(PieceType.CHARIOT, new ChariotMoveRule());
    }

    public static PieceProfile generateCannonProfile() {
        return new PieceProfile(PieceType.CANNON, new CannonMoveRule());
    }

    public static PieceProfile generateByeongProfile() {
        return new PieceProfile(PieceType.BYEONG, new ByeongMoveRule());
    }

    public static PieceProfile generateJolProfile() {
        return new PieceProfile(PieceType.JOL, new JolMoveRule());
    }

    public List<Position> calculateRouteToDestination(final Position startPosition, final Position destination) {
        return moveRule.calculateRouteToDestination(startPosition, destination);
    }

    PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PieceProfile that = (PieceProfile) o;
        return pieceType == that.pieceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceType);
    }
}
