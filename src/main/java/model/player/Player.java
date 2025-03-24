package model.player;

import model.piece.Piece;
import model.piece.PieceType;
import model.piece.Pieces;
import model.position.Position;

import java.util.List;

public class Player {

    private final Pieces pieces;
    private final Team team;

    public Player(final Pieces pieces, final Team team) {
        this.pieces = pieces;
        this.team = team;
    }

    public Piece findPieceAt(final Position position) {
        return pieces.findPieceAt(position);
    }

    public boolean isPieceExistAtRoute(final List<Position> routeToDestination) {
        return pieces.isPieceExistAtRoute(routeToDestination);
    }

    public boolean isGeneralExistAt(final Position destination) {
        if (isPieceExistAt(destination)) {
            return findPieceAt(destination).getPieceType() == PieceType.GENERAL;
        }
        return false;
    }

    public boolean isPieceExistAt(final Position position) {
        return pieces.isPieceExistAt(position);
    }

    public void removePieceAt(final Position position) {
        pieces.removePieceAt(position);
    }

    public Pieces getPieces() {
        return pieces;
    }

    public Team getTeam() {
        return team;
    }
}
