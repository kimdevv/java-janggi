package model.player;

import model.piece.Pieces;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private final List<Player> players;

    public Players(final List<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public int getPlayerCount() {
        return players.size();
    }

    public Player findPlayerInTeam(final Team team) {
        return players.stream()
                .filter(player -> player.getTeam() == team)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사용자 목록이 잘못되었습니다."));
    }

    public void remove(final Player player) {
        players.remove(player);
    }

    public Player removeFirst() {
        return players.removeFirst();
    }

    public boolean isAllPlayersAlive() {
        return players.stream()
                .anyMatch(player -> !player.isAlive());
    }

    public Player getPlayerByTeam(final Team team) {
        return players.stream()
                .filter(player -> player.getTeam() == team)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 팀입니다."));
    }

    public int calculateTeamPoints(final Team team) {
        return getPlayerByTeam(team).calculatePoints();
    }
}
