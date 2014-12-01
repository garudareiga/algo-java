package math;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Division only using addition.
 */ 

public class DivideByAddition {
    public int divide(int dividend, int divisor) {
        int count = 1, curr = divisor;
        while (dividend > curr + curr) {
            curr += curr; count <<= 1;
        }
        for (int n = count; n < count << 1; n++) {
            if (curr + divisor > dividend) return n;
            curr += divisor;
        }
        return count;
    }
    
    public static void main(String[] args) {
        DivideByAddition sol = new DivideByAddition();
        System.out.println(sol.divide(100, 2));
        System.out.println(sol.divide(100, 3));
    }
}
