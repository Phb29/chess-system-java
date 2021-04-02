package chess.pieces;

import boardgame.board;
import boardgame.position;
import chess.chesspiece;
import chess.color;

public class bishop extends chesspiece {

	public bishop(board board, color color) {
		super(board, color);
		
	}
	@Override 
	public String toString() {
		return 	"B";
		
	}
	
	
	@Override
	public boolean[][] possiblemoves() {
		boolean[][]mat =new boolean[getBoard().getRows()][getBoard().getColumns()];
		position p= new position(0, 0);
		
				p.setvalues(Position.getRow()-1, Position.getColumn()-1);
		while (getBoard().positionExists(p)&& !getBoard().thereiseapiece(p)) {
			//essa condição fala enquanto tiver vaga a posição é
			//verdadeira
			mat[p.getRow()][p.getColumn()]=true;
			p.setvalues(p.getRow()-1, p.getColumn()-1);
		}
		if(getBoard().positionExists(p)&& isthereoponentpiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			//essa opção quando tive peça  adversaria e ele captura
		}
		p.setvalues(Position.getRow()-1, Position.getColumn()+1);
		while (getBoard().positionExists(p)&& !getBoard().thereiseapiece(p)) {
			//essa condição fala enquanto tiver vaga a posição é
			//verdadeira
			mat[p.getRow()][p.getColumn()]=true;
			p.setvalues(p.getRow()-1, p.getColumn()+1);
		}
		if(getBoard().positionExists(p)&& isthereoponentpiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			//essa opção quando tive peça  adversaria e ele captura
		}
		p.setvalues(Position.getRow()+1, Position.getColumn()+1);
		while (getBoard().positionExists(p)&& !getBoard().thereiseapiece(p)) {
			//essa condição fala enquanto tiver vaga a posição é
			//verdadeira
			mat[p.getRow()][p.getColumn()]=true;
			p.setvalues(p.getRow()+1, p.getColumn()+1);
		}
		if(getBoard().positionExists(p)&& isthereoponentpiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			//essa opção quando tive peça  adversaria e ele captura
		}
		//below
		p.setvalues(Position.getRow()+1, Position.getColumn()-1);
		while (getBoard().positionExists(p)&& !getBoard().thereiseapiece(p)) {
			//essa condição fala enquanto tiver vaga a posição é
			//verdadeira
			mat[p.getRow()][p.getColumn()]=true;
			p.setvalues(p.getRow()+1, p.getColumn()-1);
		}
		if(getBoard().positionExists(p)&& isthereoponentpiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			//essa opção quando tive peça  adversaria e ele captura
		}
		
		return mat;
	}

}
