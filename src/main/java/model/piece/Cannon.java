package model.piece;

import model.piece.position.Position;

import java.util.ArrayList;
import java.util.List;

import static model.piece.position.MovementChecker.isUp;
import static model.piece.position.MovementChecker.isLeft;
import static model.piece.position.MovementChecker.isRight;
import static model.piece.position.MovementChecker.isDown;
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
    protected boolean isPieceCanGo(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        return (isUpStraight(rowStep, columnStep) && !isUp(rowStep, columnStep))
                || (isLeftStraight(rowStep, columnStep) && !isLeft(rowStep, columnStep))
                || (isRightStraight(rowStep, columnStep) && !isRight(rowStep, columnStep))
                || (isDownStraight(rowStep, columnStep) && !isDown(rowStep, columnStep));
    }

    @Override
    protected List<Position> findRouteToDestination(final Position destination) {
        int rowStep = destination.calculateRowDifference(position);
        int columnStep = destination.calculateColumnDifference(position);
        if (Math.abs(rowStep) > 1) {
            return findVerticalRoute(rowStep);
        }
        return findHorizontalRoute(columnStep);
    }

    private List<Position> findVerticalRoute(int rowStep) {
        List<Position> route = new ArrayList<>();
        while (rowStep != 0) {
            if (position.canChangeOfRow(rowStep)) {
                route.add(position.changeRow(rowStep));
                rowStep = AbsoluteValueDecreaser.decreaseOne(rowStep);
                continue;
            }
            throw new IllegalArgumentException("10x9 범위를 벗어났습니다.");
        }
        return route;
    }

    private List<Position> findHorizontalRoute(int columnStep) {
        List<Position> route = new ArrayList<>();
        while (columnStep != 0) {
            if (position.canChangeOfColumn(columnStep)) {
                route.add(position.changeColumn(columnStep));
                columnStep = AbsoluteValueDecreaser.decreaseOne(columnStep);
                continue;
            }
            throw new IllegalArgumentException("10x9 범위를 벗어났습니다.");
        }
        return route;
    }
}



