
public class CustomString {
	private String customstring;
	public CustomString(String str) {
		// TODO Auto-generated constructor stub
		this.customstring=str;
	}
	/**
	 * 
	 * @param string2 string to compare with
	 * @return 1 if strings are equal else 0
	 */
	public int compareString(CustomString string2){
		if(this.customstring==null || string2.customstring == null){
			return 0;
		}else if(this.customstring == string2.customstring){
			return 1;
		}
		return 0;
	}
	/**
	 * 
	 * @return reverse of passed string object and return new string object 
	 */
	public CustomString reverse(){
		char[] tempstring;
		tempstring=this.customstring.toCharArray();
		for (int index=0;index<this.customstring.length()/2+1;index++){
			char temp= tempstring[index];
			tempstring[index]=tempstring[this.customstring.length()-index-1];
			tempstring[this.customstring.length()-index-1]=temp;
		}
		return new CustomString(new String(tempstring));
	}
	/**
	 * 
	 * @param str string to convert lower char to upper
	 * @return upper case of letters as new string object
	 */
	public CustomString toUpper(String str){
		char[] tempstr=str.toCharArray();
		int a_ascii=97;
		int z_ascii=122;
		int A_ascii=65;
		for(int index=0;index<str.length();index++){
			if(a_ascii<=tempstr[index] && tempstr[index]<=z_ascii){
				tempstr[index]=(char) ((tempstr[index]-a_ascii)+A_ascii);
			}
		}
		return new CustomString(new String(tempstr));
	}
	/**
	 * 
	 * @param str string to convert upper to lower char
	 * @return return new string object of all lower case letter
	 */
	public CustomString toLower(String str){
		char[] tempstr=str.toCharArray();
		int A_ascii=65;
		int Z_ascii=90;
		int a_ascii=97;
		for(int index=0;index<str.length();index++){
			if(A_ascii<=tempstr[index] && tempstr[index]<=Z_ascii){
				tempstr[index]=(char) ((tempstr[index]-A_ascii)+a_ascii);
			}
		}
		return new CustomString(new String(tempstr));
	}
	/**
	 * 
	 * @param str find largest word of string
	 * @return largest word of string , if two word of equal length return last word 
	 */
	public String largestWord(String str){
		String[] wordlist=str.split(" ");
		String largestword="";
		for(String word: wordlist){
			if(largestword.length()<=word.length()){
				largestword=word;
			}
		}
		return largestword;
	}
	
	public String getString(){
		return this.customstring;
	}
}

