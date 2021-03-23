package boardgame;

public class board {
	private int rows;
	private int columns;
	private piece[][] Piece;
	public board(int rows, int columns) {
		
		this.rows = rows;
		this.columns = columns;
		Piece=new piece[rows][columns];
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	public piece Piece(int row,int column) {
		return Piece[row][column];
	}
	public piece Piece(position Position) {
		return Piece[Position.getRow()][Position.getColumn()];	
		              }

}
