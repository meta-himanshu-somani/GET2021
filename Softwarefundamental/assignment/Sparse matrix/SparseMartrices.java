

/*a) It should support following methods 
-return transpose of the matrix
-check whether it is a symmetrical matrix
-add two matrices
-multiply two matrices

b) What is the time complexity of each of the methods?
*/

public class SparseMartrices {
	int MAX=100;
	private int length;
	private int row,col;
	public final int[][] sparse_matrice= new int[MAX][3];
	private int sparce_row=0;
	public SparseMartrices(int[][] matrice, int row,int col){
		this.row=row;
		this.col=col;
		this.length=0;
		int k=0;
		if ( row!=col)assert row==col:"row and column must be equal";
		for(int i=0;i<this.row;i++){
			for(int j=0;j<this.col;j++){
				if(matrice[i][j]!=0){
					//row index [][0]
					//col index[][1]
					//value index[][2]
					this.sparce_row++;
					sparse_matrice[k][0]=i;
					sparse_matrice[k][1]=j;
					sparse_matrice[k][2]=matrice[i][j];
					System.out.println(sparse_matrice[k][0]+" "+sparse_matrice[k][1]+" "+sparse_matrice[k][2]);
					this.length++;
					k++;
				}
			}
		}
	}
	private int[][] convertToMatrice(int[][] matrice,int i){
		int[][] result=new int[this.row][this.col];
		for(int row=0;row<i;row++){
			System.out.println(matrice[row][2]);
				result[matrice[row][0]][matrice[row][1]]=matrice[row][2];
		}
		return result;
	}
	/**
	 * 
	 * @return convert matrix rows to column and vise versa
	 * 
	 */
	public int[][] transposeMatrice(){
		int[][] result=new int[this.sparce_row][3];
		assert this.row==this.col:"row and column must be equal";
		for(int i=0;i<this.sparce_row;i++){
			result[i][0]=this.sparse_matrice[i][1];
			result[i][1]=this.sparse_matrice[i][0];
			result[i][2]=this.sparse_matrice[i][2];
		}
		return convertToMatrice(result,result.length);
}
	/**
	 * 
	 * @return false if object sparse matrix is not symmetric i.e a[i][j]!=a[j][i]
	 * else return true 
	 */
	public boolean isSymmetric(){
	int flag=0;
		for(int i=0;i<this.length;i++){
		for(int j=0;j<this.length;j++){
			if(this.sparse_matrice[i][0]==this.sparse_matrice[j][1]
					&& this.sparse_matrice[i][1]==this.sparse_matrice[j][0]){
				flag++;
			}
		}
	}
	if(flag==this.length)
		return true;
	return false;
	}
	/**
	 * 
	 * @param matrice object to add with caller object
	 * @return add two sparse matrix and return integer array having 0 elements in it
	 */
	public int[][] addMatrice(SparseMartrices matrice){
		assert this.row==this.col:"row and col must be equal";
		assert matrice.row==matrice.col:"row and col must be equal";
		int[][] result=new int[this.sparce_row+matrice.sparce_row][3];
		int j=0;
		System.out.println("sparce row :"+this.sparce_row+" matrice row "+matrice.sparce_row);
		if(this.sparce_row<=matrice.sparce_row){
			int k=0;
			for(int i=0;i<matrice.sparce_row;i++){
			// element present at same index m[i][j]==m2[i][j]
			if(this.sparse_matrice[k][0]==matrice.sparse_matrice[i][0] && this.sparse_matrice[k][1]==matrice.sparse_matrice[i][1]){
				result[j][0]=this.sparse_matrice[k][0];
				result[j][1]=this.sparse_matrice[k][1];
				result[j][2]=this.sparse_matrice[k][2]+matrice.sparse_matrice[i][2];
				System.out.println(i+"i "+result[j][0]+" "+result[j][1]+" "+result[j][2]);
				j++;k++;
			}else{
				//element at different index
				if(k<this.sparce_row-1){
				result[j][0]=this.sparse_matrice[k][0];
				result[j][1]=this.sparse_matrice[k][1];
				result[j][2]=this.sparse_matrice[k][2];
				System.out.println(k+"k "+result[j][0]+" "+result[j][1]+" "+result[j][2]);
				j++;
				k++;
				}
				result[j][0]=matrice.sparse_matrice[i][0];
				result[j][1]=matrice.sparse_matrice[i][1];
				result[j][2]=matrice.sparse_matrice[i][2];
				System.out.println(i+"i "+result[j][0]+" "+result[j][1]+" "+result[j][2]);
				j++;
				}
			}
		}else if(this.sparce_row>matrice.sparce_row){//matrice1 length of element>matrice2 length of element
			int k=0;
			for(int i=0;i<this.sparce_row;i++){
				// element present at same index m[i][j]==m2[i][j]
				if(this.sparse_matrice[i][0]==matrice.sparse_matrice[k][0] && this.sparse_matrice[i][1]==matrice.sparse_matrice[k][1]){
					result[j][0]=this.sparse_matrice[i][0];
					result[j][1]=this.sparse_matrice[i][1];
					result[j][2]=this.sparse_matrice[i][2]+matrice.sparse_matrice[k][2];
					System.out.println(i+" "+result[j][0]+" "+result[j][1]+" "+result[j][2]);
					j++;k++;
				}else{
					//element at different index
					result[j][0]=this.sparse_matrice[i][0];
					result[j][1]=this.sparse_matrice[i][1];
					result[j][2]=this.sparse_matrice[i][2];
					System.out.println(i+" "+result[j][0]+" "+result[j][1]+" "+result[j][2]);
					j++;
					if(k<matrice.sparce_row-1){
					result[j][0]=matrice.sparse_matrice[k][0];
					result[j][1]=matrice.sparse_matrice[k][1];
					result[j][2]=matrice.sparse_matrice[k][2];
					System.out.println(i+" "+result[j][0]+" "+result[j][1]+" "+result[j][2]);
					j++;k++;}
					}
			}
		}
		return convertToMatrice(result,j);
	}
/**
 * 
 * @param matrice object of SparceMatrices class
 * @return multiply two sparse matrix and return in integer array form consisting 0 elements also
 */
	public int[][] multiplyMatrice(SparseMartrices matrice){
		if(this.col!=matrice.row){
			return new int[0][0];
		}
		int[][] mat=matrice.transposeMatrice();
		int this_pos,mat_pos;
		int[][] result=new int[this.row][this.col];
		for(this_pos=0;this_pos<this.length;){
			int r=this.sparse_matrice[this_pos][0];
			for(mat_pos=0;mat_pos<mat.length;){
				int c = mat[mat_pos][0];
				int temp_this=this_pos;
				int temp_mat=mat_pos;
				int sum=0;
				while(temp_this<this.length && this.sparse_matrice[temp_this][0]==r
						&& temp_mat < mat.length && mat[temp_mat][0]==c){
					if(this.sparse_matrice[temp_this][1]< mat[temp_mat][1]){
					temp_this++;
					}else if(this.sparse_matrice[temp_this][1]> mat[temp_mat][1]){
						temp_mat++;
					}else{
						sum+=this.sparse_matrice[temp_this++][2]*mat[temp_mat++][2];
					}
				}
				if(sum!=0){
					result[r][0]=r;
					result[r][1]=c;
					result[r][2]=sum;
				}
				while(mat_pos<mat.length && mat[mat_pos][0]==c){
					mat_pos++;
				}
			}
			while(this_pos<this.length && this.sparse_matrice[this_pos][0]==r){
				this_pos++;
			}
		}
		return convertToMatrice(result, result.length);
	}
	
}
