package boardgame;

public class position {
	private int row;
	private int column;
	public position(int row, int column) {
	
		this.row = row;
		this.column = column;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public void setvalues(int row,int column) {
		this.row=row;
		this.column=column;
		//fez pra receber valores de atualiza��o da pe�a
	}
	@Override 
	public String toString(){
	return row + "," +column;
	}

}
