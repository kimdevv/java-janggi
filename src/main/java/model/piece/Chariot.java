package model.piece;

import model.piece.position.Position;

import static model.piece.position.MovementChecker.isDownLeftStraight;
import static model.piece.position.MovementChecker.isDownRightStraight;
import static model.piece.position.MovementChecker.isUpLeftStraight;
import static model.piece.position.MovementChecker.isUpRightStraight;
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
        if (position.isInPalace()) {
            return isUpStraight(rowStep, columnStep)
                    || isLeftStraight(rowStep, columnStep)
                    || isRightStraight(rowStep, columnStep)
                    || isDownStraight(rowStep, columnStep)
                    || isUpLeftStraight(rowStep, columnStep) && destination.isInPalace()
                    || isUpRightStraight(rowStep, columnStep) && destination.isInPalace()
                    || isDownLeftStraight(rowStep, columnStep) && destination.isInPalace()
                    || isDownRightStraight(rowStep, columnStep) && destination.isInPalace();
        }
        return isUpStraight(rowStep, columnStep)
                || isLeftStraight(rowStep, columnStep)
                || isRightStraight(rowStep, columnStep)
                || isDownStraight(rowStep, columnStep);
    }
}
