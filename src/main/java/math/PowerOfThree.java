package math;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Check if number is power of 3
 */

public class PowerOfThree {
    boolean isPowerOfThree(int n) {
        // 3, 9, 27, 81, 243, ...
        while (n % 3 == 0) {
            int d = 3;
            while (n >= d && n % d == 0) {
                n /= d; d *= d;
            }
        }
        return n == 1;
    }
    
    public static void main(String[] args) {
        PowerOfThree sol = new PowerOfThree();
        System.out.println(sol.isPowerOfThree(243));
        System.out.println(sol.isPowerOfThree(240));
        System.out.println(sol.isPowerOfThree(43046721));
    }
}
