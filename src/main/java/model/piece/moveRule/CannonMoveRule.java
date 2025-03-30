package model.piece.moveRule;

import model.piece.position.Position;

import java.util.ArrayList;
import java.util.List;

import static model.piece.position.MovementChecker.*;

class CannonMoveRule implements MoveRule {

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
        if (startPosition.isInPalace() && destination.isInPalace()) {
            return canPieceMoveInsidePalace(rowStep, columnStep);
        }
        return canPieceMoveOutsidePalace(rowStep, columnStep);
    }

    private boolean canPieceMoveInsidePalace(final int rowStep, final int columnStep) {
        return canPieceMoveOutsidePalace(rowStep, columnStep)
                || (isUpLeftStraight(rowStep, columnStep) && !isUpLeft(rowStep, columnStep))
                || (isUpRightStraight(rowStep, columnStep) && !isUpRight(rowStep, columnStep))
                || (isDownLeftStraight(rowStep, columnStep) && !isDownLeft(rowStep, columnStep))
                || (isDownRightStraight(rowStep, columnStep) && !isDownRight(rowStep, columnStep));
    }

    private boolean canPieceMoveOutsidePalace(final int rowStep, final int columnStep) {
        return (isUpStraight(rowStep, columnStep) && !isUp(rowStep, columnStep))
                || (isLeftStraight(rowStep, columnStep) && !isLeft(rowStep, columnStep))
                || (isRightStraight(rowStep, columnStep) && !isRight(rowStep, columnStep))
                || (isDownStraight(rowStep, columnStep) && !isDown(rowStep, columnStep));
    }

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
