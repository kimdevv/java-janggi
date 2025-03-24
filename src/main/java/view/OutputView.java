package view;

import model.piece.Piece;
import model.piece.Pieces;
import model.player.Player;
import model.position.Position;

import java.util.Arrays;

public class OutputView {

    private static final String RED_COLOR_ANSI_CODE = "\u001B[31m";
    private static final String GREEN_COLOR_ANSI_CODE = "\u001B[32m";
    private static final String COLOR_CANCEL_ANSI_CODE = "\u001B[0m";

    public void outputCurrentJanggiBoard(final Pieces redPieces, final Pieces greenPieces) {
        String[][] piecesPoisition = new String[10][9];
        for(int i=0; i<piecesPoisition.length; i++) {
            Arrays.fill(piecesPoisition[i], "－");
        }
        for (Piece piece : redPieces.getPieces()) {
            Position piecePosition = piece.getPosition();
            piecesPoisition[piecePosition.getRow()][piecePosition.getColumn()] = RED_COLOR_ANSI_CODE + PieceText.textOf(piece.getPieceType()) + COLOR_CANCEL_ANSI_CODE;
        }
        for (Piece piece : greenPieces.getPieces()) {
            Position piecePosition = piece.getPosition();
            piecesPoisition[piecePosition.getRow()][piecePosition.getColumn()] = GREEN_COLOR_ANSI_CODE + PieceText.textOf(piece.getPieceType()) + COLOR_CANCEL_ANSI_CODE;
        }

        System.out.println("\tＡＢＣＤＥＦＧＨＩ");
        for (int i=0; i<piecesPoisition.length; i++) {
            System.out.print(10 - i + "\t");
            for (int j=0; j<piecesPoisition[i].length; j++) {
                System.out.print(piecesPoisition[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void outputWinner(final Player player) {
        System.out.println(String.format("%s 팀이 승리하였습니다.", TeamText.textOf(player.getTeam())));
    }
}
