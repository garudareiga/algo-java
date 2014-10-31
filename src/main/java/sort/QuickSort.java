package sort;

public class QuickSort {
	public void sort(int[] A) {
		/*
		 * Quick Sorting Algorithm
		 */
		if (A.length <= 1) return;
		quick_sort(A, 0, A.length - 1);
	}
	
	public void quick_sort(int[] A, int lo, int hi) {
		if (lo >= hi) return;
		int m = partition(A, lo, hi);
		quick_sort(A, lo, m - 1);
		quick_sort(A, m + 1, hi);
	}
	
	private int partition(int[] A, int lo, int hi) {
		int i = lo, j = hi + 1, v = A[lo];
		while (true) {
			// find item on lo to swap
			while (A[++i] < v)
				if (i == hi) break;
			// find item on hi to swap
			while (A[--j] > v)
				if (j == lo) break;
			if (i >= j) break;
			swap(A, i, j);
		}
		swap(A, lo, j);	// be careful, we need swap with j, not i !!!
		
		// Now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
		return j;
	}
	
	private void swap(int[] A, int i, int j) {
		int swap = A[i]; A[i] = A[j]; A[j] = swap;
	}
}
