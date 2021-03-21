import java.util.HashMap;
import java.util.Map;


public class MainString {
	static Map<String,Integer> cacheString =new HashMap<String,Integer>();
	/**
	 * 
	 * @param string to find number of unique character
	 * @return number of unique char if exists else 0
	 */
	public static int numberOfUniqueChar(String string){
		Map<Character,Integer> charCountList = new HashMap<Character,Integer>();
		if(cacheString.containsKey(string)){
			return cacheString.get(string);
		}else{
			 
			char[] charString=string.toCharArray();
			for (int i=0;i<charString.length;i++){
				if(!charCountList.containsKey(charString[i])){
					charCountList.put(charString[i], 1);
				}else{
					charCountList.put(charString[i],charCountList.get(charString[i])+1);
				}
			}
		}
		int uniqueCounter=0;
		for(Character ch: charCountList.keySet() ){
			if(charCountList.get(ch)<2){
				uniqueCounter++;
			}
		}
		cacheString.put(string, uniqueCounter);
		System.out.println(cacheString);
		return uniqueCounter;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MainString.numberOfUniqueChar("aabbc"));
		System.out.println(MainString.numberOfUniqueChar("aabbccadccea"));
		System.out.println(MainString.numberOfUniqueChar(""));
		

	}

}
