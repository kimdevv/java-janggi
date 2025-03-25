package model.piece;

import java.util.Objects;

public final class Position {

    public static final int ROW_COUNT_OF_JANGGI = 10;
    public static final int COLUMN_COUNT_OF_JANGGI = 9;
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
