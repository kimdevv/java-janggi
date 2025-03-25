package model;

import model.piece.Piece;
import model.piece.PieceType;
import model.piece.Position;
import model.player.Player;
import model.player.Players;
import model.player.Team;

import java.util.ArrayList;
import java.util.List;

public class JanggiProcess {

    public static final int COUNT_OF_JANGGI_PLAYER = 2;
    private final Players players;
    private Team currentTurn;

    private JanggiProcess(final Players players) {
        this.players = players;
        currentTurn = Team.GREEN;
    }

    public static JanggiProcess initializeWithGreenAndRedPlayers(final Player greenPlayer, final Player redPlayer) {
        Players players = new Players(List.of(greenPlayer, redPlayer));
        return new JanggiProcess(players);
    }

    public boolean isTwoPlayersAlive() {
        return players.getPlayerCount() == COUNT_OF_JANGGI_PLAYER;
    }

    public Team getCurrentTurnPlayerTeam() {
        return currentTurn;
    }

    public Piece findCurrentTurnPlayerPieceAt(final Position position) {
        return getCurrentTurnPlayer().findPieceAt(position);
    }

    private Player getCurrentTurnPlayer() {
        return players.findPlayerInTeam(currentTurn);
    }

    public void processCurrentTurnPieceMove(final Piece currentPlayerPiece, final Position destination) {
        validateDestination(currentPlayerPiece, destination);
        validateMiddleRoute(currentPlayerPiece, destination);
        makeOtherPlayerGameOverIfGeneralBeKilled(destination);
        removeOtherPlayerPieceAt(destination);
        currentPlayerPiece.changePosition(destination);
        currentTurn = currentTurn.getOtherTeam();
    }

    private Player getNotCurrentTurnPlayer() {
        Team otherTeam = currentTurn.getOtherTeam();
        return players.findPlayerInTeam(otherTeam);
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
        List<Position> routeToDestinationExcludeDestination = calculateRouteExcludeDestination(piece, destination);
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

    private List<Position> calculateRouteExcludeDestination(final Piece piece, final Position destination) {
        List<Position> routeToDestination = new ArrayList<>(piece.calculateRouteToDestination(destination));
        routeToDestination.removeFirst();
        return routeToDestination;
    }

    private void makeOtherPlayerGameOverIfGeneralBeKilled(final Position destination) {
        Player otherPlayer = getNotCurrentTurnPlayer();
        if (otherPlayer.isGeneralExistAt(destination)) {
            players.remove(otherPlayer);
        }
    }

    private void removeOtherPlayerPieceAt(final Position position) {
        Player otherPlayer = getNotCurrentTurnPlayer();
        otherPlayer.removePieceAt(position);
    }

    public Player getWinner() {
        if (players.getPlayerCount() == COUNT_OF_JANGGI_PLAYER) {
            throw new IllegalArgumentException("아직 승자가 결정되지 않았습니다.");
        }
        return players.removeFirst();
    }
}
