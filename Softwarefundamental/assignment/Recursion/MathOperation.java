
public class MathOperation {
	int i=2;
	int j=2;
	/**
	 * 
	 * @param X integer number to find LCM with Y
	 * @param Y integer number to find LCM with X
	 * @return LCM of X and Y
	 */
	public int Lcm(int X,int Y){
		if(X==1 && Y==1) {
		return 1;	
		}else if (X%i==0 && Y%i==0){
			int temp=i;
			i=2;
			return temp*Lcm(X/temp,Y/temp);
		}else if(X%i==0){
			int temp=i;
			i=2;
			return temp*Lcm(X/temp,Y);
		}else if(Y%i==0){
			int temp=i;
			i=2;
			return temp*Lcm(X,Y/temp);
		}else{
			i++;
			return Lcm(X,Y);
		}
	}
	/**
	 * 
	 * @param X integer number to find HCF/GCD with Y
	 * @param Y integer number to find HCF/GCD with X
	 * @return HCF/GCD of X and Y
	 */
	public int Hcf(int X,int Y){
		if(X==0){
			 return Y;
		}
		return Hcf(Y%X,X);
	}
}
