public class IntSet {
	private int[] universalSet=new int[1000];
	public  int[] setOfNumber={0};
	public IntSet(int[] newset){
		this.setOfNumber=newset;
		for(int index=0;index<1000;++index){
			this.universalSet[index]=index+1;
		}
	}
	// return the size of set
	public  int size(){
		return this.setOfNumber.length;
	}
	/**
	 * @param number to check number is present or not in given set
	 * @return true if number is member else false
	 */
	public  boolean isMember(int number){
		for(int index=0;index<size();++index){
			if(this.setOfNumber[index]==number) return true;
		}
		return false;
	}
	/**
	 * 
	 * @param subset IntSet object to check subset of other IntSet object
	 * @return true if subset of given object else false 
	 */
	public  boolean isSubset(IntSet mainset){
		int counter=0;
		for(int index=0;index<this.setOfNumber.length;++index ){
			if(mainset.isMember(this.setOfNumber[index])){
				counter++;
			}
		}
		if(counter==this.setOfNumber.length) return true;
		return false;
	}
	/**
	 * 
	 * @return new IntSet object complemented of old object
	 */
	public IntSet getComplement(){
		for(int index=0;index<setOfNumber.length;++index){
			universalSet[setOfNumber[index]-1]=0;
		}
		int newsize=universalSet.length-this.setOfNumber.length;
		int[] complementArry=new int[newsize];
		int setIndex=0;
		for(int index=0;index<universalSet.length;++index){
			if(universalSet[index]!=0){
				complementArry[setIndex]=universalSet[index];
				setIndex++;
			}
		}
		return new IntSet(complementArry);
	}

	public static void main(String[] args) {
		int[] arry1={1,2,3,4,5,6,7,8,9,10};
		IntSet set1= new IntSet(arry1);			
		System.out.println("size: "+set1.size());
		System.out.println("12 is Member "+set1.isMember(12));
		System.out.println("5 is Member "+set1.isMember(5));
		System.out.println("After complement size : "+set1.getComplement().size());
		System.out.println("After complement 23 is Member :"+set1.getComplement().isMember(23));			
		int[] arry2={1,4,9,11};
		IntSet set2=new IntSet(arry2);
		System.out.println("set2 is subset of set1 : "+set2.isSubset(set1));
	}

}
