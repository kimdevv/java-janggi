package model.piece;

import java.util.ArrayList;
import java.util.List;

import static model.piece.MovementChecker.isUpUpUpLeftLeft;
import static model.piece.MovementChecker.isUpUpUpRightRight;
import static model.piece.MovementChecker.isLeftLeftLeftUpUp;
import static model.piece.MovementChecker.isLeftLeftLeftDownDown;
import static model.piece.MovementChecker.isRightRightRightUpUp;
import static model.piece.MovementChecker.isRightRightRightDownDown;
import static model.piece.MovementChecker.isDownDownDownLeftLeft;
import static model.piece.MovementChecker.isDownDownDownRightRight;

public class Elephant extends Piece {

    public Elephant(final Position position) {
        super(position);
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.ELEPHANT;
    }

    @Override
    protected boolean isPieceCanGo(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        return isUpUpUpLeftLeft(rowStep, columnStep) || isUpUpUpRightRight(rowStep, columnStep)
                || isLeftLeftLeftUpUp(rowStep, columnStep) || isLeftLeftLeftDownDown(rowStep, columnStep)
                || isRightRightRightUpUp(rowStep, columnStep) || isRightRightRightDownDown(rowStep, columnStep)
                || isDownDownDownLeftLeft(rowStep, columnStep) || isDownDownDownRightRight(rowStep, columnStep);
    }

    @Override
    protected List<Position> findRouteToDestination(final Position destination) {
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
