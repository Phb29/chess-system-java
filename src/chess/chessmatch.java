package chess;

import boardgame.board;
import boardgame.position;
import chess.pieces.Rook;
import chess.pieces.king;

public class chessmatch {
	private board Board;
	
	public chessmatch() {
		Board=new board(8,8);
		initialsetup();
		
	}
	public chesspiece[][] getpieces(){
		chesspiece[][] mat= new chesspiece[Board.getRows()][Board.getColumns()];
	for(int i=0; i<Board.getRows(); i++) {
		for(int j=0; j<Board.getColumns();j++) {
			mat[i][j]=(chesspiece) Board.Piece(i,j);
	}
	}
	return mat;
	}
	private void initialsetup() {
		Board.placepiece(new Rook(Board,color.WHITE), new position(2,1));
		Board.placepiece(new king(Board,color.BLACK), new position(0,4));
	}
	
	

}
