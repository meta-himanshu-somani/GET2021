import static org.junit.Assert.*;

import org.junit.Test;


public class MathOperationTest {
	MathOperation mo =new MathOperation();
	@Test
	public void testLcm() {
		assertEquals(180,mo.Lcm(60, 90) );
		assertEquals(300,mo.Lcm(60, 100) );
		assertEquals(1440,mo.Lcm(160, 90) );
		assertEquals(12540,mo.Lcm(660, 190) );
		assertEquals(28520,mo.Lcm(620, 920) );
	}
	@Test
	public void testHcf(){
		assertEquals(30,mo.Hcf(60, 90) );
		assertEquals(20,mo.Hcf(60, 100) );
		assertEquals(10,mo.Hcf(160, 90) );
		assertEquals(10,mo.Hcf(660, 190) );
		assertEquals(20,mo.Hcf(620, 920) );
	}

}
