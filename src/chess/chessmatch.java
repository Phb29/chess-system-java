package chess;



import java.util.ArrayList;
import java.util.List;

import boardgame.board;
import boardgame.piece;
import boardgame.position;
import chess.pieces.Rook;
import chess.pieces.king;

public class chessmatch {
	private int turn;
	private color currentplayer;
	private List<piece>piecesontheboard=new ArrayList<>();
	private List<piece>capturedpieces=new ArrayList<>();
	
	private board Board;
	
	
	public chessmatch() {
		Board=new board(8,8);
		initialsetup();
		turn=1;
		currentplayer=color.WHITE;
		
		
		
	}
	public int getturn() {
		return turn;
	}
	public color getcurrentplayer() {
		return currentplayer;
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
	public boolean[][]possiblemoves(ChessPosition sorceposition){
		position Position= sorceposition.toposition();
		validateSourcePosition(Position);
		return Board.Piece(Position).possiblemoves();
		//essa operação pra imprimir posição a partir posição origem
	}
	public chesspiece performChessMove(ChessPosition sourceposition,ChessPosition targetposition) {
		position  source=sourceposition.toposition();
		position target=targetposition.toposition();
		validattargetposition(source,target);
		validateSourcePosition(source);
		piece capturedPiece=makeMove(source,target);
		nextturn();
		return (chesspiece)capturedPiece;
	}
	private piece makeMove(position source,position target) {
		piece p=Board.removePiece(source);
		piece capturedpiece=Board.removePiece(target);
		Board.placepiece(p, target);
		
		if(capturedpiece!=null) {
			piecesontheboard.remove(capturedpiece);
			capturedpieces.add(capturedpiece);
			//serve pra controlar quando tira peça e add nas capturdas;
		}
		
		return capturedpiece;
	}
	
	private void validateSourcePosition(position Position) {
		if(!Board.thereiseapiece(Position)) {
			throw new chessexception("there is no piece on  source position");
		}
		if(currentplayer!=(( chesspiece) Board.Piece(Position)).getColor()) {
			throw new chessexception("piece is not yours");
		//esse down cast quando faz que eu retornei chesspiece
	//serviu para poder pegar a getcolor pq n estava dando
		}
		if(!Board.Piece(Position).ispossiblemove()) {
			throw new chessexception("there not moves possible");
			//exception quando n tem movimento possivel,o is pegou de outro lugar//
			//exclamação começo q fez ele n funcionar,significa
			//quando nao tiver posição ele faz a exception
		}
	}
	
	private void validattargetposition(position source,position target) {
		if(!Board.Piece(source).possiblemove(target)) {
			//se a pessa de origem n é moviemnto possivel
			throw new chessexception("no  possible move");
		}
	}
		private void nextturn() {
			turn++;
			currentplayer=(currentplayer==color.WHITE)?color.BLACK : color.WHITE;
			// interragação é a condição do se nao ele sera//
			
		}
	

	private void placenewpiece(char column,int row,chesspiece Piece) {
		Board.placepiece(Piece, new  ChessPosition(column, row).toposition());
		piecesontheboard.add(Piece);
		// alem de colocar peça tabuleiro,o de baixo coloca na lista tabuleiro
		
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
	
	


