package model.piece.moveRule;

import model.piece.position.Position;
import static model.piece.position.MovementChecker.*;

class ChariotMoveRule extends MultiStepMoveRule {

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
                || isUpLeftStraight(rowStep, columnStep)
                || isUpRightStraight(rowStep, columnStep)
                || isDownLeftStraight(rowStep, columnStep)
                || isDownRightStraight(rowStep, columnStep);
    }

    private boolean canPieceMoveOutsidePalace(final int rowStep, final int columnStep) {
        return isUpStraight(rowStep, columnStep)
                || isLeftStraight(rowStep, columnStep)
                || isRightStraight(rowStep, columnStep)
                || isDownStraight(rowStep, columnStep);
    }

}
