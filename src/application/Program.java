package application;

import boardgame.Board;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while(true) {
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.printf("Source: ");
                ChessPosition source = UI.readChessPosition(in);

                System.out.println();
                System.out.printf("Target: ");
                ChessPosition target = UI.readChessPosition(in);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }
            catch (ChessException e){
                System.out.println(e.getMessage());
                in.nextLine();
            }
            catch (InputMismatchException  e){
                System.out.println(e.getMessage());
                in.nextLine();
            }
        }
    }
}
