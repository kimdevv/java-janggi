package model.piece;

import model.position.Position;

import java.util.List;

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
}
