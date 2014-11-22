package array;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given a sorted array and a target, find the first number larger than the target
 */

public class FirstLargerNumber {
    int find(int[] A, int target) {
        return find(A, 0, A.length - 1, target);
    }
    
    int find(int[] A, int lo, int hi, int target) {
        if (lo > hi) return Integer.MAX_VALUE;
        int mid = (lo + hi)/2;
        if (target < A[mid]) return Math.min(A[mid], find(A, lo, mid - 1, target));
        else return find(A, mid + 1, hi, target);
    }
    
    public static void main(String[] args) {
        int[] A = {1, 3, 6, 8, 10, 15, 20};
        FirstLargerNumber sol = new FirstLargerNumber();
        System.out.println(sol.find(A, 11));
        System.out.println(sol.find(A, 6));
        System.out.println(sol.find(A, 22));
    }
}
