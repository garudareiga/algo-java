package math;

import java.util.Random;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * http://leetcode.com/2010/11/rejection-sampling.html
 * Given a function which generates a random integer in the range [1, 7],
 * write a function which generates a random integer in the range [1, 10] uniformly.
 */ 

public class RejectSampling {
    Random randomGenerator = new Random();
    
    public int rand7() {
        return randomGenerator.nextInt(8) + 1; // [0, 7) + 1
    }
    
    public int rand10() {
        /*
         *    | 1  2  3  4  5  6  7
         *  ------------------------   
         *  1 | 1  2  3  4  5  6  7
         *  2 | 8  9 10  1  2  3  4
         *  3 | 5  6  7  8  9 10  1
         *  4 | 2  3  4  5  6  7  8
         *  5 | 9 10  1  2  3  4  5
         *  6 | 6  7  8  9 10  *  *
         *  7 | *  *  *  *  *  *  *
         */
        while (true) {
            int r = 7*(rand7() - 1) + rand7();
            if (r <= 40)
                return r % 10;
        }       
    }
}
