package model.piece.moveRule;

import model.piece.AbsolutevalueDecreaser;
import model.piece.position.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static model.piece.position.MovementChecker.isDownDownDownLeftLeft;
import static model.piece.position.MovementChecker.isDownDownDownRightRight;
import static model.piece.position.MovementChecker.isDownDownLeft;
import static model.piece.position.MovementChecker.isDownDownRight;
import static model.piece.position.MovementChecker.isLeftLeftDown;
import static model.piece.position.MovementChecker.isLeftLeftLeftDownDown;
import static model.piece.position.MovementChecker.isLeftLeftLeftUpUp;
import static model.piece.position.MovementChecker.isLeftLeftUp;
import static model.piece.position.MovementChecker.isRightRightDown;
import static model.piece.position.MovementChecker.isRightRightRightDownDown;
import static model.piece.position.MovementChecker.isRightRightRightUpUp;
import static model.piece.position.MovementChecker.isRightRightUp;
import static model.piece.position.MovementChecker.isUpUpLeft;
import static model.piece.position.MovementChecker.isUpUpRight;
import static model.piece.position.MovementChecker.isUpUpUpLeftLeft;
import static model.piece.position.MovementChecker.isUpUpUpRightRight;

public class HorseMoveRule implements MoveRule {

    private Position position;

    public HorseMoveRule(final Position position) {
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
        return isUpUpLeft(rowStep, columnStep) || isUpUpRight(rowStep, columnStep)
                || isLeftLeftUp(rowStep, columnStep) || isLeftLeftDown(rowStep, columnStep)
                || isRightRightUp(rowStep, columnStep) || isRightRightDown(rowStep, columnStep)
                || isDownDownLeft(rowStep, columnStep) || isDownDownRight(rowStep, columnStep);
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
        HorseMoveRule that = (HorseMoveRule) o;
        return Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
