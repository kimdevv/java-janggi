package model.piece;

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

    public List<Piece> getPieces() {
        return pieces;
    }

    /*public static Pieces createAndInit() {
        return new Pieces();
    }

    public Optional<Piece> findPieceOfView(Position position) {
        return pieces.stream()
                .filter(piece -> piece.getPosition().equals(position))
                .findFirst();
    }

    public Piece findPiece(Position position) {
        return pieces.stream()
                .filter(piece -> piece.getPosition().equals(position))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 위치에 기물 없음"));
    }

    public void validateCanMove(Piece piece, Position destination) {
        List<Position> positions = findDirectionOfPiece(piece, destination); // 목적지 찾기
        validateMiddleDirection(destination, positions); // 중간 목적지
        validateDestination(piece, destination); // 같은 팀이라면 에러, 다른 팀이라면 제거
        movePosition(piece, destination);
    }

    private List<Position> findDirectionOfPiece(Piece piece, Position destination) {
        List<List<Position>> findResults = piece.calculateAllDirection();
        return findResults.stream()
                .filter(positions -> positions.contains(destination))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 위치로는 이동할 수 없습니다."));
    }

    private void validateMiddleDirection(Position destination, List<Position> positions) {
        boolean isAlreadyExist = positions.stream()
                .filter(this::isAlreadyExist)
                .anyMatch(position -> !position.equals(destination));

        if (isAlreadyExist) {
            throw new IllegalArgumentException("해당 위치로는 이동할 수 없습니다.");
        }
    }

    private boolean isAlreadyExist(Position position) {
        return pieces.stream()
                .anyMatch(piece -> piece.getPosition().equals(position));
    }

    private void validateDestination(Piece myPiece, Position destination) {
        Optional<Piece> hasExistPiece = findPieceOptional(destination);
        if (hasExistPiece.isEmpty()) {
            return;
        }
        Piece existPiece = hasExistPiece.get();
        if (myPiece.getTeam() == existPiece.getTeam()) {
            throw new IllegalArgumentException("해당 위치로는 이동할 수 없습니다.");
        }
        pieces.remove(existPiece);
    }

    public void validateCannonMove(Piece piece, Position destination) {
        List<Position> positions = findDirectionOfPiece(piece, destination); // 목적지 찾기
        validateMiddleDirectionOfCannon(destination, positions);
        validateDestinationOfCannon(piece, destination); // 같은 팀이라면 에러, 다른 팀이라면 제거
        movePosition(piece, destination);
    }

    private void validateMiddleDirectionOfCannon(Position destination, List<Position> positions) {
        long pieceCount = positions.stream()
            .filter(this::isAlreadyExist)
            .filter(position -> !position.equals(destination))
            .count();

        boolean hasCannon = positions.stream()
            .anyMatch(this::hasCannon);

        if (pieceCount == 1 && !hasCannon) {
            return;
        }
        throw new IllegalArgumentException("해당 위치로는 이동할 수 없습니다.");
    }

    private boolean hasCannon(Position position) {
        return pieces.stream()
                .filter(piece -> piece.getPosition().equals(position))
                .anyMatch(piece -> piece.getClass() == Cannon.class);
    }

    private void validateDestinationOfCannon(Piece myPiece, Position destination) {
        Optional<Piece> hasExistPiece = findPieceOptional(destination);
        if (hasExistPiece.isEmpty()) {
            return;
        }
        Piece existPiece = hasExistPiece.get();
        if (myPiece.getTeam() == existPiece.getTeam() || existPiece.isCannon()) {
            throw new IllegalArgumentException("해당 위치로는 이동할 수 없습니다.");
        }
        pieces.remove(existPiece);
    }

    private Optional<Piece> findPieceOptional(Position destination) {
        Optional<Piece> hasExistPiece = this.pieces.stream()
            .filter(piece -> piece.getPosition().equals(destination))
            .findFirst();
        return hasExistPiece;
    }

    private void movePosition(Piece myPiece, Position destination) {
        myPiece.changePosition(destination);
    }*/
}
