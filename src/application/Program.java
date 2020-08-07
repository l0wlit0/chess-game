package application;

import boardgame.Board;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while(!chessMatch.isCheckMate()) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.printf("Source: ");
                ChessPosition source = UI.readChessPosition(in);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.printf("Target: ");
                ChessPosition target = UI.readChessPosition(in);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                if (capturedPiece != null)
                    captured.add(capturedPiece);

                if (ChessMatch.getPromoted() != null){
                    System.out.print("Enter piece for promotion (B/H/R/Q): ");
                    String type = in.nextLine().toUpperCase();
                    while (!type.equals("B") && !type.equals("H") && !type.equals("R") && !type.equals("Q")){
                        System.out.print("Invalid value! Enter piece for promotion (B/H/R/Q): ");
                        type = in.nextLine().toUpperCase();
                    }
                    chessMatch.replacePromotedPiece(type);
                }
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
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}
