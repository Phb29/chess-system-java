package chess.pieces;

import boardgame.board;
import chess.chesspiece;
import chess.color;

public class Rook extends chesspiece {

	public Rook(board board, color color) {
		super(board, color);
		
	}
	@Override 
	public String toString() {
		return 	"R";
		
	}

}
