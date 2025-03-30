package model.player;

import model.piece.Pieces;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @Test
    void 주어진_팀에_해당하는_플레이어를_찾는다() {
        // Given
        Player greenPlayer = new Player(Pieces.initializeGreenTeamPieces(), Team.GREEN);
        Player redPlayer = new Player(Pieces.initializeRedTeamPieces(), Team.RED);
        Players players = new Players(List.of(greenPlayer, redPlayer));

        // When & Then
        assertThat(players.getPlayerByTeam(Team.GREEN)).isEqualTo(greenPlayer);
        assertThat(players.getPlayerByTeam(Team.RED)).isEqualTo(redPlayer);
    }
}
