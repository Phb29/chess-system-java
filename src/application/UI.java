package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessPosition;
import chess.chessmatch;
import chess.chesspiece;
import chess.color;

public class UI {
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	// serve pra limpar tela o codigo a baixo//
	public static void clearScreen() {
	 System.out.print("\033[H\033[2J");
	 System.out.flush();
	}

	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String s = sc.nextLine();
			char column = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			return new ChessPosition(column, row);

		} catch (RuntimeException e) {
			throw new InputMismatchException("error reading  chess position");
		}
	}

	public static void printmatch(chessmatch Chessmatch) {
		printboard(Chessmatch.getpieces());
		System.out.println();
		System.out.println("turn"+ Chessmatch.getturn());
		System.out.println("waiting player" + Chessmatch.getcurrentplayer());
		
	}
	
	public static void printboard(chesspiece[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printpiece(pieces[i][j],false);
				//indicar q nenhuma pessa tenha fundo colorido
			}
			System.out.println();

		}
		System.out.println("  a b c d e f g h");

	}
	public static void printboard(chesspiece[][] pieces,boolean[][]possiblemoves) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printpiece(pieces[i][j],possiblemoves[i][j]);
			}
			System.out.println();

		}
		System.out.println("  a b c d e f g h");
	}
			
		
	private static void printpiece(chesspiece piece,boolean background)
	{
		if (background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
	
	//vatiavel pra indicar se deve colorir ou nao {
		if (piece == null) {
			System.out.print("-"+ANSI_RESET);
		} else {
			if (piece.getColor() == color.WHITE) {
				System.out.print(ANSI_WHITE + piece + ANSI_RESET);
			} else {
				System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
			}
		}
		System.out.print(" ");
	}
}
