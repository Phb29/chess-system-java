package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessPosition;
import chess.chessexception;
import chess.chessmatch;
import chess.chesspiece;

public class Program {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		chessmatch Chessmatch = new chessmatch();
		List<chesspiece> captured= new ArrayList<>();

		while (true) {
			try {
			UI.clearScreen();
			UI.printmatch(Chessmatch,captured);
			System.out.println();
			System.out.print("source:");
			ChessPosition source=UI.readChessPosition(sc);
			
			boolean[][] possiblemoves= Chessmatch.possiblemoves(source);
			UI.clearScreen();
			UI.printboard(Chessmatch.getpieces(),possiblemoves);
					
			System.out.println();
			System.out.print("target:");
			ChessPosition target=UI.readChessPosition(sc);
			
			chesspiece capturedpiece=Chessmatch.performChessMove(source, target);
			
		
			if(capturedpiece !=null) {
				captured.add(capturedpiece);
			}
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
