package model.piece.moveRule;

import model.piece.position.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static model.piece.position.MovementChecker.isDownDownLeft;
import static model.piece.position.MovementChecker.isDownDownRight;
import static model.piece.position.MovementChecker.isLeftLeftDown;
import static model.piece.position.MovementChecker.isLeftLeftUp;
import static model.piece.position.MovementChecker.isRightRightDown;
import static model.piece.position.MovementChecker.isRightRightUp;
import static model.piece.position.MovementChecker.isUpUpLeft;
import static model.piece.position.MovementChecker.isUpUpRight;

public class HorseMoveRule implements MoveRule {

    private Position position;

    public HorseMoveRule(final Position position) {
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
        return isUpUpLeft(rowStep, columnStep) || isUpUpRight(rowStep, columnStep)
                || isLeftLeftUp(rowStep, columnStep) || isLeftLeftDown(rowStep, columnStep)
                || isRightRightUp(rowStep, columnStep) || isRightRightDown(rowStep, columnStep)
                || isDownDownLeft(rowStep, columnStep) || isDownDownRight(rowStep, columnStep);
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
        HorseMoveRule that = (HorseMoveRule) o;
        return Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
