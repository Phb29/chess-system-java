package chess.pieces;

import boardgame.board;
import boardgame.position;
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
	private boolean canmove(position Position) {
		chesspiece p=(chesspiece)getBoard().Piece(Position);
		// permissao para rei mover
		return p ==null || p.getColor() !=getColor();
		// null q ele permissao quando n tem e getcolor difernete cor
		
		
	}
	@Override
	public boolean[][] possiblemoves() {
		boolean[][]mat =new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		position p=new position(0,0);
		
		//abova/acima
		
		p.setvalues(Position.getRow()-1, Position.getColumn());
		if(getBoard().positionExists(p) &&  canmove(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		//below,abaixo
		p.setvalues(Position.getRow()+1, Position.getColumn());
		if(getBoard().positionExists(p) &&  canmove(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		//left
		p.setvalues(Position.getRow(), Position.getColumn()-1);
		if(getBoard().positionExists(p) &&  canmove(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		//rigth
		p.setvalues(Position.getRow(), Position.getColumn()+1);
		if(getBoard().positionExists(p) &&  canmove(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		//nw
		p.setvalues(Position.getRow()-1, Position.getColumn()-1);
		if(getBoard().positionExists(p) &&  canmove(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		//ne
		p.setvalues(Position.getRow()-1, Position.getColumn()+1);
		if(getBoard().positionExists(p) &&  canmove(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		//sw
		p.setvalues(Position.getRow()+1, Position.getColumn()-1);
		if(getBoard().positionExists(p) &&  canmove(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		//se
		p.setvalues(Position.getRow()+1, Position.getColumn()+1);
		if(getBoard().positionExists(p) &&  canmove(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		
		
		
		
		
		
		return mat;
		
		
	}

}
