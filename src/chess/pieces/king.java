package chess.pieces;

import boardgame.board;
import chess.chesspiece;
import chess.color;

public class king extends chesspiece {

	public king(board board, color color) {
		super(board, color);
		
	}
	@Override 
	public String toString() {
		return "K";
	}

}
