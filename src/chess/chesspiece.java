package chess;

import boardgame.board;
import boardgame.piece;

public class chesspiece extends piece {
	private color Color;

	public chesspiece(board board, color color) {
		super(board);
		Color = color;
	}

	public color getColor() {
		return Color;
	}

	

}
