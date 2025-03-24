package model.player;

import model.piece.Piece;
import model.position.Position;

import java.util.ArrayList;
import java.util.List;

public class PlayersInOrder {

    public static final int COUNT_OF_JANGGI_PLAYER = 2;
    private final List<Player> players;
    private Team currentTurn;

    private PlayersInOrder(final List<Player> players) {
        this.players = players;
        currentTurn = Team.GREEN;
    }

    public static PlayersInOrder initializeWithGreenAndRedPlayers(final Player greenPlayer, final Player redPlayer) {
        return new PlayersInOrder(List.of(greenPlayer, redPlayer));
    }

    public boolean isTwoPlayersAlive() {
        return players.size() == COUNT_OF_JANGGI_PLAYER;
    }

    public Team getCurrentTurnPlayerTeam() {
        return currentTurn;
    }

    public Piece findCurrentTurnPlayerPieceAt(final Position position) {
        return getCurrentTurnPlayer().findPieceAt(position);
    }

    private Player getCurrentTurnPlayer() {
        return players.stream()
                .filter(player -> player.getTeam() == currentTurn)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사용자 목록이 잘못되었습니다."));
    }

    public void processCurrentTurnPieceMove(final Piece currentPlayerPiece, final Position destination) {
        validateDestination(destination);
        validateMiddleRoute(currentPlayerPiece, destination);
        makeOtherPlayerGameOverIfGeneralBeKilled(destination);
        removeOtherPlayerPieceAt(destination);
        currentPlayerPiece.changePosition(destination);
        currentTurn = currentTurn.getOtherTeam();
    }

    private Player getNotCurrentTurnPlayer() {
        return players.stream()
                .filter(player -> player.getTeam() != currentTurn)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사용자 목록이 잘못되었습니다."));
    }

    private void validateDestination(final Position destination) {
        Player currentPlayer = getCurrentTurnPlayer();
        if (currentPlayer.isPieceExistAt(destination)) {
            throw new IllegalArgumentException("해당 위치로 움직일 수 없는 상태입니다.");
        }
    }

    private void validateMiddleRoute(final Piece piece, final Position destination) {
        Player currentPlayer = getCurrentTurnPlayer();
        Player otherPlayer = getNotCurrentTurnPlayer();
        List<Position> routeToDestinationExcludeDestination = calculateRouteExcludeDestination(piece, destination);
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
        if (players.size() == COUNT_OF_JANGGI_PLAYER) {
            throw new IllegalArgumentException("아직 승자가 결정되지 않았습니다.");
        }
        return players.removeFirst();
    }
}
