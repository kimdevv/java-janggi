package model;

import model.piece.Piece;
import model.piece.PieceType;
import model.piece.position.Position;
import model.player.Player;
import model.player.Players;
import model.player.Team;

import java.util.ArrayList;
import java.util.List;

public class JanggiState {

    public static final int COUNT_OF_JANGGI_PLAYER = 2;
    private final Players players;
    private Team currentTurn;

    private JanggiState(final Players players, final Team firstTurnTeam) {
        this.players = players;
        this.currentTurn = firstTurnTeam;
    }

    public static JanggiState intializeJanggi(final Player greenPlayer, final Player redPlayer, final Team firstTurnTeam) {
        Players players = new Players(List.of(greenPlayer, redPlayer));
        return new JanggiState(players, firstTurnTeam);
    }

    public boolean canGameContinue() {
        return players.getAlivePlayers().size() == COUNT_OF_JANGGI_PLAYER;
    }

    public Team getCurrentTurnTeam() {
        return currentTurn;
    }

    public Piece findCurrentTurnPlayerPieceAt(final Position position) {
        return getCurrentTurnPlayer().findPieceAt(position);
    }

    private Player getCurrentTurnPlayer() {
        return players.getPlayerByTeam(currentTurn);
    }

    public void movePiece(final Piece piece, final Position destination) {
        validateDestination(piece, destination);
        validateMiddleRoute(piece, destination);
        removeOtherPlayerPieceIfExistAt(destination);
        piece.changePosition(destination);
    }

    private Player getNotCurrentTurnPlayer() {
        Team otherTeam = currentTurn.getOtherTeam();
        return players.getPlayerByTeam(otherTeam);
    }

    private void validateDestination(final Piece piece, final Position destination) {
        if (piece.getPieceType() == PieceType.CANNON) {
            validateDestinationOfCannon(destination);
            return;
        }
        validateDestinationExcludeCannon(destination);
    }

    private void validateDestinationOfCannon(final Position destination) {
        Player currentPlayer = getCurrentTurnPlayer();
        Player otherPlayer = getNotCurrentTurnPlayer();
        if (currentPlayer.isPieceExistAt(destination) || otherPlayer.isCannonExistAt(destination)) {
            throw new IllegalArgumentException("해당 위치로 움직일 수 없는 상태입니다.");
        }
    }

    private void validateDestinationExcludeCannon(final Position destination) {
        Player currentPlayer = getCurrentTurnPlayer();
        if (currentPlayer.isPieceExistAt(destination)) {
            throw new IllegalArgumentException("해당 위치로 움직일 수 없는 상태입니다.");
        }
    }

    private void validateMiddleRoute(final Piece piece, final Position destination) {
        List<Position> routeToDestinationExcludeDestination = excludeDestinationInRoute(piece, destination);
        if (piece.getPieceType() == PieceType.CANNON) {
            validateMiddleRouteOfCannon(routeToDestinationExcludeDestination);
            return;
        }
        validateMiddleRouteExcludeCannon(routeToDestinationExcludeDestination);
    }

    private void validateMiddleRouteOfCannon(final List<Position> routeToDestinationExcludeDestination) {
        Player currentPlayer = getCurrentTurnPlayer();
        Player otherPlayer = getNotCurrentTurnPlayer();
        int countOfPiecesAtRouteExcludeDestination = currentPlayer.countPiecesAtRoute(routeToDestinationExcludeDestination)
                + otherPlayer.countPiecesAtRoute(routeToDestinationExcludeDestination);
        if (countOfPiecesAtRouteExcludeDestination != 1
                || currentPlayer.isCannonExistAtRoute(routeToDestinationExcludeDestination) || otherPlayer.isCannonExistAtRoute(routeToDestinationExcludeDestination)) {
            throw new IllegalArgumentException("해당 위치로 움직일 수 없는 상태입니다.");
        }
    }

    private void validateMiddleRouteExcludeCannon(final List<Position> routeToDestinationExcludeDestination) {
        Player currentPlayer = getCurrentTurnPlayer();
        Player otherPlayer = getNotCurrentTurnPlayer();
        if (currentPlayer.isPieceExistAtRoute(routeToDestinationExcludeDestination) || otherPlayer.isPieceExistAtRoute(routeToDestinationExcludeDestination)) {
            throw new IllegalArgumentException("해당 위치로 움직일 수 없는 상태입니다.");
        }
    }

    private List<Position> excludeDestinationInRoute(final Piece piece, final Position destination) {
        List<Position> routeToDestination = new ArrayList<>(piece.calculateRouteToDestination(destination));
        routeToDestination.removeFirst();
        return routeToDestination;
    }

    private void removeOtherPlayerPieceIfExistAt(final Position position) {
        Player otherPlayer = getNotCurrentTurnPlayer();
        if (otherPlayer.isPieceExistAt(position)) {
            makeOtherPlayerGameOverIfGeneralBeKilled(otherPlayer, position);
            otherPlayer.removePieceAt(position);
        }
    }

    private void makeOtherPlayerGameOverIfGeneralBeKilled(final Player otherPlayer, final Position destination) {
        if (otherPlayer.isGeneralExistAt(destination)) {
            otherPlayer.makeDead();
        }
    }

    public void changeTurn() {
        currentTurn = currentTurn.getOtherTeam();
    }

    public Player getWinner() {
        List<Player> alivePlayers = players.getAlivePlayers();
        if (alivePlayers.size() == COUNT_OF_JANGGI_PLAYER) {
            throw new IllegalArgumentException("아직 승자가 결정되지 않았습니다.");
        }
        return alivePlayers.getFirst();
    }

    public int calculateTeamPoints(final Team team) {
        return players.calculateTeamPoints(team);
    }

    public Player getPlayerByTeam(final Team team) {
        return players.getPlayerByTeam(team);
    }
}
