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
	private void placenewpiece(char column,int row,chesspiece Piece) {
		Board.placepiece(Piece, new  ChessPosition(column, row).toposition());
		
	}
	private void initialsetup() {
		placenewpiece('b',6,new Rook(Board,color.WHITE));
		placenewpiece('e',8,new king(Board,color.BLACK));
		placenewpiece('e',1,new king(Board,color.WHITE));
	}
	
	

}
