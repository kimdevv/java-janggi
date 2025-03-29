package model.piece;

import java.util.Arrays;

public enum PieceType {
    GENERAL(100),
    GUARD(3),
    ELEPHANT(3),
    HORSE(5),
    CHARIOT(13),
    CANNON(7),
    BYEONG(2),
    JOL(2);

    private final int point;

    PieceType(final int point) {
        this.point = point;
    }

    public static PieceType findByOrdinal(final int ordinal) {
        return Arrays.stream(values())
                .filter(pieceType -> pieceType.ordinal() == ordinal)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("PieceType 번호가 잘못되었습니다."));
    }

    public int getPoint() {
        return point;
    }
}
