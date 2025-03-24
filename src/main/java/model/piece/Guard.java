package model.piece;

import model.piece.Piece;
import model.piece.PieceType;
import model.position.Position;

import java.util.List;

public class Guard extends Piece {

    public Guard(final Position position) {
        super(position);
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.GUARD;
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
        return Math.abs(rowDifference) <= 1 && Math.abs(columnDifference) <= 1
                && !(rowDifference == 0 && columnDifference == 0);
    }

    private List<Position> findRouteToDestination(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        if (position.canChangeOfRowAndColumn(rowStep, columnStep)) {
            return List.of(position.changeRowAndColumn(rowStep, columnStep));
        }
        throw new IllegalArgumentException("10x9 범위를 벗어났습니다.");
    }
}

