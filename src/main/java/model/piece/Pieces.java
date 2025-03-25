package model.piece;

import model.piece.position.DefaultPiecePositions;
import model.piece.position.Position;

import java.util.ArrayList;
import java.util.List;

public class Pieces {

    public final List<Piece> pieces;

    private Pieces(final List<Piece> pieces) {
        this.pieces = new ArrayList<>(pieces);
    }

    public static Pieces initializerRedTeamPieces() {
        return new Pieces(List.of(
                new General(DefaultPiecePositions.GENERAL_RED.getPosition()),
                new Guard(DefaultPiecePositions.GUARD_LEFT_RED.getPosition()),
                new Guard(DefaultPiecePositions.GUARD_RIGHT_RED.getPosition()),
                new Elephant(DefaultPiecePositions.ELEPHANT_LEFT_RED.getPosition()),
                new Elephant(DefaultPiecePositions.ELEPHANT_RIGHT_RED.getPosition()),
                new Horse(DefaultPiecePositions.HORSE_LEFT_RED.getPosition()),
                new Horse(DefaultPiecePositions.HORSE_RIGHT_RED.getPosition()),
                new Chariot(DefaultPiecePositions.CHARIOT_LEFT_RED.getPosition()),
                new Chariot(DefaultPiecePositions.CHARIOT_RIGHT_RED.getPosition()),
                new Cannon(DefaultPiecePositions.CANNON_LEFT_RED.getPosition()),
                new Cannon(DefaultPiecePositions.CANNON_RIGHT_RED.getPosition()),
                new Byeong(DefaultPiecePositions.BYEONG_FIRST_RED.getPosition()),
                new Byeong(DefaultPiecePositions.BYEONG_SECOND_RED.getPosition()),
                new Byeong(DefaultPiecePositions.BYEONG_THIRD_RED.getPosition()),
                new Byeong(DefaultPiecePositions.BYEONG_FOURTH_RED.getPosition()),
                new Byeong(DefaultPiecePositions.BYEONG_FIFTH_RED.getPosition())
        ));
    }

    public static Pieces initializerGreenTeamPieces() {
        return new Pieces(List.of(
                new General(DefaultPiecePositions.GENERAL_GREEN.getPosition()),
                new Guard(DefaultPiecePositions.GUARD_LEFT_GREEN.getPosition()),
                new Guard(DefaultPiecePositions.GUARD_RIGHT_GREEN.getPosition()),
                new Elephant(DefaultPiecePositions.ELEPHANT_LEFT_GREEN.getPosition()),
                new Elephant(DefaultPiecePositions.ELEPHANT_RIGHT_GREEN.getPosition()),
                new Horse(DefaultPiecePositions.HORSE_LEFT_GREEN.getPosition()),
                new Horse(DefaultPiecePositions.HORSE_RIGHT_GREEN.getPosition()),
                new Chariot(DefaultPiecePositions.CHARIOT_LEFT_GREEN.getPosition()),
                new Chariot(DefaultPiecePositions.CHARIOT_RIGHT_GREEN.getPosition()),
                new Cannon(DefaultPiecePositions.CANNON_LEFT_GREEN.getPosition()),
                new Cannon(DefaultPiecePositions.CANNON_RIGHT_GREEN.getPosition()),
                new Jol(DefaultPiecePositions.JOL_FIRST_GREEN.getPosition()),
                new Jol(DefaultPiecePositions.JOL_SECOND_GREEN.getPosition()),
                new Jol(DefaultPiecePositions.JOL_THIRD_GREEN.getPosition()),
                new Jol(DefaultPiecePositions.JOL_FOURTH_GREEN.getPosition()),
                new Jol(DefaultPiecePositions.JOL_FIFTH_GREEN.getPosition())
        ));
    }

    public Piece findPieceAt(final Position position) {
        return pieces.stream()
                .filter(piece -> piece.getPosition().equals(position))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 위치에 기물이 존재하지 않습니다."));
    }

    public boolean isPieceExistAt(final Position position) {
        return pieces.stream()
                .anyMatch(piece -> piece.getPosition().equals(position));
    }

    public boolean isPieceExistAtRoute(final List<Position> route) {
        return pieces.stream()
                .anyMatch(piece -> route.contains(piece.getPosition()));
    }

    public int countPiecesAtRoute(final List<Position> route) {
        return Math.toIntExact(pieces.stream()
                .filter(piece -> route.contains(piece.getPosition()))
                .count());
    }

    public boolean isCannonExistAtRoute(final List<Position> route) {
        return pieces.stream()
                .anyMatch(piece -> piece.getPieceType() == PieceType.CANNON && route.contains(piece.getPosition()));
    }

    public void removePieceAt(final Position position) {
        if (isPieceExistAt(position)) {
            Piece piece = findPieceAt(position);
            pieces.remove(piece);
        }
    }

    public List<Piece> getPieces() {
        return pieces;
    }
}
