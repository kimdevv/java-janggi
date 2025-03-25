package model.piece;

import model.piece.position.Position;

import java.util.List;
import java.util.Objects;

public abstract class Piece {

    protected Position position;

    public Piece(final Position position) {
        this.position = position;
    }

    public final void changePosition(final Position position) {
        this.position = position;
    }

    public final List<Position> calculateRouteToDestination(final Position destination) {
        if (isPieceCanGo(destination)) {
            return findRouteToDestination(destination);
        }
        throw new IllegalArgumentException("현재 기물이 이동할 수 없는 위치입니다.");
    }

    protected abstract boolean isPieceCanGo(final Position destination);

    protected abstract List<Position> findRouteToDestination(final Position destination);

    public final Position getPosition() {
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
