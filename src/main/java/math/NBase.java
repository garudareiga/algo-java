package math;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Convert 1025 to base-7
 * 1) 1025 % 7 = 3, next 1025/7 = 146
 * 2)  146 % 7 = 6, next  146/7 = 20
 * 3)   20 % 7 = 6, next   20/7 = 2
 * 4)            2
 * The result is 2663
 * 
 * Convert 23 to base-4: 113
 * 
 * Here, base has to be less than 10
 * 
 */

public class NBase {
    public int nbase(int num, int K) {
        int result = 0, mul = 1;
        while (num > 0) {
            result += (num%K)*mul;
            num /= K;
            mul *= 10;
        }
        return result;
    }
    
    public static void main(String[] args) {
        NBase nb = new NBase();
        System.out.println(nb.nbase(1025, 7));
        System.out.println(nb.nbase(23, 4));
    }
}
