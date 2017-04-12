public class QuickSort {
	public void sort(int[] inpArr, int low, int high) {
		if (low < high) {
			int pivot = partition(inpArr, low, high);
			sort(inpArr, low, pivot - 1);
			sort(inpArr, pivot + 1, high);
		}
	}

	private int partition(int[] inpArr, int low, int high) {
		// TODO Auto-generated method stub
		int pivot = inpArr[high];
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			if (inpArr[j] <= pivot) {
				i++;
				int temp = inpArr[j];
				inpArr[j] = inpArr[i];
				inpArr[i] = temp;
			}
		}

		int temp = inpArr[i + 1];
		inpArr[i + 1] = inpArr[high];
		inpArr[high] = temp;
		return i + 1;
	}

	public static void main(String args[]) {
		QuickSort quickSort = new QuickSort();
		int[] inpArr = { 10, 7, 8, 9, 1, 5 };
		quickSort.sort(inpArr, 0, inpArr.length - 1);

		for (int i = 0; i < inpArr.length; i++) {
			System.out.println(inpArr[i]);
		}
	}

}
