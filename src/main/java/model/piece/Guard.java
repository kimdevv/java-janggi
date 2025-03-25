package model.piece;

import model.piece.position.Position;

import static model.piece.position.MovementChecker.isUp;
import static model.piece.position.MovementChecker.isLeft;
import static model.piece.position.MovementChecker.isRight;
import static model.piece.position.MovementChecker.isDown;
import static model.piece.position.MovementChecker.isUpLeft;
import static model.piece.position.MovementChecker.isUpRight;
import static model.piece.position.MovementChecker.isDownLeft;
import static model.piece.position.MovementChecker.isDownRight;

public class Guard extends Piece {

    public Guard(final Position position) {
        super(position);
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.GUARD;
    }

    @Override
    protected boolean canPieceMoveTo(final Position destination) {
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
}

