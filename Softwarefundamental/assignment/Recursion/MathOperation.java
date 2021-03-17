
public class MathOperation {
	int i=2;
	int j=2;
	/**
	 * 
	 * @param X integer number to find LCM with number2
	 * @param Y integer number to find LCM with number1
	 * @return LCM of number1 and number2
	 */
	public int lcmOfTwoNumbers(int number1,int number2){
		if(number1==1 && number2==1) {
		return 1;	
		}else if (number1%i==0 && number2%i==0){
			int temp=i;
			i=2;
			return temp*lcmOfTwoNumbers(number1/temp,number2/temp);
		}else if(number1%i==0){
			int temp=i;
			i=2;
			return temp*lcmOfTwoNumbers(number1/temp,number2);
		}else if(Y%i==0){
			int temp=i;
			i=2;
			return temp*lcmOfTwoNumbers(number1,number2/temp);
		}else{
			i++;
			return lcmOfTwoNumbers(number1,number2);
		}
	}
	/**
	 * 
	 * @param X integer number to find HCF/GCD with number2
	 * @param Y integer number to find HCF/GCD with number1
	 * @return HCF/GCD of number1 and number2
	 */
	public int Hcf(int number1,int number2){
		if(number1==0){
			 return number2;
		}
		return Hcf(number2%number1,number1);
	}
}
