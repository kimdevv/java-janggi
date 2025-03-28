package model.piece.moveRule;

import model.piece.position.Position;

import java.util.List;
import java.util.Objects;

import static model.piece.position.MovementChecker.*;

public class ByeongMoveRule implements MoveRule {

    private Position position;

    public ByeongMoveRule(final Position position) {
        this.position = position;
    }

    @Override
    public final List<Position> calculateRouteToDestination(final Position destination) {
        if (canPieceMove(destination)) {
            return findRouteToDestination(destination);
        }
        throw new IllegalArgumentException("현재 기물이 이동할 수 없는 위치입니다.");
    }

    private boolean canPieceMove(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        if (position.isInPalace()) {
            return canPieceInsidePalace(rowStep, columnStep, destination.isInPalace());
        }
        return canPieceOutsidePalace(rowStep, columnStep);
    }

    private boolean canPieceInsidePalace(final int rowStep, final int columnStep, final boolean isDestinationInPalace) {
        return canPieceOutsidePalace(rowStep, columnStep)
                || isDownLeft(rowStep, columnStep) && isDestinationInPalace
                || isDownRight(rowStep, columnStep) && isDestinationInPalace;
    }

    private boolean canPieceOutsidePalace(final int rowStep, final int columnStep) {
        return isDown(rowStep, columnStep)
                || isLeft(rowStep, columnStep)
                || isRight(rowStep, columnStep);
    }

    private List<Position> findRouteToDestination(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        return List.of(position.changeRowAndColumnIfPositionInBoard(rowStep, columnStep));
    }

    @Override
    public void changePosition(final Position position) {
        this.position = position;
    }

    @Override
    public Position getCurrentPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ByeongMoveRule that = (ByeongMoveRule) o;
        return Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
