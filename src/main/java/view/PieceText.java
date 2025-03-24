package view;

import model.piece.PieceType;

import java.util.Arrays;

public enum PieceText {

    GENERAL(PieceType.GENERAL, "궁"),
    GUARD(PieceType.GUARD, "사"),
    ELEPHANT(PieceType.ELEPHANT, "상"),
    HORSE(PieceType.HORSE, "마"),
    CHARIOT(PieceType.CHARIOT, "차"),
    CANNON(PieceType.CANNON, "포"),
    BYEONG(PieceType.BYEONG, "병"),
    JOL(PieceType.JOL, "졸");

    private final PieceType pieceType;
    private final String text;

    PieceText(final PieceType pieceType, final String text) {
        this.pieceType = pieceType;
        this.text = text;
    }

    public static String findStringOf(final PieceType pieceType) {
        PieceText pieceText =  Arrays.stream(values())
                .filter(piece -> piece.pieceType == pieceType)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 기물 타입입니다."));
        return pieceText.text;
    }
}
