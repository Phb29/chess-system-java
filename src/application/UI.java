package application;

import chess.chesspiece;

public class UI {
	public static void printboard(chesspiece [][] pieces) {
		for(int i=0; i<pieces.length;i++) {
			System.out.print((8-i)+" ");
			for(int j=0;j<pieces.length;j++) {
				printpiece(pieces[i][j]);
			}
			System.out.println();
				
		}
		System.out.println("  a b c d e f g h");
		
	}
	private static void printpiece(chesspiece Piece) {
		if(Piece==null) {
			System.out.print("-");	
		}
		else {
			System.out.print(Piece);
		}
		System.out.print(" ");
			
	}

}
