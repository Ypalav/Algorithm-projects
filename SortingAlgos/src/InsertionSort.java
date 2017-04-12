public class InsertionSort {
	/*
	 * Time Complexity: O(n*n) Auxiliary Space: O(1) Boundary Cases: Insertion
	 * sort takes maximum time to sort if elements are sorted in reverse order.
	 * And it takes minimum time (Order of n) when elements are already sorted.
	 * Algorithmic Paradigm: Incremental Approach Sorting In Place: Yes Stable:
	 * Yes Online: Yes Uses: Insertion sort is used when number of elements is
	 * small. It can also be useful when input array is almost sorted, only few
	 * elements are misplaced in complete big array.
	 */
	public void insertionSort(int[] inpArr) {
		for(int i=0;i<inpArr.length;i++){
			int key = inpArr[i];
			int j=i-1;
			while(j>=0 && inpArr[j]>key){
				inpArr[j+1]=inpArr[j];
				j=j-1;
			}
			inpArr[j+1]=key;
		}
		
		for(int i=0;i<inpArr.length;i++){
			System.out.println(inpArr[i]);
		}
	}

	public static void main(String args[]) {
		InsertionSort sort = new InsertionSort();
		int[] inpArr = { 64, 25, 12, 72, 11 };
		sort.insertionSort(inpArr);
	}

}
