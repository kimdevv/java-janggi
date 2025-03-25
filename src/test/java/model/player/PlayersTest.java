package model.player;

import model.piece.Pieces;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    private Players players;

    @Test
    void 플레이어가_몇_명인지_계산한다() {
        // Given
        Player greenPlayer = new Player(Pieces.initializerGreenTeamPieces(), Team.GREEN);
        Player redPlayer = new Player(Pieces.initializerRedTeamPieces(), Team.RED);
        players = new Players(List.of(greenPlayer, redPlayer));

        // When & Then
        assertThat(players.getPlayerCount()).isEqualTo(2);
    }

    @Test
    void 주어진_팀에_해당하는_플레이어를_찾는다() {
        // Given
        Player greenPlayer = new Player(Pieces.initializerGreenTeamPieces(), Team.GREEN);
        Player redPlayer = new Player(Pieces.initializerRedTeamPieces(), Team.RED);
        Players players = new Players(List.of(greenPlayer, redPlayer));

        // When & Then
        assertThat(players.findPlayerInTeam(Team.GREEN)).isEqualTo(greenPlayer);
        assertThat(players.findPlayerInTeam(Team.RED)).isEqualTo(redPlayer);
    }

    @Test
    void 주어진_플레이어를_제거한다() {
        // Given
        Player greenPlayer = new Player(Pieces.initializerGreenTeamPieces(), Team.GREEN);
        Player redPlayer = new Player(Pieces.initializerRedTeamPieces(), Team.RED);
        players = new Players(List.of(greenPlayer, redPlayer));

        // When
        players.remove(greenPlayer);

        // Then
        assertThat(players.getPlayerCount()).isEqualTo(1);
    }

    @Test
    void 첫_번째_플레이어를_제거하고_반환한다() {
        // Given
        Player greenPlayer = new Player(Pieces.initializerGreenTeamPieces(), Team.GREEN);
        Player redPlayer = new Player(Pieces.initializerRedTeamPieces(), Team.RED);
        players = new Players(List.of(greenPlayer, redPlayer));

        // When & Then
        assertThat(players.removeFirst()).isEqualTo(greenPlayer);
    }
}
