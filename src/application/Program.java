package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessPosition;
import chess.chessexception;
import chess.chessmatch;
import chess.chesspiece;

public class Program {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		chessmatch Chessmatch = new chessmatch();

		while (true) {
			try {
			UI.clearScreen();
			UI.printboard(Chessmatch.getpieces());
			System.out.println();
			System.out.print("source:");
			ChessPosition source=UI.readChessPosition(sc);
					
			System.out.println();
			System.out.print("target:");
			ChessPosition target=UI.readChessPosition(sc);
			
			chesspiece capturedpiece=Chessmatch.performChessMove(source, target);
			}
			catch(chessexception e) {
				System.out.println(e.getMessage());
				sc.nextLine();
				// get message pra imprimir mensagem na tela//
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
				// get message pra imprimir mensagem na tela//
			}
			
			
			
		}

	}

}
