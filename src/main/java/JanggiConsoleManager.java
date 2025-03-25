import model.player.JanggiProcess;
import model.piece.Piece;
import model.piece.Pieces;
import model.player.Player;
import model.player.Team;
import model.position.Position;
import view.InputView;
import view.OutputView;

public class JanggiConsoleManager {

    private final InputView inputView;
    private final OutputView outputView;

    public JanggiConsoleManager(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startJanggi() {
        Player greenPlayer = new Player(Pieces.initializerGreenTeamPieces(), Team.GREEN);
        Player redPlayer = new Player(Pieces.initializerRedTeamPieces(), Team.RED);
        JanggiProcess janggiProcess = JanggiProcess.initializeWithGreenAndRedPlayers(greenPlayer, redPlayer);
        progressTurnUntilEnd(janggiProcess, greenPlayer, redPlayer);
        outputView.outputWinner(janggiProcess.getWinner());
    }

    private void progressTurnUntilEnd(final JanggiProcess janggiProcess, final Player greenPlayer, final Player redPlayer) {
        while (janggiProcess.isTwoPlayersAlive()) {
            outputView.outputCurrentJanggiBoard(redPlayer.getPieces(), greenPlayer.getPieces());
            progressTurn(janggiProcess);
        }
    }

    private void progressTurn(JanggiProcess janggiProcess) {
        try {
            Piece movePiece = findPieceToMove(janggiProcess);
            Position destination = inputView.inputDestinationToMove(movePiece.getPieceType());
            janggiProcess.processCurrentTurnPieceMove(movePiece, destination);
        } catch (IllegalArgumentException exception) {
            outputView.outputExceptionMessage(exception.getMessage());
        }
    }

    private Piece findPieceToMove(final JanggiProcess janggiProcess) {
        Team currentTurnTeam = janggiProcess.getCurrentTurnPlayerTeam();
        Position startPosition = inputView.inputCurrentTeamMovePiecePosition(currentTurnTeam);
        return janggiProcess.findCurrentTurnPlayerPieceAt(startPosition);
    }
}
