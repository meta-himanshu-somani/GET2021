
public class Search {
	int linearIndex=0;
	/**
	 * 
	 * @param array integer array
	 * @param element to be search in array
	 * @return index of element if found in array else -1
	 */
	public int linearSearch(int[] array,int element){
		if(linearIndex==array.length){
			return -1;
		}else if (array[linearIndex]==element){
			return linearIndex;
		}else{
			linearIndex++;
			return linearSearch(array, element);
		}
	}
	/**
	 * 
	 * @param array integer array 
	 * @param left left index of array
	 * @param right right index of array
	 * @param element to be search in array
	 * @return element index if found in array else -1
	 */
	public int binarySearch(int[] array,int left,int right ,int element){
		if (right >= left){
	         int mid = left + (right - left) / 2;
	         if (array[mid] == element)
	         return mid;
	         if (array[mid] > element)
	         return binarySearch(array, left, mid - 1, element);
	         return binarySearch(array, mid + 1, right, element);
	      }
	      return -1;
	}
}
