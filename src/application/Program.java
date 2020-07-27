package application;

import boardgame.Board;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while(true) {
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.printf("Source: ");
            ChessPosition source = UI.readChessPosition(in);

            System.out.println();
            System.out.printf("Target: ");
            ChessPosition target = UI.readChessPosition(in);

            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
        }
    }
}
