package model.piece;

import model.piece.position.Position;

import static model.piece.position.MovementChecker.isUp;
import static model.piece.position.MovementChecker.isLeft;
import static model.piece.position.MovementChecker.isRight;

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
        return isUp(rowStep, columnStep)
                || isLeft(rowStep, columnStep)
                || isRight(rowStep, columnStep);
    }
}
