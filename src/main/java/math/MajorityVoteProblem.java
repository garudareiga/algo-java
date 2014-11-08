package math;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Majority Vote Problem
 * A majority element in an array A[] of size n is an element 
 * that appears more than n/2 times. Find the majority element
 * in O(n).
 * 
 * for example:
 *  3, 3, 4, 2, 4, 4, 2, 4, 4
 *  
 * return: 4
 * 
 * if no majority element, return -1
 * 
 * http://www.geeksforgeeks.org/majority-element/
 * 
 * Can be extened to N/3 majority problem
 * 
 * Pick 3 different numbers and eliminate them 
 * If we have 3 left, no majority number exists.
 * If we have 2 left, verify if one of them is majority number.
 */

public class MajorityVoteProblem {
    public int majority(int[] A) {
        int pos = 0, count = 0;
        for (int i = 0; i < A.length; i++) {
            if (count == 0) { pos = i; count = 1; }
            else if (A[i] == A[pos]) count++;
            else count--;
        }
        
        if (count == 0) return -1;
        count = 0;
        for (int i = 0; i < A.length; i++)
            if (A[i] == A[pos])
                count++;
        return count > A.length/2 ? A[pos] : -1;
    }
}
