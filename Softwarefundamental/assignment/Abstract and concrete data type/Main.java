
public class Main {
	public static void main(String[] args){
		int[] c={1,2,1};
		int[] p={0,1,4};
		int[] c1={3,4,5};
		int[] p1={2,3,4};
		Poly poly1=new Poly(c,p);
		Poly poly2=new Poly(c1,p1);
		poly1.addPolynomial(poly1, poly2).displayPolynomial();
		poly1.multiplyPolynomial(poly1, poly2).displayPolynomial();

		
	}
}
