package model.piece.moveRule;

import model.piece.AbsolutevalueDecreaser;
import model.piece.position.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static model.piece.position.MovementChecker.*;

public class ChariotMoveRule implements MoveRule {

    private Position position;

    public ChariotMoveRule(final Position position) {
        this.position = position;
    }

    @Override
    public final List<Position> calculateRouteToDestination(final Position destination) {
        if (canPieceMove(destination)) {
            return findRouteStepByStepToDestination(destination);
        }
        throw new IllegalArgumentException("현재 기물이 이동할 수 없는 위치입니다.");
    }

    private boolean canPieceMove(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        if (position.isInPalace()) {
            return canPieceInsidePalace(rowStep, columnStep, destination.isInPalace());
        }
        return canPieceOutsidePalace(rowStep, columnStep);
    }

    private boolean canPieceInsidePalace(final int rowStep, final int columnStep, final boolean isDestinationInPalace) {
        return canPieceOutsidePalace(rowStep, columnStep)
                || isUpLeftStraight(rowStep, columnStep) && isDestinationInPalace
                || isUpRightStraight(rowStep, columnStep) && isDestinationInPalace
                || isDownLeftStraight(rowStep, columnStep) && isDestinationInPalace
                || isDownRightStraight(rowStep, columnStep) && isDestinationInPalace;
    }

    private boolean canPieceOutsidePalace(final int rowStep, final int columnStep) {
        return isUpStraight(rowStep, columnStep)
                || isLeftStraight(rowStep, columnStep)
                || isRightStraight(rowStep, columnStep)
                || isDownStraight(rowStep, columnStep);
    }

    private List<Position> findRouteStepByStepToDestination(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        List<Position> route = new ArrayList<>();
        while (isStepRemain(rowStep, columnStep)) {
            route.add(position.changeRowAndColumnIfPositionInBoard(rowStep, columnStep));
            rowStep = AbsolutevalueDecreaser.decreaseOne(rowStep);
            columnStep = AbsolutevalueDecreaser.decreaseOne(columnStep);
        }
        return route;
    }

    private boolean isStepRemain(final int rowStep, final int columnStep) {
        return rowStep != 0 || columnStep != 0;
    }

    @Override
    public void changePosition(final Position position) {
        this.position = position;
    }

    @Override
    public Position getCurrentPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChariotMoveRule that = (ChariotMoveRule) o;
        return Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
