package model.piece.moveRule;

import model.piece.position.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class MultiStepMoveRule implements MoveRule {

    @Override
    public final List<Position> calculateRouteToDestination(final Position startPosition, final Position destination) {
        if (canPieceMove(startPosition, destination)) {
            return findRouteStepByStepToDestination(startPosition, destination);
        }
        throw new IllegalArgumentException("현재 기물이 이동할 수 없는 위치입니다.");
    }

    protected abstract boolean canPieceMove(final Position startPosition, final Position destination);

    private List<Position> findRouteStepByStepToDestination(final Position startPosition, final Position destination) {
        int rowStep = destination.calculateRowDifference(startPosition);
        int columnStep = destination.calculateColumnDifference(startPosition);
        List<Position> route = new ArrayList<>();
        while (isStepRemain(rowStep, columnStep)) {
            route.add(startPosition.moveIfDestinationIsValid(rowStep, columnStep));
            rowStep = AbsoluteValueDecreaser.decreaseOne(rowStep);
            columnStep = AbsoluteValueDecreaser.decreaseOne(columnStep);
        }
        return route;
    }

    private boolean isStepRemain(final int rowStep, final int columnStep) {
        return rowStep != 0 || columnStep != 0;
    }

}
