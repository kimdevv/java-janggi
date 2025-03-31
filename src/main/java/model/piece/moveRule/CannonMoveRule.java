package model.piece.moveRule;

import model.piece.position.Position;

import static model.piece.position.MovementChecker.*;

class CannonMoveRule extends MultiStepMoveRule {

    @Override
    protected boolean canPieceMove(final Position startPosition, final Position destination) {
        int rowStep = destination.calculateRowDifference(startPosition);
        int columnStep = destination.calculateColumnDifference(startPosition);
        if (startPosition.isInPalace() && destination.isInPalace()) {
            return canPieceMoveInsidePalace(rowStep, columnStep);
        }
        return canPieceMoveOutsidePalace(rowStep, columnStep);
    }

    private boolean canPieceMoveInsidePalace(final int rowStep, final int columnStep) {
        return canPieceMoveOutsidePalace(rowStep, columnStep)
                || (isUpLeftStraight(rowStep, columnStep) && !isUpLeft(rowStep, columnStep))
                || (isUpRightStraight(rowStep, columnStep) && !isUpRight(rowStep, columnStep))
                || (isDownLeftStraight(rowStep, columnStep) && !isDownLeft(rowStep, columnStep))
                || (isDownRightStraight(rowStep, columnStep) && !isDownRight(rowStep, columnStep));
    }

    private boolean canPieceMoveOutsidePalace(final int rowStep, final int columnStep) {
        return (isUpStraight(rowStep, columnStep) && !isUp(rowStep, columnStep))
                || (isLeftStraight(rowStep, columnStep) && !isLeft(rowStep, columnStep))
                || (isRightStraight(rowStep, columnStep) && !isRight(rowStep, columnStep))
                || (isDownStraight(rowStep, columnStep) && !isDown(rowStep, columnStep));
    }

}
