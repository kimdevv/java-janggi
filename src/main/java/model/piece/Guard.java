package model.piece;

import java.util.List;

import static model.piece.MovementChecker.isUp;
import static model.piece.MovementChecker.isLeft;
import static model.piece.MovementChecker.isRight;
import static model.piece.MovementChecker.isDown;
import static model.piece.MovementChecker.isUpLeft;
import static model.piece.MovementChecker.isUpRight;
import static model.piece.MovementChecker.isDownLeft;
import static model.piece.MovementChecker.isDownRight;

public class Guard extends Piece {

    public Guard(final Position position) {
        super(position);
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.GUARD;
    }

    @Override
    protected boolean isPieceCanGo(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        return isUp(rowStep, columnStep)
                || isLeft(rowStep, columnStep)
                || isRight(rowStep, columnStep)
                || isDown(rowStep, columnStep)
                || isUpLeft(rowStep, columnStep)
                || isUpRight(rowStep, columnStep)
                || isDownLeft(rowStep, columnStep)
                || isDownRight(rowStep, columnStep);
    }

    @Override
    protected List<Position> findRouteToDestination(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        if (position.canChangeOfRowAndColumn(rowStep, columnStep)) {
            return List.of(position.changeRowAndColumn(rowStep, columnStep));
        }
        throw new IllegalArgumentException("10x9 범위를 벗어났습니다.");
    }
}

