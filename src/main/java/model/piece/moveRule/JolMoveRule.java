package model.piece.moveRule;

import model.piece.position.Position;

import java.util.List;

import static model.piece.position.MovementChecker.*;

class JolMoveRule implements MoveRule {

    @Override
    public final List<Position> calculateRouteToDestination(final Position startPosition, final Position destination) {
        if (canPieceMove(startPosition, destination)) {
            return findRouteToDestination(startPosition, destination);
        }
        throw new IllegalArgumentException("현재 기물이 이동할 수 없는 위치입니다.");
    }

    private boolean canPieceMove(final Position startPosition, final Position destination) {
        int rowStep = destination.calculateRowDifference(startPosition);
        int columnStep = destination.calculateColumnDifference(startPosition);
        if (startPosition.isInPalace() && destination.isInPalace()) {
            return canPieceMoveInsidePalace(rowStep, columnStep);
        }
        return canPieceMoveOutsidePalace(rowStep, columnStep);
    }

    private boolean canPieceMoveInsidePalace(final int rowStep, final int columnStep) {
        return canPieceMoveOutsidePalace(rowStep, columnStep)
                || isUpLeft(rowStep, columnStep)
                || isUpRight(rowStep, columnStep);
    }

    private boolean canPieceMoveOutsidePalace(final int rowStep, final int columnStep) {
        return isUp(rowStep, columnStep)
                || isLeft(rowStep, columnStep)
                || isRight(rowStep, columnStep);
    }

    private List<Position> findRouteToDestination(final Position startPosition, final Position destination) {
        int rowStep = destination.calculateRowDifference(startPosition);
        int columnStep = destination.calculateColumnDifference(startPosition);
        return List.of(startPosition.moveIfDestinationIsValid(rowStep, columnStep));
    }
}
