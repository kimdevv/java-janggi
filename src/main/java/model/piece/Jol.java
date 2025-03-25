package model.piece;

import java.util.List;

import static model.piece.MovementChecker.isUp;
import static model.piece.MovementChecker.isLeft;
import static model.piece.MovementChecker.isRight;

public class Jol extends Piece {

    public Jol(final Position position) {
        super(position);
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.JOL;
    }

    @Override
    protected boolean isPieceCanGo(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        return isUp(rowStep, columnStep)
                || isLeft(rowStep, columnStep)
                || isRight(rowStep, columnStep);
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

