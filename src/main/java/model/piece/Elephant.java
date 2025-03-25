package model.piece;

import model.piece.position.Position;

import static model.piece.position.MovementChecker.isUpUpUpLeftLeft;
import static model.piece.position.MovementChecker.isUpUpUpRightRight;
import static model.piece.position.MovementChecker.isLeftLeftLeftUpUp;
import static model.piece.position.MovementChecker.isLeftLeftLeftDownDown;
import static model.piece.position.MovementChecker.isRightRightRightUpUp;
import static model.piece.position.MovementChecker.isRightRightRightDownDown;
import static model.piece.position.MovementChecker.isDownDownDownLeftLeft;
import static model.piece.position.MovementChecker.isDownDownDownRightRight;

public class Elephant extends Piece {

    public Elephant(final Position position) {
        super(position);
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.ELEPHANT;
    }

    @Override
    protected boolean canPieceMoveTo(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        return isUpUpUpLeftLeft(rowStep, columnStep) || isUpUpUpRightRight(rowStep, columnStep)
                || isLeftLeftLeftUpUp(rowStep, columnStep) || isLeftLeftLeftDownDown(rowStep, columnStep)
                || isRightRightRightUpUp(rowStep, columnStep) || isRightRightRightDownDown(rowStep, columnStep)
                || isDownDownDownLeftLeft(rowStep, columnStep) || isDownDownDownRightRight(rowStep, columnStep);
    }
}
