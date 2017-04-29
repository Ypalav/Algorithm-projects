package DP;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonSubsequenceTest {

	@Test
	public void test() {
		LongestCommonSubsequence seq = new LongestCommonSubsequence();
		char[] x = "AGGTAB".toCharArray();
		char[] y = "GXTXAYB".toCharArray();
		assertEquals(4, seq.getLongestSeq(x, y));
	}
}
