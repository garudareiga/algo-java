package math;

import java.util.List;
import java.util.Random;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Generate a number is range (1,n) but not in a sorted list.
 * 
 * For example range is (1,1000), list is [2,3,5,9,199,200,344]
 * 
 * Solution:
 * 1. generate a random number in the valid range (1, 1000 - len(list)). 
 * 2. iterate through the blacklist, if the generated number is greater 
 *    than or equals than the number in the sorted list.
 */

public class RandomNumber {
    public int randomNumber(int K, List<Integer> sortedList) {
        Random rand = new Random();
        int randomNum = rand.nextInt(K - sortedList.size()) + 1;
        for (Integer sn : sortedList) {
            if (randomNum >= sn) randomNum += 1;
            else break;
        }
        return randomNum;
    }
}
