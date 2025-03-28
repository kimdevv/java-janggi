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

public class Piece {

    private final PieceType pieceType;
    private final MoveRule moveRule;
    private Position position;

    private Piece(final PieceType pieceType, final MoveRule moveRule, final Position position) {
        this.pieceType = pieceType;
        this.moveRule = moveRule;
        this.position = position;
    }

    public static Piece generateGeneral(final Position position) {
        return new Piece(PieceType.GENERAL, new GeneralMoveRule(), position);
    }

    public static Piece generateGuard(final Position position) {
        return new Piece(PieceType.GUARD, new GuardMoveRule(), position);
    }

    public static Piece generateElephant(final Position position) {
        return new Piece(PieceType.ELEPHANT, new ElephantMoveRule(), position);
    }

    public static Piece generateHorse(final Position position) {
        return new Piece(PieceType.HORSE, new HorseMoveRule(), position);
    }

    public static Piece generateChariot(final Position position) {
        return new Piece(PieceType.CHARIOT, new ChariotMoveRule(), position);
    }

    public static Piece generateCannon(final Position position) {
        return new Piece(PieceType.CANNON, new CannonMoveRule(), position);
    }

    public static Piece generateByeong(final Position position) {
        return new Piece(PieceType.BYEONG, new ByeongMoveRule(), position);
    }

    public static Piece generateJol(final Position position) {
        return new Piece(PieceType.JOL, new JolMoveRule(), position);
    }

    public List<Position> calculateRouteToDestination(final Position destination) {
        return moveRule.calculateRouteToDestination(position, destination);
    }

    public void changePosition(final Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return pieceType == piece.pieceType && Objects.equals(position, piece.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceType, position);
    }
}
