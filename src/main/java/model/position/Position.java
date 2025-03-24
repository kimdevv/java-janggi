package model.position;

import java.util.Objects;

public final class Position {

    public static final int MAXIMUM_ROW_VALUE = 9;
    public static final int MAXIMUM_COLUMN_VALUE = 8;
    private final int row;
    private final int column;

    public Position(final int row, final int column) {
        validate(row, column);
        this.row = row;
        this.column = column;
    }

    private void validate(final int row, final int column) {
        if ((0 > row || row > MAXIMUM_ROW_VALUE) || (0 > column || column > MAXIMUM_COLUMN_VALUE)) {
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
        return 0 <= row + step && row + step <= MAXIMUM_ROW_VALUE;
    }

    public boolean canChangeOfColumn(final int step) {
        return 0 <= column + step && column + step <= MAXIMUM_COLUMN_VALUE;
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
