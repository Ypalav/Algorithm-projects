public class MergeSort {
	public void sort(int[] inpArr, int left, int right) {
		if (left < right) {
			int mid = (right + left) / 2;
			sort(inpArr, left, mid);
			sort(inpArr, mid + 1, right);

			merge(inpArr, left, mid, right);
		}

	}

	/*
	 * Time Complexity: Sorting arrays on different machines. Merge Sort is a
	 * recursive algorithm and time complexity can be expressed as following
	 * recurrence relation. T(n) = 2T(n/2) + \Theta(n) The above recurrence can
	 * be solved either using Recurrence Tree method or Master method. It falls
	 * in case II of Master Method and solution of the recurrence is
	 * \Theta(nLogn). Time complexity of Merge Sort is \Theta(nLogn) in all 3
	 * cases (worst, average and best) as merge sort always divides the array in
	 * two halves and take linear time to merge two halves. Auxiliary Space:
	 * O(n) Algorithmic Paradigm: Divide and Conquer Sorting In Place: No in a
	 * typical implementation Stable: Yes
	 */
	private void merge(int[] inpArr, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] temp1 = new int[n1];
		int[] temp2 = new int[n2];

		for (int i = 0; i < temp1.length; ++i) {
			temp1[i] = inpArr[left + i];
		}

		for (int i = 0; i < temp2.length; ++i) {
			temp2[i] = inpArr[mid + 1 + i];
		}
		int i = 0, j = 0, k = left;

		while (i < n1 && j < n2) {
			if (temp1[i] >= temp2[j]) {
				inpArr[k] = temp2[j++];
			} else {
				inpArr[k] = temp1[i++];
			}
			k++;
		}

		while (i < n1) {
			inpArr[k] = temp1[i++];
			k++;
		}
		while (j < n2) {
			inpArr[k] = temp2[j++];
			k++;
		}

	}

	public static void main(String args[]) {
		MergeSort sort = new MergeSort();
		int[] inpArr = { 64, 25, 12, 72, 11 };
		sort.sort(inpArr, 0, inpArr.length - 1);

		for (int i = 0; i < inpArr.length; i++) {
			System.out.println(inpArr[i]);
		}
	}

}
