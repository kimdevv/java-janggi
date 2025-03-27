package model.piece;

import model.piece.position.Position;

import static model.piece.position.MovementChecker.isDownLeft;
import static model.piece.position.MovementChecker.isDownLeftStraight;
import static model.piece.position.MovementChecker.isDownRight;
import static model.piece.position.MovementChecker.isDownRightStraight;
import static model.piece.position.MovementChecker.isUp;
import static model.piece.position.MovementChecker.isLeft;
import static model.piece.position.MovementChecker.isRight;
import static model.piece.position.MovementChecker.isDown;
import static model.piece.position.MovementChecker.isUpLeft;
import static model.piece.position.MovementChecker.isUpLeftStraight;
import static model.piece.position.MovementChecker.isUpRight;
import static model.piece.position.MovementChecker.isUpRightStraight;
import static model.piece.position.MovementChecker.isUpStraight;
import static model.piece.position.MovementChecker.isLeftStraight;
import static model.piece.position.MovementChecker.isRightStraight;
import static model.piece.position.MovementChecker.isDownStraight;

public class Cannon extends Piece {

    public Cannon(final Position position) {
        super(position);
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.CANNON;
    }

    @Override
    protected boolean canPieceMoveTo(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        if (position.isInPalace()) {
            return isUpStraight(rowStep, columnStep) && !isUp(rowStep, columnStep)
                    || isLeftStraight(rowStep, columnStep) && !isLeft(rowStep, columnStep)
                    || isRightStraight(rowStep, columnStep) && !isRight(rowStep, columnStep)
                    || isDownStraight(rowStep, columnStep) && !isDown(rowStep, columnStep)
                    || isUpLeftStraight(rowStep, columnStep) && !isUpLeft(rowStep, columnStep) && destination.isInPalace()
                    || isUpRightStraight(rowStep, columnStep)&& !isUpRight(rowStep, columnStep) && destination.isInPalace()
                    || isDownLeftStraight(rowStep, columnStep) && !isDownLeft(rowStep, columnStep) && destination.isInPalace()
                    || isDownRightStraight(rowStep, columnStep) && !isDownRight(rowStep, columnStep) && destination.isInPalace();
        }
        return (isUpStraight(rowStep, columnStep) && !isUp(rowStep, columnStep))
                || (isLeftStraight(rowStep, columnStep) && !isLeft(rowStep, columnStep))
                || (isRightStraight(rowStep, columnStep) && !isRight(rowStep, columnStep))
                || (isDownStraight(rowStep, columnStep) && !isDown(rowStep, columnStep));
    }
}
