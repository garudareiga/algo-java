package math;

import java.util.*;

/*
 * Problem:
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5
 * 
 * Print all ugly number in the range [1, N]
 * 
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
    
    public int getNthUglyNumber(int N) {
        int nextUglyNumber = 1;
        int[] uglyNumbers = new int[N];
        uglyNumbers[0] = nextUglyNumber;
        int indexBy2 = 0, indexBy3 = 0, indexBy5 = 0;
        for (int i = 1; i < N; i++) {
            nextUglyNumber = Math.min(uglyNumbers[indexBy2]*2, 
                    Math.min(uglyNumbers[indexBy3]*3, uglyNumbers[indexBy5]*5));
            uglyNumbers[i] = nextUglyNumber;
            if (nextUglyNumber == uglyNumbers[indexBy2]*2) { indexBy2 += 1; }
            if (nextUglyNumber == uglyNumbers[indexBy3]*3) { indexBy3 += 1; }
            if (nextUglyNumber == uglyNumbers[indexBy5]*5) { indexBy5 += 1; }
        }
        return nextUglyNumber;
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
        System.out.println();
        
        System.out.println("The 150th ugly number is " + sol.getNthUglyNumber(150));
    }
}
