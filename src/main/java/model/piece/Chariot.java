package model.piece;

import model.piece.position.Position;

import static model.piece.position.MovementChecker.isUpStraight;
import static model.piece.position.MovementChecker.isLeftStraight;
import static model.piece.position.MovementChecker.isRightStraight;
import static model.piece.position.MovementChecker.isDownStraight;


public class Chariot extends Piece {

    public Chariot(final Position position) {
        super(position);
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.CHARIOT;
    }

    @Override
    protected boolean canPieceMoveTo(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        return isUpStraight(rowStep, columnStep)
                || isLeftStraight(rowStep, columnStep)
                || isRightStraight(rowStep, columnStep)
                || isDownStraight(rowStep, columnStep);
    }
}