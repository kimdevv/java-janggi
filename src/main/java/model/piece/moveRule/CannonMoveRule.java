package model.piece.moveRule;

import model.piece.position.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static model.piece.position.MovementChecker.isDown;
import static model.piece.position.MovementChecker.isDownLeft;
import static model.piece.position.MovementChecker.isDownLeftStraight;
import static model.piece.position.MovementChecker.isDownRight;
import static model.piece.position.MovementChecker.isDownRightStraight;
import static model.piece.position.MovementChecker.isDownStraight;
import static model.piece.position.MovementChecker.isLeft;
import static model.piece.position.MovementChecker.isLeftStraight;
import static model.piece.position.MovementChecker.isRight;
import static model.piece.position.MovementChecker.isRightStraight;
import static model.piece.position.MovementChecker.isUp;
import static model.piece.position.MovementChecker.isUpLeft;
import static model.piece.position.MovementChecker.isUpLeftStraight;
import static model.piece.position.MovementChecker.isUpRight;
import static model.piece.position.MovementChecker.isUpRightStraight;
import static model.piece.position.MovementChecker.isUpStraight;

public class CannonMoveRule implements MoveRule {

    private Position position;

    public CannonMoveRule(final Position position) {
        this.position = position;
    }

    @Override
    public final List<Position> calculateRouteToDestination(final Position destination) {
        if (canPieceMoveTo(destination)) {
            return findRouteToDestination(destination);
        }
        throw new IllegalArgumentException("현재 기물이 이동할 수 없는 위치입니다.");
    }

    @Override
    public boolean canPieceMoveTo(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        if (position.isInPalace()) {
            return isUpStraight(rowStep, columnStep) && !isUp(rowStep, columnStep)
                    || isLeftStraight(rowStep, columnStep) && !isLeft(rowStep, columnStep)
                    || isRightStraight(rowStep, columnStep) && !isRight(rowStep, columnStep)
                    || isDownStraight(rowStep, columnStep) && !isDown(rowStep, columnStep)
                    || isUpLeftStraight(rowStep, columnStep) && !isUpLeft(rowStep, columnStep) && destination.isInPalace()
                    || isUpRightStraight(rowStep, columnStep)&& !isUpRight(rowStep, columnStep) && destination.isInPalace()
                    || isDownLeftStraight(rowStep, columnStep) && !isDownLeft(rowStep, columnStep) && destination.isInPalace()
                    || isDownRightStraight(rowStep, columnStep) && !isDownRight(rowStep, columnStep) && destination.isInPalace();
        }
        return (isUpStraight(rowStep, columnStep) && !isUp(rowStep, columnStep))
                || (isLeftStraight(rowStep, columnStep) && !isLeft(rowStep, columnStep))
                || (isRightStraight(rowStep, columnStep) && !isRight(rowStep, columnStep))
                || (isDownStraight(rowStep, columnStep) && !isDown(rowStep, columnStep));
    }

    @Override
    public final List<Position> findRouteToDestination(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        List<Position> route = new ArrayList<>();
        while (isStepRemain(rowStep, columnStep)) {
            route.add(moveStepIfDestinationInBoard(rowStep, columnStep));
            rowStep = decreaseOneAbsoluteValue(rowStep);
            columnStep = decreaseOneAbsoluteValue(columnStep);
        }
        return route;
    }

    private int decreaseOneAbsoluteValue(final int number) {
        if (number < 0) {
            return number + 1;
        }
        if (number > 0) {
            return number - 1;
        }
        return number;
    }

    private boolean isStepRemain(final int rowStep, final int columnStep) {
        return rowStep != 0 || columnStep != 0;
    }

    private Position moveStepIfDestinationInBoard(final int rowStep, final int columnStep) {
        if (position.canChangeOfRowAndColumn(rowStep, columnStep)) {
            return position.changeRowAndColumn(rowStep, columnStep);
        }
        throw new IllegalArgumentException("10x9 범위를 벗어났습니다.");
    }

    @Override
    public void changePosition(final Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CannonMoveRule that = (CannonMoveRule) o;
        return Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
