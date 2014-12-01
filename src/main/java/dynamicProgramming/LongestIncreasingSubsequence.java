package dynamicProgramming;

import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Find the length of the longest subsequence such that all elements of the
 * subsequence are sorted in increasing order.
 *
 * For example:
 * The length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 
 * and LIS is {10, 22, 33, 50, 60, 80}
 * 
 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 * http://www.algorithmist.com/index.php/Longest_Increasing_Subsequence
 * 
 * Solution:
 * 1. Make a sorted copy and find the longest common subsequence
 *      Time Complexity: O(nlog(n)) + O(n^2)
 * 2. Dynamic Programming
 *      Time Complexity: O(n^2)
 *      
 *    O(nlog(n)) version:
 *    We have elements: a_1, a_2, a_3, ..., a_i.
 *    And we have a longest increasing subsequences of them: A_{i,1} < A_{i,2} < ... < A_{i,j}, 
 *    for any A_i,k (1 < = k < = j) you could not find a smaller alternative.
 *    
 *    Now we have a new element: a_i + 1
 *    What we can do about it:
 *    1. insert it at the back if A_i,j < a_i + 1, where we will have a longer one;
 *    2. make it an alternative for A_i,k if A_{i,k-1} < a_{i+1} AND a_{i+1} <= A_{i,k}
 *       Alternative means that we MIGHT get longer ones if using the new element.  
 */

public class LongestIncreasingSubsequence {
    public int find(int[] A) {
        /*
         * Time Complexity: O(n^2)
         * Space Complexity: O(n)
         */
        int maxLen = 1;
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                    maxLen = Math.max(maxLen, result[i]);
                }
            }
        }
        return maxLen;
    }
    
    public int longestIncreasingSubsequence(int[] A) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < A.length; i++) {
            if (array.isEmpty() || array.get(array.size() - 1) < A[i]) array.add(A[i]);
            else replace(array, A[i]);
        }
        System.out.println(array.toString());
        return array.size();
    }
    
    private void replace(ArrayList<Integer> array, int value) {
        int l = 0, r = array.size() - 1;
        while (l <= r) {
            int m = (l + r)/2;
            if (array.get(m) < value) l = m + 1;
            else if (array.get(m) > value) r = m - 1;
            else return;
        }
        array.set(l, value);
    }
}
