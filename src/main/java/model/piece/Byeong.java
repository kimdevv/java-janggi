package model.piece;

import model.piece.position.Position;

import java.util.List;

import static model.piece.position.MovementChecker.isDown;
import static model.piece.position.MovementChecker.isLeft;
import static model.piece.position.MovementChecker.isRight;

public class Byeong extends Piece {

    public Byeong(final Position position) {
        super(position);
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.BYEONG;
    }

    @Override
    protected boolean isPieceCanGo(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        return isDown(rowStep, columnStep)
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
