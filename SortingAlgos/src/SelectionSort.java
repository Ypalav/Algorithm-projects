public class SelectionSort {

	/*
	 * Time Complexity: O(n^2) as there are two nested loops. Auxiliary Space:
	 * O(1) The good thing about selection sort is it never makes more than O(n)
	 * swaps and can be useful when memory write is a costly operation.
	 */
	public void selectionSort(int[] inpArr) {
		for (int i = 0; i < inpArr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < inpArr.length; j++) {
				if (inpArr[minIndex] > inpArr[j])
					minIndex = j;
			}
			int temp = inpArr[i];
			inpArr[i] = inpArr[minIndex];
			inpArr[minIndex] = temp;
		}

		for (int i = 0; i < inpArr.length; i++) {
			System.out.println(inpArr[i]);
		}

	}

	public static void main(String args[]) {
		SelectionSort sort = new SelectionSort();
		int[] inpArr = { 64, 25, 12, 22, 11 };
		sort.selectionSort(inpArr);
	}

}
