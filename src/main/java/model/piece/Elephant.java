package model.piece;

import model.AbsoluteValueDecreaser;
import model.position.Position;

import java.util.ArrayList;
import java.util.List;

public class Elephant extends Piece {

    public Elephant(final Position position) {
        super(position);
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.ELEPHANT;
    }

    @Override
    public List<Position> calculateRouteToDestination(final Position destination) {
        if (isPieceCanGo(destination)) {
            return findRouteToDestination(destination);
        }
        throw new IllegalArgumentException("현재 기물이 이동할 수 없는 위치입니다.");
    }

    private boolean isPieceCanGo(final Position destination) {
        int rowDifference = destination.calculateRowDifference(position);
        int columnDifference = destination.calculateColumnDifference(position);
        return (Math.abs(rowDifference) == 3 && Math.abs(columnDifference) == 2)
                || (Math.abs(rowDifference) == 2 && Math.abs(columnDifference) == 3);
    }

    private List<Position> findRouteToDestination(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        List<Position> route = new ArrayList<>();
        putPositionIfInBoard(route, rowStep, columnStep);
        putPositionIfInBoard(route, AbsoluteValueDecreaser.decreaseOne(rowStep), AbsoluteValueDecreaser.decreaseOne(columnStep));
        putPositionIfInBoard(route, AbsoluteValueDecreaser.decrease(rowStep, 2), AbsoluteValueDecreaser.decrease(columnStep, 2));
        return route;
    }

    private List<Position> putPositionIfInBoard(final List<Position> route, final int rowStep, final int columnStep) {
        if (position.canChangeOfRowAndColumn(rowStep, columnStep)) {
            route.add(position.changeRowAndColumn(rowStep, columnStep));
            return route;
        }
        throw new IllegalArgumentException("10x9 범위를 벗어났습니다.");
    }
}
