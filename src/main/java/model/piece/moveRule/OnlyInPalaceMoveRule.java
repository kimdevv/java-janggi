package model.piece.moveRule;

import model.piece.position.Position;

import static model.piece.position.MovementChecker.*;

class OnlyInPalaceMoveRule extends OneStepMoveRule {

    @Override
    protected boolean canPieceMove(final Position startPosition, final Position destination) {
        int rowStep = destination.calculateRowDifference(startPosition);
        int columnStep = destination.calculateColumnDifference(startPosition);
        return destination.isInPalace()
                && (isUp(rowStep, columnStep)
                || isLeft(rowStep, columnStep)
                || isRight(rowStep, columnStep)
                || isDown(rowStep, columnStep)
                || isUpLeft(rowStep, columnStep)
                || isUpRight(rowStep, columnStep)
                || isDownLeft(rowStep, columnStep)
                || isDownRight(rowStep, columnStep));
    }

}
