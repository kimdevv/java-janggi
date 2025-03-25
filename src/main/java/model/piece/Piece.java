package model.piece;

import java.util.List;
import java.util.Objects;

public abstract class Piece {

    protected Position position;

    public Piece(final Position position) {
        this.position = position;
    }

    public void changePosition(final Position position) {
        this.position = position;
    }

    public abstract List<Position> calculateRouteToDestination(final Position destination);

    public Position getPosition() {
        return position;
    }

    public abstract PieceType getPieceType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return Objects.equals(position, piece.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
