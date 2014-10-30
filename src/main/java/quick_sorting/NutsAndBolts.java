package quick_sorting;

/* 
 * Given a collection of n nuts of distinct sizes and n bolts such that 
 * there is a one-to-one correspondence between the nuts and the bolts, 
 * find for each nut its corresponding bolt.Ó We can only compare nuts 
 * to bolts i.e., we can neither compare nuts to nuts nor bolts to bolts.
 */

public class NutsAndBolts {
	public static class NutBoltMatchObject {
		public NutBoltMatchObject(int size) {
			this.size = size;
		}
		public int size;
	}
	
	public static class Nut extends NutBoltMatchObject {
		public Nut(int size) {
	        super(size);
        }}
	public static class Bolt extends NutBoltMatchObject {
		public Bolt(int size) {
	        super(size);
        }}
	
	public int compare(NutBoltMatchObject n, NutBoltMatchObject b) {
		return n.size - b.size;
	}
	
	public void match(Nut N[], Bolt B[]) {
		int n = N.length;
		match(N, B, 0, n - 1);
	}
	
	private void match(Nut N[], Bolt B[], int lo, int hi) {
		if (lo >= hi) return;
		NutBoltMatchObject pivotal_n = N[lo], pivotal_b = null;
		for (int k = lo; k <= hi; k++) {
			if (compare(pivotal_n, B[k]) == 0) {
				swap(B, lo, k);
				break;
			}
		}
		pivotal_b = B[lo];
		int m = partition(N, lo, hi, pivotal_b);
		partition(B, lo, hi, pivotal_n);
		match(N, B, lo, m - 1);
		match(N, B, m + 1, hi);
	}
	
	private int partition(NutBoltMatchObject[] A, int lo, int hi, NutBoltMatchObject pivotal) {
		int i = lo, j = hi + 1;
		while (true) {
			// find item on lo to swap
			while (compare(A[++i], pivotal) < 0)
				if (i == hi) break;
			// find item on hi to swap
			while (compare(A[--j], pivotal) > 0)
				if (j == lo) break;
			if (i >= j) break;
			swap(A, i, j);
		}
		swap(A, lo, j);	// be careful, we need swap with j, not i !!!
		
		// Now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
		return j;
	}
	
	private void swap(Object[] A, int i, int j) {
		Object swap = A[i]; A[i] = A[j]; A[j] = swap;
	}
}
