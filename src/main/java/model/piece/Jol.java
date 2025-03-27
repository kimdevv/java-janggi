package model.piece;

import model.piece.position.Position;

import static model.piece.position.MovementChecker.isUp;
import static model.piece.position.MovementChecker.isLeft;
import static model.piece.position.MovementChecker.isRight;
import static model.piece.position.MovementChecker.isUpLeft;
import static model.piece.position.MovementChecker.isUpRight;

public class Jol extends Piece {

    public Jol(final Position position) {
        super(position);
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.JOL;
    }

    @Override
    protected boolean canPieceMoveTo(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        if (position.isInPalace()) {
            return isUp(rowStep, columnStep)
                    || isLeft(rowStep, columnStep)
                    || isRight(rowStep, columnStep)
                    || isUpLeft(rowStep, columnStep) && destination.isInPalace()
                    || isUpRight(rowStep, columnStep) && destination.isInPalace();
        }
        return isUp(rowStep, columnStep)
                || isLeft(rowStep, columnStep)
                || isRight(rowStep, columnStep);
    }
}
