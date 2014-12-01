package array;

import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Largest distance in the decreasing sequence
 * 
 * For example, [2,3,7,4,6,1,10], output 7 - 1 = 6
 */

public class MaxDecreasingDistance {
    int maxDistance(int[] A) {
        int lm = Integer.MIN_VALUE, maxDist = 0;
        for (int r = 0; r < A.length; r++) {
            if (A[r] > lm) lm = A[r];
            else maxDist = Math.max(lm - A[r], maxDist);
        }
        return maxDist;
    }
    
    public static void main(String[] args) {
        int[] A = {2,3,7,4,6,1,10};
        MaxDecreasingDistance sol = new MaxDecreasingDistance();
        System.out.println(sol.maxDistance(A));
    }
}
