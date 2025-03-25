package model.piece.position;

public class MovementChecker {

    public static final int NO_MOVE_VERTICAL = 0;
    public static final int UP_VERTICAL = -1;
    public static final int DOWN_VERTICAL = 1;

    public static final int NO_MOVE_HORIZONTAL = 0;
    public static final int LEFT_HORIZONTAL = -1;
    public static final int RIGHT_HORIZONTAL = 1;

    public static boolean isUp(final int rowStep, final int columnStep) {
        return rowStep == UP_VERTICAL && columnStep == NO_MOVE_HORIZONTAL;
    }

    public static boolean isLeft(final int rowStep, final int columnStep) {
        return rowStep == NO_MOVE_VERTICAL && columnStep == LEFT_HORIZONTAL;
    }

    public static boolean isRight(final int rowStep, final int columnStep) {
        return rowStep == NO_MOVE_VERTICAL && columnStep == RIGHT_HORIZONTAL;
    }

    public static boolean isDown(final int rowStep, final int columnStep) {
        return rowStep == DOWN_VERTICAL && columnStep == NO_MOVE_HORIZONTAL;
    }

    public static boolean isUpLeft(final int rowStep, final int columnStep) {
        return rowStep == UP_VERTICAL && columnStep == LEFT_HORIZONTAL;
    }

    public static boolean isUpRight(final int rowStep, final int columnStep) {
        return rowStep == UP_VERTICAL && columnStep == RIGHT_HORIZONTAL;
    }

    public static boolean isDownLeft(final int rowStep, final int columnStep) {
        return rowStep == DOWN_VERTICAL && columnStep == LEFT_HORIZONTAL;
    }

    public static boolean isDownRight(final int rowStep, final int columnStep) {
        return rowStep == DOWN_VERTICAL && columnStep == RIGHT_HORIZONTAL;
    }

    public static boolean isUpStraight(final int rowStep, final int columnStep) {
        return rowStep <= UP_VERTICAL && columnStep == NO_MOVE_HORIZONTAL;
    }

    public static boolean isLeftStraight(final int rowStep, final int columnStep) {
        return rowStep == NO_MOVE_VERTICAL && columnStep <= LEFT_HORIZONTAL;
    }

    public static boolean isRightStraight(final int rowStep, final int columnStep) {
        return rowStep == NO_MOVE_VERTICAL && columnStep >= RIGHT_HORIZONTAL;
    }

    public static boolean isDownStraight(final int rowStep, final int columnStep) {
        return rowStep >= DOWN_VERTICAL && columnStep == NO_MOVE_HORIZONTAL;
    }

    public static boolean isUpUpLeft(final int rowStep, final int columnStep) {
        return rowStep == UP_VERTICAL + UP_VERTICAL
                && columnStep == LEFT_HORIZONTAL;
    }

    public static boolean isUpUpRight(final int rowStep, final int columnStep) {
        return rowStep == UP_VERTICAL + UP_VERTICAL
                && columnStep == RIGHT_HORIZONTAL;
    }

    public static boolean isLeftLeftUp(final int rowStep, final int columnStep) {
        return rowStep == UP_VERTICAL
                && columnStep == LEFT_HORIZONTAL + LEFT_HORIZONTAL;
    }

    public static boolean isLeftLeftDown(final int rowStep, final int columnStep) {
        return rowStep == DOWN_VERTICAL
                && columnStep == LEFT_HORIZONTAL + LEFT_HORIZONTAL;
    }

    public static boolean isRightRightUp(final int rowStep, final int columnStep) {
        return rowStep == UP_VERTICAL
                && columnStep == RIGHT_HORIZONTAL + RIGHT_HORIZONTAL;
    }

    public static boolean isRightRightDown(final int rowStep, final int columnStep) {
        return rowStep == DOWN_VERTICAL
                && columnStep == RIGHT_HORIZONTAL + RIGHT_HORIZONTAL;
    }

    public static boolean isDownDownLeft(final int rowStep, final int columnStep) {
        return rowStep == DOWN_VERTICAL + DOWN_VERTICAL
                && columnStep == LEFT_HORIZONTAL;
    }

    public static boolean isDownDownRight(final int rowStep, final int columnStep) {
        return rowStep == DOWN_VERTICAL + DOWN_VERTICAL
                && columnStep == RIGHT_HORIZONTAL;
    }

    public static boolean isUpUpUpLeftLeft(final int rowStep, final int columnStep) {
        return rowStep == UP_VERTICAL + UP_VERTICAL + UP_VERTICAL
                && columnStep == LEFT_HORIZONTAL + LEFT_HORIZONTAL;
    }

    public static boolean isUpUpUpRightRight(final int rowStep, final int columnStep) {
        return rowStep == UP_VERTICAL + UP_VERTICAL + UP_VERTICAL
                && columnStep == RIGHT_HORIZONTAL + RIGHT_HORIZONTAL;
    }

    public static boolean isLeftLeftLeftUpUp(final int rowStep, final int columnStep) {
        return rowStep == UP_VERTICAL + UP_VERTICAL
                && columnStep == LEFT_HORIZONTAL + LEFT_HORIZONTAL + LEFT_HORIZONTAL;
    }

    public static boolean isLeftLeftLeftDownDown(final int rowStep, final int columnStep) {
        return rowStep == DOWN_VERTICAL + DOWN_VERTICAL
                && columnStep == LEFT_HORIZONTAL + LEFT_HORIZONTAL + LEFT_HORIZONTAL;
    }

    public static boolean isRightRightRightUpUp(final int rowStep, final int columnStep) {
        return rowStep == UP_VERTICAL + UP_VERTICAL
                && columnStep == RIGHT_HORIZONTAL + RIGHT_HORIZONTAL + RIGHT_HORIZONTAL;
    }

    public static boolean isRightRightRightDownDown(final int rowStep, final int columnStep) {
        return rowStep == DOWN_VERTICAL + DOWN_VERTICAL
                && columnStep == RIGHT_HORIZONTAL + RIGHT_HORIZONTAL + RIGHT_HORIZONTAL;
    }

    public static boolean isDownDownDownLeftLeft(final int rowStep, final int columnStep) {
        return rowStep == DOWN_VERTICAL + DOWN_VERTICAL + DOWN_VERTICAL
                && columnStep == LEFT_HORIZONTAL + LEFT_HORIZONTAL;
    }

    public static boolean isDownDownDownRightRight(final int rowStep, final int columnStep) {
        return rowStep == DOWN_VERTICAL + DOWN_VERTICAL + DOWN_VERTICAL
                && columnStep == RIGHT_HORIZONTAL + RIGHT_HORIZONTAL;
    }
}
