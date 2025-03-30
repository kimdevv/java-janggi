package model.player;

import java.util.List;

public class Players {

    private final List<Player> players;

    public Players(final List<Player> players) {
        this.players = players;
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

    public List<Player> getAlivePlayers() {
        return players.stream()
                .filter(player -> player.isAlive())
                .toList();
    }
}
