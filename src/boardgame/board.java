package boardgame;

public class board {
	private int rows;
	private int columns;
	private piece[][] pieces;
	public board(int rows, int columns) {
		if(rows <1 ||columns <1) {
			throw  new  BoardException("erro boarning");
		}
		
		this.rows = rows;
		this.columns = columns;
		pieces=new piece[rows][columns];
	}
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}
	
	public piece Piece(int row,int column) {
		if(!positionExists(row,column)) {
			throw  new BoardException("position not on the board");
		}
		return pieces[row][column];
	}
	public piece Piece(position Position) {
		if(!positionExists(Position)) {
			throw  new BoardException("position not on the board");
		}
		return pieces[Position.getRow()][Position.getColumn()];	
		              }
	public void placepiece(piece Pie, position Posi) {
		if(thereiseapiece(Posi)) {
			throw new BoardException("there is already a piece on position"+Posi);
		}
		pieces [Posi.getRow()][Posi.getColumn()]=Pie;
		Pie.Position=Posi;
		
	}
	public piece removePiece(position Position) {
		if(! positionExists(Position)) {
			throw new BoardException("position not on the board");
			
		}
		if(Piece(Position)==null) {
			return null;
			
		}
		piece aux=Piece(Position);
		aux.Position= null;
		pieces[Position.getRow()][Position.getColumn()]=null;
		return aux;
	}
	
	
	private boolean  positionExists(int row,int column) {
		return row>=0 && row < rows && column>=0 && column<columns;
		
	}
	public  boolean positionExists(position Position) {
		return positionExists(Position.getRow(),Position.getColumn());	
		
	}
	public boolean thereiseapiece(position Position) {
		if(!positionExists(Position)) {
			throw  new BoardException("position not on the board");
		}
		return Piece(Position)!=null;
	}

}
