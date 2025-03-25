package model.piece;

import model.piece.position.Position;

import java.util.ArrayList;
import java.util.List;

import static model.piece.position.MovementChecker.isUpUpLeft;
import static model.piece.position.MovementChecker.isUpUpRight;
import static model.piece.position.MovementChecker.isLeftLeftUp;
import static model.piece.position.MovementChecker.isLeftLeftDown;
import static model.piece.position.MovementChecker.isRightRightUp;
import static model.piece.position.MovementChecker.isRightRightDown;
import static model.piece.position.MovementChecker.isDownDownLeft;
import static model.piece.position.MovementChecker.isDownDownRight;

public class Horse extends Piece {

    public Horse(final Position position) {
        super(position);
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.HORSE;
    }

    @Override
    protected boolean isPieceCanGo(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        return isUpUpLeft(rowStep, columnStep) || isUpUpRight(rowStep, columnStep)
                || isLeftLeftUp(rowStep, columnStep) || isLeftLeftDown(rowStep, columnStep)
                || isRightRightUp(rowStep, columnStep) || isRightRightDown(rowStep, columnStep)
                || isDownDownLeft(rowStep, columnStep) || isDownDownRight(rowStep, columnStep);
    }

    @Override
    protected List<Position> findRouteToDestination(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        List<Position> route = new ArrayList<>();
        putPositionIfInBoard(route, rowStep, columnStep);
        putPositionIfInBoard(route, AbsoluteValueDecreaser.decreaseOne(rowStep), AbsoluteValueDecreaser.decreaseOne(columnStep));
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
