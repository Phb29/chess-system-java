package chess;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.board;
import boardgame.piece;
import boardgame.position;
import chess.pieces.Rook;
import chess.pieces.bishop;
import chess.pieces.king;
import chess.pieces.knigth;
import chess.pieces.pawn;
import chess.pieces.queen;

public class chessmatch {
	private int turn;
	private color currentplayer;
	private boolean check;
	private boolean checkmate;
	// propriedade boolean por padrao começa com falso
	
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
	public boolean getcheck() {
		return check;
		//quando usa get pra pegar em outra camada
	}
	public boolean getcheckmate() {
		return checkmate;
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
		if(testcheck(currentplayer)) {
			undomove(source, target, capturedPiece);
			throw new chessexception("you can't put your self check");
		}
		check=(testcheck(opponent(currentplayer)))? true : false;
				//se essa condição for verdadeira a partida ta em check,se nao false
		if(testcheck(opponent(currentplayer))) {
			checkmate= true;
		}
		else {
		
		nextturn();
		}
		return (chesspiece)capturedPiece;
	}
	private piece makeMove(position source,position target) {
		chesspiece p=(chesspiece)Board.removePiece(source);
		p.increasemovecount();
		
		piece capturedpiece=Board.removePiece(target);
		Board.placepiece(p, target);
		
		if(capturedpiece!=null) {
			piecesontheboard.remove(capturedpiece);
			capturedpieces.add(capturedpiece);
			//serve pra controlar quando tira peça e add nas capturdas;
		}
		
		
		return capturedpiece;
	}
	private void undomove(position source,position target,piece capturedpiece) {
		chesspiece p=(chesspiece)Board.removePiece(target);
		p.decreasemovecount();
		//o down cast ae serve pq fica dentro do chesspice,por isso usar
		
		Board.placepiece(p, source);
		
		if(capturedpiece!=null) {
			Board.placepiece(capturedpiece, target);
			capturedpieces.remove(capturedpiece);
			piecesontheboard.add(capturedpiece);
			//metodo pra desfazer jogada
		}
		
		
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
		private color opponent(color 	Color)	{
			return(Color==color.WHITE)? color.BLACK : color.WHITE;
		}
		private chesspiece king(color Color) {
			List<piece>list=piecesontheboard.stream().filter(x->((chesspiece)x).getColor()==Color).collect(Collectors.toList());
			for (piece p:list) {
				if(p instanceof king) {
					return (chesspiece)p;
				}
			}
			throw new IllegalStateException("there is no"+Color+"king on the board");
		}
		private  boolean testcheck(color Color) {
			position kingposition=king(Color).getchessposition().toposition();
			List<piece>opponentpiece=piecesontheboard.stream().filter(x->((chesspiece)x).getColor()==opponent(Color)).collect(Collectors.toList());
			for(piece p:opponentpiece) {
				boolean[][]mat=p.possiblemoves();
				if(mat[kingposition.getRow()][kingposition.getColumn()]) {
					return true;
					//serve pr ver se o 3e=rei ta em check
				}
		
				
			}
			return false;
			//se esgotar e ver q n ta check volta falso
		}
		private  boolean testcheckmate(color Color) {
			if(!testcheck(Color)) {
				return false;
				// se a cor n tiver em check,returna false
			}
			List<piece>list=piecesontheboard.stream().filter(x->((chesspiece)x).getColor()==opponent(Color)).collect(Collectors.toList());
			for(piece p:list) {
				boolean[][] mat=p.possiblemoves();
				for(int i=0;i<Board.getRows();i++) {
					for(int j=0;j<Board.getColumns();j++){
						if(mat[i][j]) {
							position source=((chesspiece)p).getchessposition().toposition();
							position target=new position(i,j);
							piece capturedpiece=makeMove(source, target);
							boolean testcheck=testcheck(Color);
							undomove(source, target, capturedpiece);
							if(!testcheck) {
								return false;
								//essa é a logica do checkmate
							}
						}
					}
				}
				
				
			}
			return true;
			// acima fala se n tiver nenhum movimento possivel,retorna check mat
		}
		
		

	private void placenewpiece(char column,int row,chesspiece Piece) {
		Board.placepiece(Piece, new  ChessPosition(column, row).toposition());
		piecesontheboard.add(Piece);
		// alem de colocar peça tabuleiro,o de baixo coloca na lista tabuleiro
		
	}
	
	private void initialsetup() {
		placenewpiece('a', 1, new Rook(Board, color.WHITE));
        placenewpiece('h', 1, new Rook(Board, color.WHITE));
        placenewpiece('e', 1, new king(Board, color.WHITE));
        placenewpiece('a', 2, new pawn(Board,color.WHITE));
        placenewpiece('b', 2, new pawn(Board,color.WHITE));
        placenewpiece('c', 2, new pawn(Board,color.WHITE));
        placenewpiece('d', 2, new pawn(Board,color.WHITE));
        placenewpiece('e', 2, new pawn(Board,color.WHITE));
        placenewpiece('f', 2, new pawn(Board,color.WHITE));
        placenewpiece('g', 2, new pawn(Board,color.WHITE));
        placenewpiece('h', 2, new pawn(Board,color.WHITE));
        placenewpiece('c',1, new bishop(Board,color.WHITE));
        placenewpiece('f',1, new bishop(Board,color.WHITE));
        placenewpiece('b',1, new knigth(Board,color.WHITE));
        placenewpiece('g',1, new knigth(Board,color.WHITE));
        placenewpiece('d',1, new queen(Board,color.WHITE));
        
        placenewpiece('d',8, new queen(Board,color.BLACK));
        placenewpiece('b',8, new knigth(Board,color.BLACK));
        placenewpiece('g',8, new knigth(Board,color.BLACK));
        placenewpiece('a', 8, new Rook(Board, color.BLACK));
        placenewpiece('h', 8, new Rook(Board, color.BLACK));
        placenewpiece('e', 8, new king(Board, color.BLACK));
        placenewpiece('f',8, new bishop(Board,color.BLACK));
        placenewpiece('c',8, new bishop(Board,color.BLACK));
        placenewpiece('a', 7, new pawn(Board,color.BLACK));
        placenewpiece('b', 7, new pawn(Board,color.BLACK));
        placenewpiece('c', 7, new pawn(Board,color.BLACK));
        placenewpiece('d', 7, new pawn(Board,color.BLACK));
        placenewpiece('e', 7, new pawn(Board,color.BLACK));
        placenewpiece('f', 7, new pawn(Board,color.BLACK));
        placenewpiece('g', 7, new pawn(Board,color.BLACK));
        placenewpiece('h', 7, new pawn(Board,color.BLACK));
        
	}

	}
	
	


