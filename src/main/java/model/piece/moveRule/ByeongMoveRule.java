package model.piece.moveRule;

import model.piece.position.Position;

import static model.piece.position.MovementChecker.*;

class ByeongMoveRule extends OneStepMoveRule {

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
                || (isDownLeft(rowStep, columnStep))
                || (isDownRight(rowStep, columnStep));
    }

    private boolean canPieceMoveOutsidePalace(final int rowStep, final int columnStep) {
        return isDown(rowStep, columnStep)
                || isLeft(rowStep, columnStep)
                || isRight(rowStep, columnStep);
    }

}
