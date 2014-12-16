package array;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given an array of n integers, find 3 elements such that a[i] < a[j] < a[k] 
 * and i < j < k in 0(n) time.
 *
 */

public class IncreasingSequence {
	boolean hasIncreasingSequence(int[] A) {
		boolean[] smallerLeft = new boolean[A.length];
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > min) smallerLeft[i] = true;
			else min = A[i];
		}
		for (int i = A.length - 1; i >= 0; i--) {
			if (A[i] < max && smallerLeft[i]) return true;
			max = Math.max(max, A[i]);
		}
		return false;
	}
	
	public static void main(String[] args) {
		IncreasingSequence is = new IncreasingSequence();
		System.out.println(is.hasIncreasingSequence(new int[] {1,5,5,4,3,2,2}));
		System.out.println(is.hasIncreasingSequence(new int[] {1,5,5,4,3,6,2}));
	}
}
