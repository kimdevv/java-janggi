package model.piece;

import java.util.ArrayList;
import java.util.List;


public class Chariot extends Piece {

    public Chariot(final Position position) {
        super(position);
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.CHARIOT;
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
        return (Math.abs(rowDifference) != 0 && Math.abs(columnDifference) == 0)
                || (Math.abs(rowDifference) == 0 && Math.abs(columnDifference) != 0);
    }

    private List<Position> findRouteToDestination(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        if (Math.abs(rowStep) != 0) {
            return findVerticalRoute(rowStep);
        }
        return findHorizontalRoute(columnStep);
    }

    private List<Position> findVerticalRoute(int rowStep) {
        List<Position> route = new ArrayList<>();
        while (rowStep != 0) {
            if (position.canChangeOfRow(rowStep)) {
                route.add(position.changeRow(rowStep));
                rowStep = AbsoluteValueDecreaser.decreaseOne(rowStep);
                continue;
            }
            throw new IllegalArgumentException("10x9 범위를 벗어났습니다.");
        }
        return route;
    }

    private List<Position> findHorizontalRoute(int columnStep) {
        List<Position> route = new ArrayList<>();
        while (columnStep != 0) {
            if (position.canChangeOfColumn(columnStep)) {
                route.add(position.changeColumn(columnStep));
                columnStep = AbsoluteValueDecreaser.decreaseOne(columnStep);
                continue;
            }
            throw new IllegalArgumentException("10x9 범위를 벗어났습니다.");
        }
        return route;
    }
}