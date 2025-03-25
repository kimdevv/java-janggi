package model.player;

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
}
