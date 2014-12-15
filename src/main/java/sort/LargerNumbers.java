package sort;

import java.util.Arrays;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given a integer array A, s[i] is the number of integers which in larger
 * than a[i] in the range of s[i+1...n-1].
 * 
 * Find the largest s[i].
 * 
 * The time complexity is O(nlogn).
 * using the same idea of merge sort.
 */

public class LargerNumbers {
    public int maxNum(int[] A) {
        int[] count = new int[A.length];
        Arrays.fill(count, 0);
        mergeSort(A, 0, A.length - 1, count);
        int result = Integer.MIN_VALUE;
        for (int c : count) {
            System.out.print(c + " ");
            result = Math.max(result, c);
        }
        System.out.println();
        return result;
    }
    
    public void mergeSort(int[] A, int lo, int hi, int[] count) {
        if (lo >= hi) return;
        int mid = (lo + hi)/2;
        mergeSort(A, lo, mid, count);
        mergeSort(A, mid + 1, hi, count);
        
        int[] temp = new int[A.length], tempCount = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            temp[i] = A[i]; tempCount[i] = count[i];
        }
        int p= lo, p1 = lo, p2 = mid + 1;
        while (p1 <= mid && p2 <= hi) {
            if (temp[p1] < temp[p2]) {
                A[p] = temp[p1]; count[p] = tempCount[p1] + hi - p2 + 1; p1++;
            } else { // including p1 = p2
                A[p] = temp[p2]; count[p] = tempCount[p2]; p2++;
            }
            p++;
        }
        while (p1 <= mid) {
            A[p] = temp[p1]; count[p] = tempCount[p1]; p1++; p++; 
        }
    }
    
    public static void main(String[] args) {
        int[] A = {4,8,3,2,1,6,5,7};
        LargerNumbers ln = new LargerNumbers();
        System.out.println(ln.maxNum(A));
    }
}
