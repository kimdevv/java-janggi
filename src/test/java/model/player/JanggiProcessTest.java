package model.player;

import model.piece.General;
import model.piece.Piece;
import model.piece.Pieces;
import model.position.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JanggiProcessTest {

    private Player greenPlayer;
    private Player redPlayer;
    private JanggiProcess janggiProcess;

    @BeforeEach
    void initialize() {
        greenPlayer = new Player(Pieces.initializerGreenTeamPieces(), Team.GREEN);
        redPlayer = new Player(Pieces.initializerRedTeamPieces(), Team.RED);
        janggiProcess = JanggiProcess.initializeWithGreenAndRedPlayers(greenPlayer, redPlayer);
    }

    @Test
    void 두_플레이어가_모두_생존한_상태인지_확인한다() {
        // Given
        // When & Then
        assertThat(janggiProcess.isTwoPlayersAlive()).isTrue();
    }

    @Test
    void 현재_턴_플레이어의_팀을_가져온다() {
        // Given
        // When & Then
        assertThat(janggiProcess.getCurrentTurnPlayerTeam()).isEqualTo(Team.GREEN);
    }

    @Test
    void 현재_턴_플레이어가_가진_기물_중_해당_위치의_기물을_가져온다() {
        // Given
        Position position = new Position(8, 4);

        // When & Then
        assertThat(janggiProcess.findCurrentTurnPlayerPieceAt(position))
                .isEqualTo(new General(position));
    }

    @Test
    void 현재_턴_플레이어가_가진_기물_중_해당_위치에_기물이_없는_경우_예외를_발생시킨다() {
        // Given
        Position position = new Position(1, 4);

        // When & Then
        assertThatThrownBy(() -> janggiProcess.findCurrentTurnPlayerPieceAt(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 위치에 기물이 존재하지 않습니다.");
    }

    @Test
    void 현재_턴_플레이어의_기물을_움직인다() {
        // Given & When
        Piece greenPiece = janggiProcess.findCurrentTurnPlayerPieceAt(new Position(6, 0));
        Position greenDestination = new Position(5, 0);
        janggiProcess.processCurrentTurnPieceMove(greenPiece, greenDestination);

        Piece redPiece = janggiProcess.findCurrentTurnPlayerPieceAt(new Position(3, 0));
        Position redDestination = new Position(4, 0);
        janggiProcess.processCurrentTurnPieceMove(redPiece, redDestination);

        // Then
        assertThat(janggiProcess.findCurrentTurnPlayerPieceAt(new Position(5, 0)))
                .isEqualTo(greenPiece);
    }

    @Test
    void 해당_기물이_움직일_수_없는_곳으로_움직이려고_할_경우_예외를_발생시킨다() {
        // Given
        Piece greenPiece = janggiProcess.findCurrentTurnPlayerPieceAt(new Position(6, 0));
        Position greenDestination = new Position(7, 0);

        // When & Then
        assertThatThrownBy(() -> janggiProcess.processCurrentTurnPieceMove(greenPiece, greenDestination))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("현재 기물이 이동할 수 없는 위치입니다.");
    }

    @Test
    void 이동_경로에_다른_기물이_있다면_이동할_수_없고_예외를_발생시킨다() {
        // Given
        Piece greenPiece = janggiProcess.findCurrentTurnPlayerPieceAt(new Position(9, 0));
        Position greenDestination = new Position(5, 0);

        // When & Then
        assertThatThrownBy(() -> janggiProcess.processCurrentTurnPieceMove(greenPiece, greenDestination))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 위치로 움직일 수 없는 상태입니다.");
    }
}
