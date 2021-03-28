package chess;

import boardgame.board;
import boardgame.piece;
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
	public chesspiece performChessMove(ChessPosition sourceposition,ChessPosition targetposition) {
		position  source=sourceposition.toposition();
		position target=targetposition.toposition();
		validateSourcePosition(source);
		piece capturedPiece=makeMove(source,target);
		return (chesspiece)capturedPiece;
	}
	private piece makeMove(position source,position target) {
		piece p=Board.removePiece(source);
		piece capturedpiece=Board.removePiece(target);
		Board.placepiece(p, target);
		return capturedpiece;
	}
	
	private void validateSourcePosition(position Position) {
		if(!Board.thereiseapiece(Position)) {
			throw new chessexception("there is no piece on  source position");
		}
	}
	private void placenewpiece(char column,int row,chesspiece Piece) {
		Board.placepiece(Piece, new  ChessPosition(column, row).toposition());
		
	}
	private void initialsetup() {
		placenewpiece('c', 1, new Rook(Board, color.WHITE));
        placenewpiece('c', 2, new Rook(Board, color.WHITE));
        placenewpiece('d', 2, new Rook(Board, color.WHITE));
        placenewpiece('e', 2, new Rook(Board, color.WHITE));
        placenewpiece('e', 1, new Rook(Board, color.WHITE));
        placenewpiece('d', 1, new king(Board, color.WHITE));

        placenewpiece('c', 7, new Rook(Board, color.BLACK));
        placenewpiece('c', 8, new Rook(Board, color.BLACK));
        placenewpiece('d', 7, new Rook(Board, color.BLACK));
        placenewpiece('e', 7, new Rook(Board, color.BLACK));
        placenewpiece('e', 8, new Rook(Board, color.BLACK));
        placenewpiece('d', 8, new king(Board, color.BLACK));
	}

	}
	
	


