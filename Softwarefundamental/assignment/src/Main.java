
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrOperation ar=new ArrOperation();
		int[] arr={1, 4, 1, 5, 5, 4, 1};
		int[] arr2={1, 4, 1, 5};
		int[] arr3={5, 4, 9, 4, 9, 5};
		int[] arr4={1, 2, 2, 3, 4, 4};
		System.out.println(ar.splitArray(arr));
		System.out.println(ar.splitArray(arr2));
		System.out.println(ar.splitArray(arr3));
		System.out.println(ar.splitArray(arr4));
		arr=ar.fixXY(arr, 4, 5);
		for(int index=0;index<arr.length;index++)
			System.out.print(" "+arr[index]);
	}

}
