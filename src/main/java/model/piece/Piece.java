package model.piece;

import model.piece.position.Position;

import java.util.ArrayList;
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
        if (canPieceMoveTo(destination)) {
            return findRouteToDestination(destination);
        }
        throw new IllegalArgumentException("현재 기물이 이동할 수 없는 위치입니다.");
    }

    protected abstract boolean canPieceMoveTo(final Position destination);

    protected final List<Position> findRouteToDestination(final Position destination) {
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
