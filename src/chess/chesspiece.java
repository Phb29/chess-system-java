package chess;

import boardgame.board;
import boardgame.piece;
import boardgame.position;

public abstract class chesspiece extends piece {
	private color Color;

	public chesspiece(board board, color color) {
		super(board);
		Color = color;
	}

	public color getColor() {
		return Color;
	}
protected boolean isthereoponentpiece(position Position) {
	chesspiece p= (chesspiece) getBoard().Piece(Position);
	return p!=null && p.getColor() !=Color;
	// esse comando para ver se pode pegar peça do oponente
	
}
	

}
