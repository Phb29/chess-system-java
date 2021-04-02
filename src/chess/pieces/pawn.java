package chess.pieces;

import boardgame.board;
import boardgame.position;
import chess.chesspiece;
import chess.color;

public class pawn extends chesspiece {

	public pawn(board board, color color) {
		super(board, color);
		
	}

	@Override
	public boolean[][] possiblemoves() {
		boolean[][]mat =new boolean[getBoard().getRows()][getBoard().getColumns()];
		position p= new position(0, 0);
		if(getColor()==color.WHITE) {
			p.setvalues(Position.getRow()-1, Position.getColumn());
			//esse -1 é a  posição a cima testando
			if(getBoard().positionExists(p)&& !getBoard().thereiseapiece(p)) {
		mat[p.getRow()][p.getColumn()]=true;
			//se a posição acima dele existir e tiver vasia ele pode mover pra la
			
		}
		
			p.setvalues(Position.getRow()-2, Position.getColumn());
			position p2= new position(Position.getRow()-1, Position.getColumn());
			//esse -1 é a  posição a cima testando
			if(getBoard().positionExists(p2)&& !getBoard().thereiseapiece(p2) && getmovecount()==0);{
		mat[p.getRow()][p.getColumn()]=true;
			//se a posição acima dele existir e tiver vasia ele pode mover pra la
			
		}
			p.setvalues(Position.getRow()-1, Position.getColumn()-1);
			//esse -1 é a  posição a cima testando
			if(getBoard().positionExists(p)&& isthereoponentpiece(p)) {
		mat[p.getRow()][p.getColumn()]=true;
			// se tem posição la e tem opononte retorna verdadeira
			}
			p.setvalues(Position.getRow()-1, Position.getColumn()+1);
			//esse -1 é a  posição a cima testando
			if(getBoard().positionExists(p)&& isthereoponentpiece(p)) {
		mat[p.getRow()][p.getColumn()]=true;
			// se tem posição la e tem opononte retorna verdadeira
			}
	
		
		
			
	}
	else {
		p.setvalues(Position.getRow()+1, Position.getColumn());
		//esse -1 é a  posição a cima testando
		if(getBoard().positionExists(p)&& !getBoard().thereiseapiece(p)) {
	mat[p.getRow()][p.getColumn()]=true;
		//se a posição acima dele existir e tiver vasia ele pode mover pra la
		
	}
	
		p.setvalues(Position.getRow()+2, Position.getColumn());
		position p2= new position(Position.getRow()+1, Position.getColumn());
		//esse -1 é a  posição a cima testando
		if(getBoard().positionExists(p2)&& !getBoard().thereiseapiece(p2) && getmovecount()==0);{
	    mat[p.getRow()][p.getColumn()]=true;
		//se a posição acima dele existir e tiver vasia ele pode mover pra la
		
	}
		p.setvalues(Position.getRow()+1, Position.getColumn()-1);
		//esse -1 é a  posição a cima testando
		if(getBoard().positionExists(p)&& isthereoponentpiece(p)) {
	mat[p.getRow()][p.getColumn()]=true;
		// se tem posição la e tem opononte retorna verdadeira
		}
		p.setvalues(Position.getRow()+1, Position.getColumn()+1);
		//esse -1 é a  posição a cima testando
		if(getBoard().positionExists(p)&& isthereoponentpiece(p)) {
	mat[p.getRow()][p.getColumn()]=true;
		// se tem posição la e tem opononte retorna verdadeira
		}

		
	}
return mat;
	
	}
	@Override
	public String toString() {
		return "p";
		//tem que fazer string se nao aparece aquelas letras na tela
		
	}
}

