
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrice={{1,0,1},{0,0,0},{0,0,1}};
		int[][] matrice2={{0,0,0},{0,0,0},{0,0,1}};
		SparseMartrices sp= new SparseMartrices(matrice, 3, 3);
		SparseMartrices sp2= new SparseMartrices(matrice2, 3, 3);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(" | "+matrice[i][j]+" | ");
			}
			System.out.println();
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(" | "+matrice2[i][j]+" | ");
			}
			System.out.println();
		}
		int[][] result=sp.addMatrice(sp2);
		System.out.println("After Addition");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(" | "+result[i][j]+" | ");
			}
			System.out.println();
		}
		System.out.println("is symmetric : "+sp.isSymmetric());
	}

}
