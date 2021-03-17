import static org.junit.Assert.*;

import org.junit.Test;


public class MathOperationTest {
	MathOperation mo =new MathOperation();
	@Test
	public void testLcmOfTwoNumbers() {
		assertEquals(180,mo.lcmOfTwoNumbers(60, 90) );
		assertEquals(300,mo.lcmOfTwoNumbers(60, 100) );
		assertEquals(1440,mo.lcmOfTwoNumbers(160, 90) );
		assertEquals(12540,mo.lcmOfTwoNumbers(660, 190) );
		assertEquals(28520,mo.lcmOfTwoNumbers(620, 920) );
	}
	@Test
	public void testHcfOfTwoNumbers(){
		assertEquals(30,mo.hcfOfTwoNumbers(60, 90) );
		assertEquals(20,mo.hcfOfTwoNumbers(60, 100) );
		assertEquals(10,mo.hcfOfTwoNumbers(160, 90) );
		assertEquals(10,mo.hcfOfTwoNumbers(660, 190) );
		assertEquals(20,mo.hcfOfTwoNumbers(620, 920) );
	}

}
