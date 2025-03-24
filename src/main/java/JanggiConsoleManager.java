import model.piece.Piece;
import model.piece.Pieces;
import model.player.Player;
import model.player.Team;
import model.position.Position;
import view.InputView;
import view.OutputView;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

        Queue<Player> queue = new ArrayDeque<>();
        queue.add(greenPlayer);
        queue.add(redPlayer);
        while (queue.size() == 2) {
            outputView.outputCurrentJanggiBoard(redPlayer.getPieces(), greenPlayer.getPieces());
            Player currentPlayer = queue.poll();
            Position startPosition = inputView.inputCurrentTeamMovePiecePosition(currentPlayer.getTeam());
            Piece piece = currentPlayer.findPieceAt(startPosition);
            Position destination = inputView.inputDestinationToMove(piece);
            List<Position> routeToDestination = new ArrayList<>(piece.calculateRouteToDestination(destination));
            routeToDestination.removeFirst();
            Player otherPlayer = queue.peek();
            if (otherPlayer.isPieceExistAtRoute(routeToDestination)) {
                throw new IllegalArgumentException("해당 위치로 움직일 수 없는 상태입니다.");
            }
            if (otherPlayer.isGeneralExistAt(destination)) {
                queue.poll();
            }
            otherPlayer.removePieceAt(destination);
            piece.changePosition(destination);
            queue.add(currentPlayer);
        }
        outputView.outputWinner(queue.poll());
    }
}
