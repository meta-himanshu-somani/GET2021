
public class NQueens {
	int[][] queenplace;
	int[] board;
	/**
	*
	*@param board 2D array where queen is to be place
	*@param current position of queen in board
	*@return true if queen's position does not affect other queen else false
	*/
	private boolean noConflict(int[] board,int current){
		this.board=board;
		for(int index=0;index<current;index++){
			if(this.board[index]==this.board[current]){
				return false;
			}
			if(current-index==(this.board[current]=this.board[index])){
				return false;
			}
		}
		return true;
	}
	/**
	*
	*@param board 2D array where queen is to be place
	*@param current position of queen in board
	*@param size of board 
	*@return true if no conflicts occurs for current position of queen else false
	*/
	private boolean queens(int[] board,int current,int size){
		this.board=board;
		if(current==size){
			return true;
		}else{
			for(int index=0;index<size;index++){
				this.board[current]=index;
				if(noConflict(this.board,current)){
					boolean done=queens(this.board,current+1,size);
					if(done){
						return true;
					}
				}
			}
			return false;
		}
	}
	/**
	*@param size it is size of board an number of queen to place in board
	*@return true of queens can be insert in board else false
	*/
	public boolean calcQueens(int size){
		int[] board=new int[size];
		this.board=board;
		return queens(board,0,size);
	}
	// Display the coulmn index where queen is placed
	public void display(){
		if(calcQueens(this.board.length)){
			int[][] queenPlace=new int[this.board.length][this.board.length];
			for(int i=0;i<queenPlace.length;i++){
				queenPlace[this.board[i]][i]=1;
			}
		}
	}
}
