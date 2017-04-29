package DP;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {
	@Test
	public void test() {
		Fibonacci fib = new Fibonacci();
		assertEquals(55, fib.computeFibWrapper(10));
		assertEquals(34, fib.computeFibBottomUp(9));
		assertEquals(34, fib.comFibBottomUp(9));
	}
}
