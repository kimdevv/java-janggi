package model.piece;

import model.piece.position.Position;

import static model.piece.position.MovementChecker.isDown;
import static model.piece.position.MovementChecker.isLeft;
import static model.piece.position.MovementChecker.isRight;
import static model.piece.position.MovementChecker.isDownLeft;
import static model.piece.position.MovementChecker.isDownRight;

public class Byeong extends Piece {

    public Byeong(final Position position) {
        super(position);
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.BYEONG;
    }

    @Override
    protected boolean canPieceMoveTo(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        if (position.isInPalace()) {
            return isDown(rowStep, columnStep)
                    || isLeft(rowStep, columnStep)
                    || isRight(rowStep, columnStep)
                    || isDownLeft(rowStep, columnStep) && destination.isInPalace()
                    || isDownRight(rowStep, columnStep) && destination.isInPalace();
        }
        return isDown(rowStep, columnStep)
                || isLeft(rowStep, columnStep)
                || isRight(rowStep, columnStep);
    }
}
