package chess.pieces;

import boardgame.board;
import boardgame.position;
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
	
	
	@Override
	public boolean[][] possiblemoves() {
		boolean[][]mat =new boolean[getBoard().getRows()][getBoard().getColumns()];
		position p= new position(0, 0);
				p.setvalues(Position.getRow()-1, Position.getColumn());
		while (getBoard().positionExists(p)&& !getBoard().thereiseapiece(p)) {
			//essa condi��o fala enquanto tiver vaga a posi��o �
			//verdadeira
			mat[p.getRow()][p.getColumn()]=true;
			p.setRow(p.getRow()-1);
		}
		if(getBoard().positionExists(p)&& isthereoponentpiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			//essa op��o quando tive pe�a  adversaria e ele captura
		}
		p.setvalues(Position.getRow(), Position.getColumn()-1);
		while (getBoard().positionExists(p)&& !getBoard().thereiseapiece(p)) {
			//essa condi��o fala enquanto tiver vaga a posi��o �
			//verdadeira
			mat[p.getRow()][p.getColumn()]=true;
			p.setColumn(p.getColumn()-1);
		}
		if(getBoard().positionExists(p)&& isthereoponentpiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			//essa op��o quando tive pe�a  adversaria e ele captura
		}
		p.setvalues(Position.getRow(), Position.getColumn()+1);
		while (getBoard().positionExists(p)&& !getBoard().thereiseapiece(p)) {
			//essa condi��o fala enquanto tiver vaga a posi��o �
			//verdadeira
			mat[p.getRow()][p.getColumn()]=true;
			p.setColumn(p.getColumn()+1);
		}
		if(getBoard().positionExists(p)&& isthereoponentpiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			//essa op��o quando tive pe�a  adversaria e ele captura
		}
		//below
		p.setvalues(Position.getRow()+1, Position.getColumn());
		while (getBoard().positionExists(p)&& !getBoard().thereiseapiece(p)) {
			//essa condi��o fala enquanto tiver vaga a posi��o �
			//verdadeira
			mat[p.getRow()][p.getColumn()]=true;
			p.setRow(p.getRow()+1);
		}
		if(getBoard().positionExists(p)&& isthereoponentpiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			//essa op��o quando tive pe�a  adversaria e ele captura
		}
		
		return mat;
	}

}
