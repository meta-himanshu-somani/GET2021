import java.util.HashMap;
import java.util.Map;
public class MolecularWeight {
	static Map<Character,Integer> charCount =new HashMap<Character,Integer>();//total atoms present
	static Map<Character,Integer> innerCommonChar=new HashMap<Character,Integer>();//atoms present in "(xyz)n" (cho)2
	/**
	 * 
	 * @param molecul formula of compound with simplified numbers 
	 * @return molecular weight of compound if braces or number given correct else 0
	 */
	public static int calculateMolecularWeight(String molecul){
		char[] moleculCharArray=molecul.toUpperCase().toCharArray();// string to char array
		for(int i=0;i<moleculCharArray.length;i++){
			if( (65<=moleculCharArray[i]&& moleculCharArray[i]<=90)){//65-->A ascii , 90-->Z ascii
				if(charCount.containsKey(moleculCharArray[i])){
				charCount.put(moleculCharArray[i],charCount.get(moleculCharArray[i])+1);//
				}else{
					charCount.put(moleculCharArray[i], 1);
				}
			}else if((49<=moleculCharArray[i]&& moleculCharArray[i]<=57)){//49-->1 ascii , 57-->9 ascii
				if(charCount.get(moleculCharArray[i-1])==1){
				charCount.put(moleculCharArray[i-1],Character.getNumericValue(moleculCharArray[i]));
				}else if (charCount.get(moleculCharArray[i-1])>1){
					charCount.put(moleculCharArray[i-1],charCount.get(moleculCharArray[i-1])+Character.getNumericValue(moleculCharArray[i])-1);
				}
				
				// atoms present in braces with assuming number just after ')' and only 1 braces allowed
			}else if(moleculCharArray[i]=='('){
				
				innerCommonChar.put(moleculCharArray[i], 1);
				i++;
				while(i<moleculCharArray.length){
					if(moleculCharArray[i]=='('){
						innerCommonChar.put(moleculCharArray[i], innerCommonChar.get(moleculCharArray[i])+1);	
					}else if( (65<=moleculCharArray[i]&& moleculCharArray[i]<=90)){
						if(innerCommonChar.containsKey(moleculCharArray[i])){
							innerCommonChar.put(moleculCharArray[i],innerCommonChar.get(moleculCharArray[i])+1);
						}else{
							innerCommonChar.put(moleculCharArray[i], 1);
						}
					}else if((49<=moleculCharArray[i]&& moleculCharArray[i]<=57)){
						if(innerCommonChar.get(moleculCharArray[i-1])==1){
							innerCommonChar.put(moleculCharArray[i-1],Character.getNumericValue(moleculCharArray[i]));
						}else if (innerCommonChar.get(moleculCharArray[i-1])>1){
								innerCommonChar.put(moleculCharArray[i-1],innerCommonChar.get(moleculCharArray[i-1])+Character.getNumericValue(moleculCharArray[i])-1);
						}
					}else if(moleculCharArray[i]==')'){// poping out till '('=0 
						if(innerCommonChar.get('(')>=1){//
							innerCommonChar.put('(',innerCommonChar.get('(')-1);
							i++;
							if((49<=moleculCharArray[i]&& moleculCharArray[i]<=57)){
								for(Character ch : innerCommonChar.keySet()){
									innerCommonChar.put(ch, innerCommonChar.get(ch)*Character.getNumericValue(moleculCharArray[i]));
								}
							}
						}else{
							break;
						}
					}
					i++;
				}
				
			}
		}// merging both outer and inner atoms 
		for(Character ch : innerCommonChar.keySet()){
			if(charCount.containsKey(ch)){
				charCount.put(ch, innerCommonChar.get(ch)+charCount.get(ch));
			}else if(ch!='('){
				charCount.put(ch, innerCommonChar.get(ch));
			}
		}
		System.out.println(charCount);
		// calculating weight
		//12--> carbon atomic weight
		//1-->hydrogen atomic weight
		//16-->oxygen atomic weight
		int weight = 0;
		for(Character ch : charCount.keySet()){
			if('C'==ch){
				weight+=charCount.get(ch)*12;
			}else if('H'==ch){
				weight+=charCount.get(ch)*1;
			}else if('O'==ch){
				weight+=charCount.get(ch)*16;
			}
		}
		return weight;
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MolecularWeight.calculateMolecularWeight("ch(ch2o2)6o"));

	}

}
