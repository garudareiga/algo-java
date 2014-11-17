package math;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Computes the number of trailing zeros in n factorial
 * 
 * Trailing 0s in n! = Count of 5s in prime factors of n!
 *                   = floor(n/5) + floor(n/25) + ...
 * 
 * http://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
 * http://www.programmerinterview.com/index.php/java-questions/find-trailing-zeros-in-factorial/
 */ 

public class TailingZeros {
    int tailingZeros(int value) {
        int count = 0;
        for (int d = 5; d < value; d *= 5)
            count += value/d;
        return count;
    }
}
