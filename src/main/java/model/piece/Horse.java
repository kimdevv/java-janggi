package model.piece;

import model.piece.position.Position;

import static model.piece.position.MovementChecker.isUpUpLeft;
import static model.piece.position.MovementChecker.isUpUpRight;
import static model.piece.position.MovementChecker.isLeftLeftUp;
import static model.piece.position.MovementChecker.isLeftLeftDown;
import static model.piece.position.MovementChecker.isRightRightUp;
import static model.piece.position.MovementChecker.isRightRightDown;
import static model.piece.position.MovementChecker.isDownDownLeft;
import static model.piece.position.MovementChecker.isDownDownRight;

public class Horse extends Piece {

    public Horse(final Position position) {
        super(position);
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.HORSE;
    }

    @Override
    protected boolean canPieceMoveTo(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        return isUpUpLeft(rowStep, columnStep) || isUpUpRight(rowStep, columnStep)
                || isLeftLeftUp(rowStep, columnStep) || isLeftLeftDown(rowStep, columnStep)
                || isRightRightUp(rowStep, columnStep) || isRightRightDown(rowStep, columnStep)
                || isDownDownLeft(rowStep, columnStep) || isDownDownRight(rowStep, columnStep);
    }
}
