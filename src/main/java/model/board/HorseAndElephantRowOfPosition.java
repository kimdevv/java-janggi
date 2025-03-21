package model.board;

import java.util.Arrays;

public enum HorseAndElephantRowOfPosition {

    마상상마(1, 1, 7, 2, 6),
    상마마상(2, 2, 6, 1, 7),
    마상마상(3, 1, 6, 2, 7),
    상마상마(4, 2, 7, 1, 6);

    private final int number;
    private final int leftHorseRow;
    private final int rightHorseRow;
    private final int leftElephantRow;
    private final int rightElephantRow;

    HorseAndElephantRowOfPosition(final int number,
                                  final int leftHorseRow, final int rightHorseRow, final int leftElephantRow, final int rightElephantRow) {
        this.number = number;
        this.leftHorseRow = leftHorseRow;
        this.rightHorseRow = rightHorseRow;
        this.leftElephantRow = leftElephantRow;
        this.rightElephantRow = rightElephantRow;
    }

    public static HorseAndElephantRowOfPosition from(final int number) {
        return Arrays.stream(values())
                .filter(position -> position.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 번호를 입력하셨습니다."));
    }

    public int getLeftHorseRow() {
        return leftHorseRow;
    }

    public int getRightHorseRow() {
        return rightHorseRow;
    }

    public int getLeftElephantRow() {
        return leftElephantRow;
    }

    public int getRightElephantRow() {
        return rightElephantRow;
    }
}
