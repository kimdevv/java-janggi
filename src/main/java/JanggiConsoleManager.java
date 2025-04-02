import dao.DatabaseConnectionManager;
import dao.GameDao;
import dao.PieceDao;
import model.Answer;
import model.JanggiState;
import model.piece.Piece;
import model.piece.Pieces;
import model.player.Player;
import model.player.Team;
import model.piece.position.Position;
import view.InputView;
import view.OutputView;

public class JanggiConsoleManager {

    private final InputView inputView;
    private final OutputView outputView;
    private final PieceDao pieceDao;
    private final GameDao gameDao;

    public JanggiConsoleManager(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

        DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager();
        this.pieceDao = new PieceDao(databaseConnectionManager.getConnection());
        this.gameDao = new GameDao(databaseConnectionManager.getConnection());
    }

    public void playJanggi() {
        JanggiState janggiState = initializeJanggiState();
        progressTurnUntilEnd(janggiState);
        outputView.outputWinner(janggiState.getWinner(), janggiState.calculateTeamPoints(Team.GREEN), janggiState.calculateTeamPoints(Team.RED));
        resetDatabase();
    }

    private JanggiState initializeJanggiState() {
        if (gameDao.isExist()) {
            return initializeWhenPreviousGameExist();
        }
        return initializeNewJanggiGame();
    }
    
    private JanggiState initializeWhenPreviousGameExist() {
        Answer answer = inputView.inputContinuePreviousGame();
        if (answer.isYes()) {
            return initializeFromPreviousJanggiGame();
        }
        resetDatabase();
        return initializeNewJanggiGame();
    }

    private JanggiState initializeFromPreviousJanggiGame() {
        Team currentTurnTeam = gameDao.findPreviousGameTurn();
        Pieces greenPieces = Pieces.continuePiecesFrom(pieceDao.findPieceByTeam(Team.GREEN));
        Pieces redPieces = Pieces.continuePiecesFrom(pieceDao.findPieceByTeam(Team.RED));
        Player greenPlayer = new Player(greenPieces, Team.GREEN);
        Player redPlayer = new Player(redPieces, Team.RED);
        return JanggiState.initializeJanggi(greenPlayer, redPlayer, currentTurnTeam);
    }

    private void resetDatabase() {
        gameDao.deleteGame();
        pieceDao.deleteAllPieces();
    }

    private JanggiState initializeNewJanggiGame() {
        Pieces greenPieces = Pieces.initializeGreenTeamPieces();
        Pieces redPieces = Pieces.initializeRedTeamPieces();
        Player greenPlayer = new Player(greenPieces, Team.GREEN);
        Player redPlayer = new Player(redPieces, Team.RED);
        initializePiecesToDB(greenPieces, redPieces);
        return JanggiState.initializeJanggi(greenPlayer, redPlayer, Team.GREEN);
    }

    public void initializePiecesToDB(final Pieces greenPieces, final Pieces redPieces) {
        pieceDao.addPieces(greenPieces, Team.GREEN);
        pieceDao.addPieces(redPieces, Team.RED);
        gameDao.addGame(Team.GREEN);
    }

    private void progressTurnUntilEnd(final JanggiState janggiState) {
        while (janggiState.canGameContinue()) {
            outputView.outputCurrentJanggiBoard(janggiState.getPlayerByTeam(Team.RED).getPieces(), janggiState.getPlayerByTeam(Team.GREEN).getPieces());
            progressTurn(janggiState);
        }
        outputView.outputCurrentJanggiBoard(janggiState.getPlayerByTeam(Team.RED).getPieces(), janggiState.getPlayerByTeam(Team.GREEN).getPieces());
    }

    private void progressTurn(final JanggiState janggiState) {
        try {
            Position startPosition = inputView.inputCurrentTeamMovePiecePosition(janggiState.getCurrentTurnTeam());
            Piece movePiece = janggiState.findCurrentTurnPlayerPieceAt(startPosition);
            Position destination = inputView.inputDestinationToMove(movePiece.getPieceType());
            janggiState.movePiece(movePiece, destination);
            janggiState.changeTurn();
            updateTurnResultToDatabase(janggiState.getCurrentTurnTeam(), startPosition, destination);
        } catch (IllegalArgumentException exception) {
            outputView.outputExceptionMessage(exception.getMessage());
        }
    }

    private void updateTurnResultToDatabase(final Team nextTurn, final Position startPosition, final Position destination) {
        pieceDao.deletePieceByPosition(destination);
        pieceDao.updatePiecePosition(startPosition, destination);
        gameDao.updateGameTurn(nextTurn);
    }
}
