package sort;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Count inversions in an array
 * http://www.geeksforgeeks.org/counting-inversions/
 */

public class InversionCounting {
    public int count(int[] A) {
        /*
         * Time Complexity: O(nlog(n))
         * Space Complexity: O(n)
         */
        int l = 0, r = A.length - 1;
        return mergeSortAndCount(A, l, r);
    }
    
    public int mergeSortAndCount(int[] A, int l, int r) {
        int cc = 0;
        if (l < r) {
            int m = (l + r)/2;
            cc = mergeSortAndCount(A, l, m);
            cc += mergeSortAndCount(A, m + 1, r);
            // merge
            int[] swap = new int[A.length];
            int i = l, li = l, ri = m + 1;
            while (li <= m && ri <= r) {
                if (A[li] <= A[ri]) swap[i++] = A[li++];
                else { swap[i++] = A[ri++]; cc += m - li + 1; }
            }
            while (li <= m) swap[i++] = A[li++];
            while (ri <= r) swap[i++] = A[ri++];
            for (i = l; i <= r; i++) A[i] = swap[i];
        }
        return cc;
    }
    
    public static void main(String[] args) {
        InversionCounting sol = new InversionCounting();
        int[] A = {1,20,6,4,5};
        int[] B = {2,4,1,3,5};
        System.out.println(sol.count(A)); // 5
        System.out.println(sol.count(B)); // 3
    }
}
