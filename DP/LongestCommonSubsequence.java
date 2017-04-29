package DP;

public class LongestCommonSubsequence {
	public int getLongestSeq(char[] x, char[] y) {
		int[][] lcs = new int[x.length + 1][y.length + 1];
		for (int i = 0; i <= x.length; i++) {
			for (int j = 0; j <= y.length; j++) {
				if (i == 0 || j == 0)
					lcs[i][j] = 0;
				else if (x[i - 1] == y[j - 1]) {
					lcs[i][j] = 1 + lcs[i - 1][j - 1];
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}
		printLCS(x, y, lcs);
		return lcs[x.length][y.length];
	}

	private void printLCS(char[] x, char[] y, int[][] lcs) {
		// TODO Auto-generated method stub
		int index = lcs[x.length][y.length];
		char[] lcsChars = new char[index + 1];
		lcsChars[index] = '\0';
		int i = x.length;
		int j = y.length;
		while (i > 0 && j > 0) {
			if (x[i - 1] == y[j - 1]) {
				lcsChars[index - 1] = x[i - 1];
				index--;
				i--;
				j--;
			} else if (x[i - 1] > y[j - 1])
				i--;
			else
				j--;
		}
		for (int k = 0; k < lcsChars.length; k++) {
			System.out.println(lcsChars[k]);
		}

	}
}
