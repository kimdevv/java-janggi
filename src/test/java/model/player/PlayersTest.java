package model.player;

import model.piece.Pieces;
import model.piece.position.Position;
import org.junit.jupiter.api.BeforeEach;
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

    @Test
    void 주어진_팀에_해당하는_플레이어의_점수를_계산한다() {
        // Given
        Player greenPlayer = new Player(Pieces.initializeGreenTeamPieces(), Team.GREEN);
        Player redPlayer = new Player(Pieces.initializeRedTeamPieces(), Team.RED);
        redPlayer.removePieceAt(new Position(0, 0));
        Players players = new Players(List.of(greenPlayer, redPlayer));

        // When & Then
        assertThat(players.calculateTeamPoints(Team.GREEN)).isEqualTo(172);
        assertThat(players.calculateTeamPoints(Team.RED)).isEqualTo(159);
    }

    @Test
    void 살아있는_플레이어들을_모두_가져온다() {
        // Given
        Player greenPlayer = new Player(Pieces.initializeGreenTeamPieces(), Team.GREEN);
        Player redPlayer = new Player(Pieces.initializeRedTeamPieces(), Team.RED);
        redPlayer.makeDead();
        Players players = new Players(List.of(greenPlayer, redPlayer));

        // When & Then
        assertThat(players.getAlivePlayers())
                .isEqualTo(List.of(greenPlayer));
    }
}
