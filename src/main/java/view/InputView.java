package view;

import model.piece.PieceType;
import model.player.Team;
import model.piece.position.Position;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public Position inputCurrentTeamMovePiecePosition(final Team team) {
        System.out.println(String.format("%s의 차례입니다. 움직일 기물의 위치를 입력해 주세요. (ex: b1)", TeamText.textOf(team)));
        return PositionText.positionOf(scanner.nextLine());
    }

    public Position inputDestinationToMove(final PieceType movePieceType) {
        System.out.println(String.format("%s를 선택했습니다. 이동할 위치를 선택해주세요.", PieceText.textOf(movePieceType)));
        return PositionText.positionOf(scanner.nextLine());
    }
}
