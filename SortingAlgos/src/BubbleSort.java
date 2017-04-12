public class BubbleSort {

	/*
	 * Worst and Average Case Time Complexity: O(n*n). Worst case occurs when
	 * array is reverse sorted. Best Case Time Complexity: O(n). Best case
	 * occurs when array is already sorted. Auxiliary Space: O(1) Boundary
	 * Cases: Bubble sort takes minimum time (Order of n) when elements are
	 * already sorted. Sorting In Place: Yes Stable: Yes
	 */
	public void bubbleSort(int[] inpArr) {
		int flag = 0;
		for (int i = 0; i < inpArr.length - 1; i++) {
			flag = 0;
			for (int j = 0; j < inpArr.length - i - 1; j++) {
				if (inpArr[j] > inpArr[j + 1]) {
					flag = 1;
					int temp = inpArr[j];
					inpArr[j] = inpArr[j + 1];
					inpArr[j + 1] = temp;
				}
			}
			if (flag == 0)
				break;
		}

		for (int i = 0; i < inpArr.length; i++) {
			System.out.println(inpArr[i]);
		}
	}

	public static void main(String args[]) {
		BubbleSort sort = new BubbleSort();
		int[] inpArr = { 64, 25, 12, 22, 11 };
		sort.bubbleSort(inpArr);
	}

}
