package model.piece.moveRule;

import model.piece.position.Position;

import java.util.List;
import java.util.Objects;

import static model.piece.position.MovementChecker.*;

public class JolMoveRule implements MoveRule {

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
        if (startPosition.isInPalace()) {
            return canPieceInsidePalace(rowStep, columnStep, destination.isInPalace());
        }
        return canPieceOutsidePalace(rowStep, columnStep);
    }

    private boolean canPieceInsidePalace(final int rowStep, final int columnStep, final boolean isDestinationInPalace) {
        return canPieceOutsidePalace(rowStep, columnStep)
                || isUpLeft(rowStep, columnStep) && isDestinationInPalace
                || isUpRight(rowStep, columnStep) && isDestinationInPalace;
    }

    private boolean canPieceOutsidePalace(final int rowStep, final int columnStep) {
        return isUp(rowStep, columnStep)
                || isLeft(rowStep, columnStep)
                || isRight(rowStep, columnStep);
    }

    private List<Position> findRouteToDestination(final Position startPosition, final Position destination) {
        int rowStep = destination.calculateRowDifference(startPosition);
        int columnStep = destination.calculateColumnDifference(startPosition);
        return List.of(startPosition.changeRowAndColumnIfPositionInBoard(rowStep, columnStep));
    }
}
