package view;

import model.position.Position;

import java.util.Arrays;

public enum PositionText {

    A1("a1", new Position(9, 0)),
    A2("a2", new Position(8, 0)),
    A3("a3", new Position(7, 0)),
    A4("a4", new Position(6, 0)),
    A5("a5", new Position(5, 0)),
    A6("a6", new Position(4, 0)),
    A7("a7", new Position(3, 0)),
    A8("a8", new Position(2, 0)),
    A9("a9", new Position(1, 0)),
    A10("a10", new Position(0, 0)),

    B1("b1", new Position(9, 1)),
    B2("b2", new Position(8, 1)),
    B3("b3", new Position(7, 1)),
    B4("b4", new Position(6, 1)),
    B5("b5", new Position(5, 1)),
    B6("b6", new Position(4, 1)),
    B7("b7", new Position(3, 1)),
    B8("b8", new Position(2, 1)),
    B9("b9", new Position(1, 1)),
    B10("b10", new Position(0, 1)),

    C1("c1", new Position(9, 2)),
    C2("c2", new Position(8, 2)),
    C3("c3", new Position(7, 2)),
    C4("c4", new Position(6, 2)),
    C5("c5", new Position(5, 2)),
    C6("c6", new Position(4, 2)),
    C7("c7", new Position(3, 2)),
    C8("c8", new Position(2, 2)),
    C9("c9", new Position(1, 2)),
    C10("c10", new Position(0, 2)),

    D1("d1", new Position(9, 3)),
    D2("d2", new Position(8, 3)),
    D3("d3", new Position(7, 3)),
    D4("d4", new Position(6, 3)),
    D5("d5", new Position(5, 3)),
    D6("d6", new Position(4, 3)),
    D7("d7", new Position(3, 3)),
    D8("d8", new Position(2, 3)),
    D9("d9", new Position(1, 3)),
    D10("d10", new Position(0, 3)),

    E1("e1", new Position(9, 4)),
    E2("e2", new Position(8, 4)),
    E3("e3", new Position(7, 4)),
    E4("e4", new Position(6, 4)),
    E5("e5", new Position(5, 4)),
    E6("e6", new Position(4, 4)),
    E7("e7", new Position(3, 4)),
    E8("e8", new Position(2, 4)),
    E9("e9", new Position(1, 4)),
    E10("e10", new Position(0, 4)),

    F1("f1", new Position(9, 5)),
    F2("f2", new Position(8, 5)),
    F3("f3", new Position(7, 5)),
    F4("f4", new Position(6, 5)),
    F5("f5", new Position(5, 5)),
    F6("f6", new Position(4, 5)),
    F7("f7", new Position(3, 5)),
    F8("f8", new Position(2, 5)),
    F9("f9", new Position(1, 5)),
    F10("f10", new Position(0, 5)),

    G1("g1", new Position(9, 6)),
    G2("g2", new Position(8, 6)),
    G3("g3", new Position(7, 6)),
    G4("g4", new Position(6, 6)),
    G5("g5", new Position(5, 6)),
    G6("g6", new Position(4, 6)),
    G7("g7", new Position(3, 6)),
    G8("g8", new Position(2, 6)),
    G9("g9", new Position(1, 6)),
    G10("g10", new Position(0, 6)),

    H1("h1", new Position(9, 7)),
    H2("h2", new Position(8, 7)),
    H3("h3", new Position(7, 7)),
    H4("h4", new Position(6, 7)),
    H5("h5", new Position(5, 7)),
    H6("h6", new Position(4, 7)),
    H7("h7", new Position(3, 7)),
    H8("h8", new Position(2, 7)),
    H9("h9", new Position(1, 7)),
    H10("h10", new Position(0, 7)),

    I1("i1", new Position(9, 8)),
    I2("i2", new Position(8, 8)),
    I3("i3", new Position(7, 8)),
    I4("i4", new Position(6, 8)),
    I5("i5", new Position(5, 8)),
    I6("i6", new Position(4, 8)),
    I7("i7", new Position(3, 8)),
    I8("i8", new Position(2, 8)),
    I9("i9", new Position(1, 8)),
    I10("i10", new Position(0, 8));

    private final String text;
    private final Position position;

    PositionText(final String text, final Position position) {
        this.text = text;
        this.position = position;
    }

    static Position positionOf(final String text) {
        PositionText positionText = Arrays.stream(values())
                .filter(value -> value.text.equalsIgnoreCase(text))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 위치를 입력하셨습니다."));
        return positionText.position;
    }
}
