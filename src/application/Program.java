package application;

import java.util.Scanner;

import chess.ChessPosition;
import chess.chessmatch;
import chess.chesspiece;

public class Program {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		chessmatch Chessmatch = new chessmatch();

		while (true) {
			UI.printboard(Chessmatch.getpieces());
			System.out.println();
			System.out.print("source:");
			ChessPosition source=UI.readChessPosition(sc);
					
			System.out.println();
			System.out.print("target:");
			ChessPosition target=UI.readChessPosition(sc);
			
			chesspiece capturedpiece=Chessmatch.performChessMove(source, target);
			
		}

	}

}
