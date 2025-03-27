package model.piece.position;

import java.util.Objects;

public final class Position {

    public static final int ROW_COUNT_OF_JANGGI = 10;
    public static final int COLUMN_COUNT_OF_JANGGI = 9;
    public static final int MINIMUM_PALACE_COLUMN = 3;
    public static final int MAXIMUM_PALACE_COLUMN = 5;
    public static final int MINIMUM_RED_PALACE_ROW = 0;
    public static final int MAXIMUM_RED_PALACE_ROW = 2;
    public static final int MINIMUM_GREEN_PALACE_ROW = 7;
    public static final int MAXIMUM_GREEN_PALACE_ROW = 9;
    private final int row;
    private final int column;

    public Position(final int row, final int column) {
        validate(row, column);
        this.row = row;
        this.column = column;
    }

    private void validate(final int row, final int column) {
        if ((0 > row || row >= ROW_COUNT_OF_JANGGI) || (0 > column || column >= COLUMN_COUNT_OF_JANGGI)) {
            throw new IllegalArgumentException("10x9 범위를 벗어났습니다.");
        }
    }

    public Position changeRowAndColumn(final int rowStep, final int columnStep) {
        return new Position(this.row + rowStep, this.column + columnStep);
    }

    public Position changeRow(final int step) {
        return new Position(this.row + step, this.column);
    }

    public Position changeColumn(final int step) {
        return new Position(this.row, this.column + step);
    }

    public boolean canChangeOfRow(final int step) {
        return 0 <= row + step && row + step < ROW_COUNT_OF_JANGGI;
    }

    public boolean canChangeOfColumn(final int step) {
        return 0 <= column + step && column + step < COLUMN_COUNT_OF_JANGGI;
    }

    public boolean canChangeOfRowAndColumn(final int rowStep, final int columnStep) {
        return canChangeOfRow(rowStep) && canChangeOfColumn(columnStep);
    }

    public int calculateRowDifference(final Position otherPosition) {
        return row - otherPosition.getRow();
    }

    public int calculateColumnDifference(final Position otherPosition) {
        return column - otherPosition.getColumn();
    }

    public boolean isInPalace() {
        return isInRedPalace() || isInGreenPalace();
    }

    private boolean isInRedPalace() {
        return (MINIMUM_RED_PALACE_ROW <= row && row <= MAXIMUM_RED_PALACE_ROW)
                && (MINIMUM_PALACE_COLUMN <= column && column <= MAXIMUM_PALACE_COLUMN);
    }

    private boolean isInGreenPalace() {
        return (MINIMUM_GREEN_PALACE_ROW <= row && row <= MAXIMUM_GREEN_PALACE_ROW)
                && (MINIMUM_PALACE_COLUMN <= column && column <= MAXIMUM_PALACE_COLUMN);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return column == position.column && row == position.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }
}
