package DP;

public class Knapsack {
	public int knapsack(int[] weights, int[] values, int capacity) {
		int[][] memoTable = new int[weights.length + 1][capacity + 1];
		for (int i = 0; i <= weights.length; i++) {
			for (int j = 0; j <= capacity; j++) {
				if (i == 0 || j == 0)
					memoTable[i][j] = 0;
				else if (j < weights[i - 1])
					memoTable[i][j] = memoTable[i - 1][j];
				else
					memoTable[i][j] = Math.max(values[i - 1]
							+ memoTable[i - 1][j - weights[i - 1]],
							memoTable[i - 1][j]);
			}
		}
		return memoTable[weights.length][capacity];
	}
}
