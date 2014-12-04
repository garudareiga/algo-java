package array;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given a sorted array and a target, find the first number larger than the target
 */

public class FirstNumber {
    int findLargerFirstNumber(int[] A, int target) {
        //return find(A, 0, A.length - 1, target);
    	int l = 0, r = A.length - 1;
    	while (l <= r) {
    		int m = (l + r)/2;
    		if (target >= A[m]) l = m + 1;
    		else r = m - 1;
    	}
    	return l == A.length ? -1 : A[l];
    }
    
    int findSmallerFirstNumber(int[] A, int target) {
    	int l = 0, r = A.length - 1;
    	while (l <= r) {
    		int m = (l + r)/2;
    		if (target <= A[m]) r = m - 1;
    		else l = m + 1;
    	}
    	return r == -1 ? -1 : A[r];
    }
    
    int find(int[] A, int lo, int hi, int target) {
        if (lo > hi) return Integer.MAX_VALUE;
        int mid = (lo + hi)/2;
        if (target < A[mid]) return Math.min(A[mid], find(A, lo, mid - 1, target));
        else return find(A, mid + 1, hi, target);
    }
    
    public static void main(String[] args) {
        int[] A = {1, 3, 6, 8, 10, 15, 20};
        FirstNumber sol = new FirstNumber();
        System.out.println(sol.findLargerFirstNumber(A, 11)); // 15
        System.out.println(sol.findLargerFirstNumber(A, 6)); // 8
        System.out.println(sol.findLargerFirstNumber(A, 22)); // -1
        System.out.println(sol.findLargerFirstNumber(A, 0)); // 1
        
        System.out.println(sol.findSmallerFirstNumber(A, 11)); // 10
        System.out.println(sol.findSmallerFirstNumber(A, 6)); // 3
        System.out.println(sol.findSmallerFirstNumber(A, 22)); // 20
        System.out.println(sol.findSmallerFirstNumber(A, 0)); // -1
    }
}
