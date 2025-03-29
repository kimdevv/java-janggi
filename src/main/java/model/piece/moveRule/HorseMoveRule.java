package model.piece.moveRule;

import model.piece.position.Position;

import java.util.ArrayList;
import java.util.List;

import static model.piece.position.MovementChecker.*;

class HorseMoveRule implements MoveRule {

    @Override
    public final List<Position> calculateRouteToDestination(final Position startPosition, final Position destination) {
        if (canPieceMove(startPosition, destination)) {
            return findRouteStepByStepToDestination(startPosition, destination);
        }
        throw new IllegalArgumentException("현재 기물이 이동할 수 없는 위치입니다.");
    }

    private boolean canPieceMove(final Position startPosition, final Position destination) {
        int rowStep = destination.calculateRowDifference(startPosition);
        int columnStep = destination.calculateColumnDifference(startPosition);
        return isUpUpLeft(rowStep, columnStep) || isUpUpRight(rowStep, columnStep)
                || isLeftLeftUp(rowStep, columnStep) || isLeftLeftDown(rowStep, columnStep)
                || isRightRightUp(rowStep, columnStep) || isRightRightDown(rowStep, columnStep)
                || isDownDownLeft(rowStep, columnStep) || isDownDownRight(rowStep, columnStep);
    }

    private List<Position> findRouteStepByStepToDestination(final Position startPosition, final Position destination) {
        int rowStep = destination.calculateRowDifference(startPosition);
        int columnStep = destination.calculateColumnDifference(startPosition);
        List<Position> route = new ArrayList<>();
        while (isStepRemain(rowStep, columnStep)) {
            route.add(startPosition.changeRowAndColumnIfPositionInBoard(rowStep, columnStep));
            rowStep = AbsoluteValueDecreaser.decreaseOne(rowStep);
            columnStep = AbsoluteValueDecreaser.decreaseOne(columnStep);
        }
        return route;
    }

    private boolean isStepRemain(final int rowStep, final int columnStep) {
        return rowStep != 0 || columnStep != 0;
    }
}
