public class Poly {
	// polynomial in form = {c0,c1*x^1...c(N-1)*x^(N-1)}
	// c->coefficient , x-> variable
	public final int[] polynomcoeff;
	public final int[] polynomVariable;
	public Poly(int[] coffecient,int[] varible_powers){
		if(coffecient.length!=varible_powers.length){
			
		}
		this.polynomcoeff=coffecient;
		this.polynomVariable=varible_powers;
	}
	/**
	 * 
	 * @return degree of polynomial
	 */
	public int degree(){
		int max=0;
		for(int deg:this.polynomVariable){
			if(max<deg){
				max=deg;
			}
		}
		return max;
	}
	/**
	 * 
	 * @param value float value to assign to variable 'x' in polynomial 
	 * @return float value sum of obtained answer in 
	 * c0*x^0+c1*x^1...c(N-1)*x^(N-1)
	 */
	public  float evalute(float value){
		float answer=0;
		for(int index=0;index<this.polynomVariable.length;++index){
			int power=this.polynomVariable[index];
			float sum=1;
			while(power>=1) {
				
				sum*=value;
				power--;
			}
			answer+=sum*this.polynomcoeff[index];
		}
		return answer;
	}
	/**
	 * 
	 * @param poly1 
	 * @param poly2
	 * @return addition of two polynomial return new polynomial object
	 */
	private int hasPower(int power){
		for(int i=0;i<this.polynomVariable.length;i++){
			if(power==this.polynomVariable[i]){
				return i;
			}
		}return -1;
	}
	private Poly addCompute(Poly poly1,Poly poly2){
		int[] tempPoly=new int[poly1.polynomcoeff.length+poly2.polynomcoeff.length];
		int tempindex=0;
		int[] tempPolyVarible=new int[poly1.polynomcoeff.length+poly2.polynomcoeff.length];
		int tempindexVari=0;
		for(int i=0;i<poly1.polynomcoeff.length;i++){
			int index=poly2.hasPower(poly1.polynomVariable[i]);
			if(index!=-1){
				tempPoly[tempindex++]=poly1.polynomcoeff[i]+poly2.polynomcoeff[index];
				tempPolyVarible[tempindexVari++]=poly1.polynomVariable[i];
			}else{
				tempPoly[tempindex++]=poly1.polynomcoeff[i];
				tempPolyVarible[tempindexVari++]=poly1.polynomVariable[i];
			}
		}
		for(int i=0;i<poly2.polynomVariable.length;i++){
			if(poly1.hasPower(poly2.polynomVariable[i])==-1){
				tempPoly[tempindex++]=poly2.polynomcoeff[i];
				tempPolyVarible[tempindexVari++]=poly2.polynomVariable[i];
			}
		}
		return new Poly(tempPoly,tempPolyVarible);
	} 
	private int maxDegree(Poly poly1,Poly poly2){
		int degree1=poly1.degree();
		int degree2=poly2.degree();
		return degree1>degree2? degree1:degree2;
	}
	public  Poly addPolynomial(Poly poly1,Poly poly2){
		if(poly1.polynomcoeff.length>=poly2.polynomcoeff.length){
			return addCompute(poly1, poly2);
		}else{
			return addCompute(poly2, poly1);
		}	
	}
	/**
	 * 
	 * @param poly1
	 * @param poly2
	 * @return multiply two polynomial return new polynomial object
	 */
	public Poly multiplyPolynomial(Poly poly1,Poly poly2){
		int[] tempPoly=new int[poly1.polynomcoeff.length*poly2.polynomcoeff.length];
		int tempindex=0;
		int[] tempPolyVarible=new int[poly1.polynomcoeff.length*poly2.polynomcoeff.length];
		int tempindexVari=0;

		for(int i=0;i<poly1.polynomcoeff.length;i++){
			for(int j=0;j<poly2.polynomcoeff.length;j++){
				System.out.println(i+" "+j);
				tempPolyVarible[tempindexVari++]=poly1.polynomVariable[i]+poly2.polynomVariable[j];
				tempPoly[tempindex++]=poly1.polynomcoeff[i]*poly2.polynomcoeff[j];
			}
		}
		for(int i=0;i<tempPolyVarible.length-1;i++){
			if(tempPoly[i]!=0){
				int sum=tempPoly[i];
				for(int j=i+1;j<tempPolyVarible.length;j++){
					if(tempPolyVarible[i]==tempPolyVarible[j] ){
						sum+=tempPoly[j];
						tempPoly[j]=0;
						tempPolyVarible[j]=0;
					}
				}
				tempPoly[i]=sum;
			}
		}
		
		return new Poly(tempPoly,tempPolyVarible);
	}
	
	public void displayPolynomial(){
		for(int i=0;i<this.polynomVariable.length;i++){
			if(this.polynomcoeff[i]==0) continue;
			System.out.println(this.polynomcoeff[i]+"x"+"^"+this.polynomVariable[i]);
		}
	}
}
