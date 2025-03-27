package model.piece.moveRule;

import model.piece.position.Position;

import java.util.List;

public interface MoveRule {

    List<Position> calculateRouteToDestination(final Position destination);

    boolean canPieceMoveTo(final Position position);

    List<Position> findRouteToDestination(final Position destination);

    void changePosition(final Position position);

    Position getPosition();

}
