package model.piece;

import model.piece.moveRule.MoveRule;
import model.piece.position.Position;

import java.util.List;
import java.util.Objects;

public class Piece {

    private final PieceType pieceType;
    private final MoveRule moveRule;

    public Piece(final PieceType pieceType, final MoveRule moveRule) {
        this.pieceType = pieceType;
        this.moveRule = moveRule;
    }

    public List<Position> calculateRouteToDestination(final Position destination) {
        return moveRule.calculateRouteToDestination(destination);
    }

    public void changePosition(final Position position) {
        moveRule.changePosition(position);
    }

    public Position getPosition() {
        return moveRule.getCurrentPosition();
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return pieceType == piece.pieceType && Objects.equals(moveRule, piece.moveRule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceType, moveRule);
    }
}
