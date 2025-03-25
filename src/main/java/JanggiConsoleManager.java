import model.player.PlayersInOrder;
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
        PlayersInOrder playersInOrder = PlayersInOrder.initializeWithGreenAndRedPlayers(greenPlayer, redPlayer);
        progressTurnUntilEnd(playersInOrder, greenPlayer, redPlayer);
        outputView.outputWinner(playersInOrder.getWinner());
    }

    private void progressTurnUntilEnd(final PlayersInOrder playersInOrder, final Player greenPlayer, final Player redPlayer) {
        while (playersInOrder.isTwoPlayersAlive()) {
            outputView.outputCurrentJanggiBoard(redPlayer.getPieces(), greenPlayer.getPieces());
            progressTurn(playersInOrder);
        }
    }

    private void progressTurn(PlayersInOrder playersInOrder) {
        try {
            Piece movePiece = findPieceToMove(playersInOrder);
            Position destination = inputView.inputDestinationToMove(movePiece.getPieceType());
            playersInOrder.processCurrentTurnPieceMove(movePiece, destination);
        } catch (IllegalArgumentException exception) {
            outputView.outputExceptionMessage(exception.getMessage());
        }
    }

    private Piece findPieceToMove(final PlayersInOrder playersInOrder) {
        Team currentTurnTeam = playersInOrder.getCurrentTurnPlayerTeam();
        Position startPosition = inputView.inputCurrentTeamMovePiecePosition(currentTurnTeam);
        return playersInOrder.findCurrentTurnPlayerPieceAt(startPosition);
    }
}
