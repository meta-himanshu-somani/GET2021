
public class ArrOperation {
	private int count_X=0;
	private int count_Y=0;
	/**
	 * 
	 * @param array integer type
	 * @return maximum length of continues elements
	 *  of input array in mirror form 
	 */
	public int maxMirror(int[] array){
		int counter=0;
		int maxMirrorLength=0;
		for(int index=0;index<array.length;index++){
			counter=0;
			for(int index2=array.length-1;index+counter<array.length&&index2>-1;index2--){
				if(array[index+counter]==array[index2]){
					counter++;
				}else{
					if(counter>0){
						maxMirrorLength=counter>maxMirrorLength?counter:maxMirrorLength;
						counter=0;
					}
				}
			}
			maxMirrorLength=counter>maxMirrorLength?counter:maxMirrorLength;
		}
		return maxMirrorLength;
	}
	/**
	 * @param array integer type
	 * @return number of Clump in input array  of 2 or
	 *  more adjacent elements of the same value
	 */
	public int countClumps(int[] array){
		int noOfClumps=0;
		int index=0;
		while(index<array.length){
			int counter=1;
			for(int index2=index+1;index2<array.length;index2++){
				if(array[index]!=array[index2]){
					break;
				}else{
					counter++;
				}
			}
			if(counter<=1){index++;}		
			if(counter>=2){
				noOfClumps++;
				index+=counter;
			}
		}
		return noOfClumps;
	}
//helper method for fixXY
	private boolean countXY(int[] array,int X,int Y){
		int countX=0;
		int countY=0;
		for(int index=0;index<array.length;index++){
			if(array[index]==X){ countX++;}
			if(array[index]==Y){ countY++;}
		}
		this.count_X=countX;
		this.count_Y=countY;
		return countX!=countY?true:false;
	}
	private boolean isAdjcent(int[] array,int X){
		for(int index=0;index<array.length-1;index++){
			if(array[index]==X && array[index+1]==X){
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @param array integer type having length>0
	 * @param X fixed number to place Y just after
	 * @param Y number to be place just after X 
	 * @return same array placing Y just after X if X and Y have equal count else
	 * throw assertion error
	 */
	public int[] fixXY(int[] array,int X,int Y){
		int[] result= new int[array.length];
		if(array.length==0 || array[array.length-1]==X || countXY(array, X, Y) || isAdjcent(array, X)) return result;
		int[] index_Y=new int[this.count_Y];
		int[] index_X=new int[this.count_X];
		int i=0;
		int j=0;
		for(int index=0;index<array.length;index++){
			if(array[index]==X){
				index_X[i++]=index; //entering X available index in input array
			}else if (array[index]==Y){
				index_Y[j++]=index;// entering Y available index in input array
			}
		}
		for(int index=0;index<index_Y.length;index++){
			int temp=array[index_Y[index]];
			array[index_Y[index]]=array[index_X[index]+1];
			array[index_X[index]+1]=temp;
		}
		return array;
	}
//calculate sum of array for splitArray function
	private int sum(int[] array){
		int sum=0;
		for(int index=0;index<array.length;index++){
			sum+=array[index];
		}
		return sum;
	}
/**
 * 
 * @param array integer type having length>0
 * @return  the index if there is a place to split the 
 *  array so that the sum of the numbers on one side is 
 *  equal to the sum of the numbers on the other side
 *   else return -1
 */
	public int splitArray(int[] array){
		int totalSum=sum(array);
		if(totalSum%2!=0) return -1;
		int tempsum=0;
		for(int index=0;index<array.length;index++){
			tempsum+=array[index];
			if(tempsum==totalSum/2){
				return index+1;
			}
		}
		return -1;
	}
}
