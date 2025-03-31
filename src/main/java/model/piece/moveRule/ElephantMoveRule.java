package model.piece.moveRule;

import model.piece.position.Position;

import static model.piece.position.MovementChecker.*;

class ElephantMoveRule extends MultiStepMoveRule {

    @Override
    protected boolean canPieceMove(final Position startPosition, final Position destination) {
        int rowStep = destination.calculateRowDifference(startPosition);
        int columnStep = destination.calculateColumnDifference(startPosition);
        return isUpUpUpLeftLeft(rowStep, columnStep) || isUpUpUpRightRight(rowStep, columnStep)
                || isLeftLeftLeftUpUp(rowStep, columnStep) || isLeftLeftLeftDownDown(rowStep, columnStep)
                || isRightRightRightUpUp(rowStep, columnStep) || isRightRightRightDownDown(rowStep, columnStep)
                || isDownDownDownLeftLeft(rowStep, columnStep) || isDownDownDownRightRight(rowStep, columnStep);
    }

}
