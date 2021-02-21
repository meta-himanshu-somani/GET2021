
public class Poly {
	// polynomial in form = {c0...c(N-1)} 
	public  int[] polynom={0};
	public  Poly(int[] coffecient){
		polynom=coffecient;
	}
	/**
	 * 
	 * @return degree of polynomial
	 */
	public int degree(){
		return this.polynom.length-1;
	}
	/**
	 * 
	 * @param value float value to assign to variable 'x' in polynomial 
	 * @return float value sum of obtained answer in 
	 * c0*x^0+c1*x^1...c(N-1)*x^(N-1)
	 */
	public  float evalute(float value){
		float answer=0;
		for(int index=1;index<this.polynom.length;++index){
			int power=index;
			float sum=0;
			while(power>=1) {
				
				sum*=value;
				power--;
			}
			answer+=sum*this.polynom[index];
		}
		return answer;
	}
	/**
	 * 
	 * @param poly1 
	 * @param poly2
	 * @return addition of two polynomial return new polynomial object
	 */
	public  Poly addPolynomial(Poly poly1,Poly poly2){
		if(poly1.polynom.length< poly2.polynom.length){
			
			int[] temp=poly1.polynom;
			poly1.polynom=poly2.polynom;
			poly2.polynom=temp;
		}
			int[] newPoly=new int[poly1.polynom.length];
			System.out.println(poly1.polynom.length);
			for(int index=0;index<poly2.polynom.length;++index){
				newPoly[index]=poly1.polynom[index]+poly2.polynom[index];
			}
			int index=poly2.polynom.length;
			while(index<poly1.polynom.length){
				newPoly[index]=poly1.polynom[index];
				index++;
			}
		return new Poly(newPoly);
		
	}
	/**
	 * 
	 * @param poly1
	 * @param poly2
	 * @return multiply two polynomial return new polynomial object
	 */
	public Poly multiplyPolynomial(Poly poly1,Poly poly2){
		if(poly1.polynom.length< poly2.polynom.length){
			
			int[] temp=poly1.polynom;
			poly1.polynom=poly2.polynom;
			poly2.polynom=temp;
		}
		int sum=0;
		int[] newPoly=new int[poly1.polynom.length];
		for(int index=0;index<poly2.polynom.length;++index){
			for(int index2=0;index<poly1.polynom.length;++index2){
				sum=poly1.polynom[index]*poly2.polynom[index2];
				newPoly[index2]+=sum;
			}
		}
		return new Poly(newPoly);
	}
}
