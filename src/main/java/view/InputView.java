package view;

import model.player.Team;
import model.piece.Piece;
import model.position.Position;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public Position inputCurrentTeamMovePiecePosition(final Team team) {
        System.out.println(String.format("%s의 차례입니다. 움직일 기물의 위치를 입력해 주세요. (ex: b1)", TeamText.textOf(team)));
        return PositionText.positionOf(scanner.nextLine());
    }

    public Position inputDestinationToMove(final Piece piece) {
        System.out.println(String.format("%s를 선택했습니다. 이동할 위치를 선택해주세요.", PieceText.textOf(piece.getPieceType())));
        return PositionText.positionOf(scanner.nextLine());
    }
}
