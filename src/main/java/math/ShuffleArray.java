package math;

import java.util.*;
import util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given an array, generate a random permutation of array elements
 * 
 * The probability that ith element goes to last position is 1/n
 * The probability that ith element goes to second last position:
 *  ((n-1)/n)*(1/(n-1)) = 1/n
 * ... ...
 */

public class ShuffleArray {
    public void shuffle(int[] A) {
        Random rand = new Random();
        for (int i = A.length; i > 0; i--) {
            int j = rand.nextInt(i);
            Array.swap(A, i - 1, j);
        }
    }
    
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7};
        ShuffleArray sa = new ShuffleArray();
        sa.shuffle(A);
        for (int a : A)
            System.out.print(a + " ");
    }
}
