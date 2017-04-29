package DP;

import static org.junit.Assert.*;
import org.junit.Test;

public class FactorialTest {
	@Test
	public void test() {
		Factorial fac = new Factorial();
		assertEquals(120, fac.factorial(5));
		assertEquals(120, fac.factComp(5));
		assertEquals(24, fac.factCompRev(4));
	}
}
