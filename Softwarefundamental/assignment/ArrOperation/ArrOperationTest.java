import static org.junit.Assert.*;

import org.junit.Test;


public class ArrOperationTest {
	ArrOperation ar=new ArrOperation();
	int[] arr={1, 4, 1, 5, 5, 4, 1};
	int[] arr2={1, 4, 1, 5};
	int[] arr3={5, 4, 9, 4, 9, 5};
	int[] arr4={1, 2, 2, 3, 4, 4};
	@Test
	public void testCountClumps() {
		assertEquals(1, ar.countClumps(arr));
		assertEquals(0, ar.countClumps(arr2));
		assertEquals(0, ar.countClumps(arr3));
		assertEquals(2, ar.countClumps(arr4));
	}
	
	@Test
	public void testMaXMirror(){
		assertEquals(3, ar.maxMirror(arr));
		assertEquals(3, ar.maxMirror(arr2));
		assertEquals(3, ar.maxMirror(arr3));
		assertEquals(2, ar.maxMirror(arr4));
	}
	
	@Test
	public void testSplitArray(){
		assertEquals(-1, ar.splitArray(arr));
		assertEquals(-1, ar.splitArray(arr2));
		assertEquals(3, ar.splitArray(arr3));
		assertEquals(4, ar.splitArray(arr4));
	}
	
	@Test
	public void testFixXY(){
		int[] correct={1, 4, 5, 1, 1, 4, 5};
		int[] correct2={1,4,5,1};
		int[] correct3={9,4,5,4,5,9};
		int[] correct4=new int[6];
		assertArrayEquals(correct, ar.fixXY(arr, 4, 5));
		assertArrayEquals(correct2, ar.fixXY(arr2, 4, 5));
		assertArrayEquals(correct3, ar.fixXY(arr3, 4, 5));
		assertArrayEquals("assertion ",correct4, ar.fixXY(arr4, 2, 4));
	}

}
