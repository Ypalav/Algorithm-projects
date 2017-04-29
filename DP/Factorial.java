package DP;

public class Factorial {
	// memo
	public int factorial(int n) {
		int auxArr[] = new int[n + 1];
		auxArr[0] = 1;
		return factCompute(n, auxArr);
	}

	private int factCompute(int n, int[] auxArr) {
		// TODO Auto-generated method stub
		if (n == 0 || n == 1)
			return 1;
		if (auxArr[n] == 0) {
			auxArr[n] = n * factCompute(n - 1, auxArr);
			return auxArr[n];
		}
		return auxArr[n];
	}

	// bottom up
	public int factComp(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		int arr[] = new int[n];
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = i * arr[i - 1];
		}
		return n * arr[arr.length - 1];
	}

	// revised bottom-up
	public int factCompRev(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		int a = 1;
		for (int i = 2; i < n; i++) {
			int c = a * i;
			a = c;
		}
		return a * n;
	}

}
