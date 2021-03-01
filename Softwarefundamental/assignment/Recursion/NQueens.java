
public class NQueens {
	int[][] queenplace;
	int[] board;
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
	
	public boolean calcQueens(int size){
		int[] board=new int[size];
		this.board=board;
		return queens(board,0,size);
	}
	
	public void display(){
		if(calcQueens(this.board.length)){
			int[][] queenPlace=new int[this.board.length][this.board.length];
			for(int i=0;i<queenPlace.length;i++){
				queenPlace[this.board[i]][i]=1;
			}
		}
	}
}
