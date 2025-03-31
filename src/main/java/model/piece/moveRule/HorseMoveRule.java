package model.piece.moveRule;

import model.piece.position.Position;

import static model.piece.position.MovementChecker.*;

class HorseMoveRule extends MultiStepMoveRule {

    @Override
    protected boolean canPieceMove(final Position startPosition, final Position destination) {
        int rowStep = destination.calculateRowDifference(startPosition);
        int columnStep = destination.calculateColumnDifference(startPosition);
        return isUpUpLeft(rowStep, columnStep) || isUpUpRight(rowStep, columnStep)
                || isLeftLeftUp(rowStep, columnStep) || isLeftLeftDown(rowStep, columnStep)
                || isRightRightUp(rowStep, columnStep) || isRightRightDown(rowStep, columnStep)
                || isDownDownLeft(rowStep, columnStep) || isDownDownRight(rowStep, columnStep);
    }

}
