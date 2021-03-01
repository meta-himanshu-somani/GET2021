import static org.junit.Assert.*;

import org.junit.Test;


public class SearchTest {
	Search s= new Search();
	int[] array={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	int[] elements={1,2,3,4,5,6,7,8,9,11,21,22,23,24};
	int[] expected={0,1,2,3,4,5,6,7,8,10,-1,-1,-1,-1};
	@Test
	public void testLinearSearch() {
		for(int index=0;index<elements.length;index++){
			assertEquals(expected[index], s.linearSearch(array, elements[index]));
		}
	}
	@Test
	public void testBinarySearch(){
		for(int index=0;index<elements.length;index++){
			assertEquals("element error at"+index+1,expected[index], s.binarySearch(array, 0,array.length-1,elements[index]));
		}
	}

}
