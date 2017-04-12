public class CountingSort {
	public int[] countingSort(int inpArr[], int outArr[], int k) {
		int[] aux = new int[k+1];
		
		// store counts for each character
		for (int i = 0; i < inpArr.length; i++) {
			aux[inpArr[i]] += 1;
		}

		// for each i store counts of how many values are <=i
		for (int i = 1; i <= k; i++) {
			aux[i] = aux[i] + aux[i - 1];
		}

		// store actual locations
		for (int i = inpArr.length-1; i >= 0; i--) {
			outArr[aux[inpArr[i]]-1] = inpArr[i];
			aux[inpArr[i]] -= 1;
		}
		
		for (int i = 0; i < outArr.length; i++) {
			System.out.println(outArr[i]);
		}
		
		return outArr;
	}

	public static void main(String args[]) {
		CountingSort sort = new CountingSort();
		int inpArr[] = { 2, 5, 3, 0, 2, 3, 0, 3 };
		int[] outArr = new int[inpArr.length];
		int k = 5;
		outArr = sort.countingSort(inpArr, outArr, k);
		/*for (int i = 0; i < outArr.length; i++) {
			System.out.println(outArr[i]);
		}*/
	}

}
