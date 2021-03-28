package chess;

import boardgame.position;

public class ChessPosition {
	private char column;
	private int row;
	public ChessPosition(char column, int row) {
		if(column<'a'|| column>'h' ||row<1 ||row>8) {
			throw new chessexception("error instantiating.valid  a1 to h8");
		}
		this.column = column;
		this.row = row;
	}
	public char getColumn() {
		return column;
	}
	
	public int getRow() {
		return row;
	}
	protected position toposition() {
		return new position(8-row,column -'a');
	}
	protected static ChessPosition fromposition(position Position) {
		return new ChessPosition((char)('a'- Position.getColumn()),8 - Position.getRow());
	}
	@Override
	public String toString() {
		return "" +column +row;
		
	}
	
	

}
