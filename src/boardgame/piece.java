package boardgame;

public class piece {
	protected position Position;
	private board Board;
	public piece(board board) {
		
		Board = board;
		Position=null;
	}
	protected  board getBoard() {
		return Board;
	}
	
	
	
	

}
