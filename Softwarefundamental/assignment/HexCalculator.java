public class HexCalculator {	
	private static int hexToDeci(String number){
		int decimal= Integer.parseInt(number,16);
		return decimal;
	}
	
	private static String deciTOHex(int number){
		String hexnumber=Integer.toHexString(number);
		return hexnumber;
	}
	
	public static String addTwoHexNumber(String number1,String number2){
		int decimal1=hexToDeci(number1);
		int decimal2=hexToDeci(number2);
		int sum=decimal1+decimal2;
		return deciTOHex(sum).toUpperCase();
	}
	
	public static String subtractTwoHexNumber(String number1,String number2){
		int decimal1=hexToDeci(number1);
		int decimal2=hexToDeci(number2);
		int sum=decimal1-decimal2;
		return deciTOHex(sum).toUpperCase();
	}
	
	public static String multiplyTwoHexNumber(String number1,String number2){
		int decimal1=hexToDeci(number1);
		int decimal2=hexToDeci(number2);
		int sum=decimal1*decimal2;
		return deciTOHex(sum).toUpperCase();
		
	}
	
	public static String divideTwoHexNumber(String number1,String number2){
		int decimal1=hexToDeci(number1);
		int decimal2=hexToDeci(number2);
		int sum=decimal1/decimal2;
		return deciTOHex(sum).toUpperCase();
		
		
	}
	public static void main(String[] args){
		System.out.println(addTwoHexNumber("A9A", "2A"));
		System.out.println(subtractTwoHexNumber("ABF", "1"));
		System.out.println(multiplyTwoHexNumber("A", "1"));
		System.out.println(divideTwoHexNumber("F", "5"));
	}
}
