package DP;

import static org.junit.Assert.*;

import org.junit.Test;

public class KnapsackTest {

	@Test
	public void test() {
		Knapsack sack = new Knapsack();
		int[] values = { 7, 2, 1, 6, 12 };
		int[] weights = { 3, 1, 2, 4, 6 };
		int capacity = 10;
		assertEquals(21, sack.knapsack(weights, values, capacity));
	}

}
