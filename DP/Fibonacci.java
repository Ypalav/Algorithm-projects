package DP;

public class Fibonacci {
	public int computeFibWrapper(int n) {
		int[] auxArr = new int[n + 1];
		return computeFib(n, auxArr);
	}

	// memo
	private int computeFib(int n, int[] auxArr) {
		if (n == 0 || n == 1)
			return n;
		if (auxArr[n] == 0) {
			auxArr[n] = computeFib(n - 1, auxArr) + computeFib(n - 2, auxArr);
		}
		return auxArr[n];
	}

	// bottom-up
	public int computeFibBottomUp(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;

		int memo[] = new int[n];
		memo[0] = 0;
		memo[1] = 1;
		for (int i = 2; i < n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
		return memo[n - 1] + memo[n - 2];
	}

	// better bottom-up
	public int comFibBottomUp(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;

		int a = 0;
		int b = 1;
		for (int i = 2; i < n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return a + b;
	}
}
