package boardgame;

public abstract class piece {
	protected position Position;
	private board Board;
	public piece(board board) {
		
		Board = board;
		Position=null;
	}
	protected  board getBoard() {
		return Board;
	}
	public abstract boolean[][]possiblemoves();
	
	public boolean possiblemove(position Position) {
		return possiblemoves()[Position.getRow()][Position.getColumn()];
		
	}
	public boolean ispossiblemove() {
		boolean[][] mat= possiblemoves();
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat.length; j++) {
				if(mat[i][j]) {
					return true; //esse comando pra ver se ela tem movimentp
							//possivel,j<mat pq presume q matriz quadrada
							
				}
				
			}
			
			
				
				
			
		}
		return false;
		
	}

}
