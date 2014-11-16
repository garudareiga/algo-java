package math;

import java.util.*;

/*
 * Problem:
 * Print all ugly number in the range [1, N]
 * http://www.geeksforgeeks.org/ugly-numbers/
 */

public class UglyNumber {
    public List<Integer> getUglyNumbers(int N) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i <= N; i++) {
            if (isUglyNumber(i))
                result.add(i);
        }
        return result;
    }

    private boolean isUglyNumber(int i) {
        int r = i;
        r = maxDivide(r, 2);
        r = maxDivide(r, 3);
        r = maxDivide(r, 5);
        return r == 1;
    }

    private int maxDivide(int dividend, int divisor) {
        while (dividend % divisor == 0)
            dividend /= divisor;
        return dividend;
    }
    
    public static void main(String[] args) {
        UglyNumber sol = new UglyNumber();
        List<Integer> r = sol.getUglyNumbers(20);
        for (Integer n : r)
            System.out.print(n + " ");
    }
}
