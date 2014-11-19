package math;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Determining if an integer is a power of 2
 */

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }
    
    public static void main(String[] args) {
        PowerOfTwo sol = new PowerOfTwo();
        int[] N = {4, 8, 7, 16, 256, 312};
        for (int n : N) 
            System.out.println(String.format("%d is power of 2 ? %b", n, sol.isPowerOfTwo(n)));
    }
}
