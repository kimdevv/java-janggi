package model.piece;

enum DefaultPiecePositions {

    GENERAL_RED(new Position(1, 4)),
    GUARD_LEFT_RED(new Position(0, 3)),
    GUARD_RIGHT_RED(new Position(0, 5)),
    ELEPHANT_LEFT_RED(new Position(0, 2)),
    ELEPHANT_RIGHT_RED(new Position(0, 6)),
    HORSE_LEFT_RED(new Position(0, 1)),
    HORSE_RIGHT_RED(new Position(0, 7)),
    CHARIOT_LEFT_RED(new Position(0, 0)),
    CHARIOT_RIGHT_RED(new Position(0, 8)),
    CANNON_LEFT_RED(new Position(2, 1)),
    CANNON_RIGHT_RED(new Position(2, 7)),
    BYEONG_FIRST_RED(new Position(3, 0)),
    BYEONG_SECOND_RED(new Position(3, 2)),
    BYEONG_THIRD_RED(new Position(3, 4)),
    BYEONG_FOURTH_RED(new Position(3, 6)),
    BYEONG_FIFTH_RED(new Position(3, 8)),

    GENERAL_GREEN(new Position(8, 4)),
    GUARD_LEFT_GREEN(new Position(9, 3)),
    GUARD_RIGHT_GREEN(new Position(9, 5)),
    ELEPHANT_LEFT_GREEN(new Position(9, 2)),
    ELEPHANT_RIGHT_GREEN(new Position(9, 6)),
    HORSE_LEFT_GREEN(new Position(9, 1)),
    HORSE_RIGHT_GREEN(new Position(9, 7)),
    CHARIOT_LEFT_GREEN(new Position(9, 0)),
    CHARIOT_RIGHT_GREEN(new Position(9, 8)),
    CANNON_LEFT_GREEN(new Position(7, 1)),
    CANNON_RIGHT_GREEN(new Position(7, 7)),
    JOL_FIRST_GREEN(new Position(6, 0)),
    JOL_SECOND_GREEN(new Position(6, 2)),
    JOL_THIRD_GREEN(new Position(6, 4)),
    JOL_FOURTH_GREEN(new Position(6, 6)),
    JOL_FIFTH_GREEN(new Position(6, 8));

    private final Position position;

    DefaultPiecePositions(final Position position) {
        this.position = position;
    }

    Position getPosition() {
        return position;
    }
}
