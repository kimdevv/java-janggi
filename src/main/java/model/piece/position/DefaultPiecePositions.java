package model.piece.position;

import model.piece.PieceType;

public enum DefaultPiecePositions {

    GENERAL_RED(PieceType.GENERAL, new Position(1, 4)),
    GUARD_LEFT_RED(PieceType.GUARD, new Position(0, 3)),
    GUARD_RIGHT_RED(PieceType.GUARD, new Position(0, 5)),
    ELEPHANT_LEFT_RED(PieceType.ELEPHANT, new Position(0, 2)),
    ELEPHANT_RIGHT_RED(PieceType.ELEPHANT, new Position(0, 6)),
    HORSE_LEFT_RED(PieceType.HORSE, new Position(0, 1)),
    HORSE_RIGHT_RED(PieceType.HORSE, new Position(0, 7)),
    CHARIOT_LEFT_RED(PieceType.CHARIOT, new Position(0, 0)),
    CHARIOT_RIGHT_RED(PieceType.CHARIOT, new Position(0, 8)),
    CANNON_LEFT_RED(PieceType.CANNON, new Position(2, 1)),
    CANNON_RIGHT_RED(PieceType.CANNON, new Position(2, 7)),
    BYEONG_FIRST_RED(PieceType.BYEONG, new Position(3, 0)),
    BYEONG_SECOND_RED(PieceType.BYEONG, new Position(3, 2)),
    BYEONG_THIRD_RED(PieceType.BYEONG, new Position(3, 4)),
    BYEONG_FOURTH_RED(PieceType.BYEONG, new Position(3, 6)),
    BYEONG_FIFTH_RED(PieceType.BYEONG, new Position(3, 8)),

    GENERAL_GREEN(PieceType.GENERAL, new Position(8, 4)),
    GUARD_LEFT_GREEN(PieceType.GUARD, new Position(9, 3)),
    GUARD_RIGHT_GREEN(PieceType.GUARD, new Position(9, 5)),
    ELEPHANT_LEFT_GREEN(PieceType.ELEPHANT, new Position(9, 2)),
    ELEPHANT_RIGHT_GREEN(PieceType.ELEPHANT, new Position(9, 6)),
    HORSE_LEFT_GREEN(PieceType.HORSE, new Position(9, 1)),
    HORSE_RIGHT_GREEN(PieceType.HORSE, new Position(9, 7)),
    CHARIOT_LEFT_GREEN(PieceType.CHARIOT, new Position(9, 0)),
    CHARIOT_RIGHT_GREEN(PieceType.CHARIOT, new Position(9, 8)),
    CANNON_LEFT_GREEN(PieceType.CANNON, new Position(7, 1)),
    CANNON_RIGHT_GREEN(PieceType.CANNON, new Position(7, 7)),
    JOL_FIRST_GREEN(PieceType.JOL, new Position(6, 0)),
    JOL_SECOND_GREEN(PieceType.JOL, new Position(6, 2)),
    JOL_THIRD_GREEN(PieceType.JOL, new Position(6, 4)),
    JOL_FOURTH_GREEN(PieceType.JOL, new Position(6, 6)),
    JOL_FIFTH_GREEN(PieceType.JOL, new Position(6, 8));

    private final PieceType pieceType;
    private final Position position;

    DefaultPiecePositions(final PieceType pieceType, final Position position) {
        this.pieceType = pieceType;
        this.position = position;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public Position getPosition() {
        return position;
    }
}
