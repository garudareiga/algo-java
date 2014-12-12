package math;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Swap bits at odd or even positions for an integer
 * e.g.
 * 6 (0101) -> 9 (1010)
 */

public class SwapBit {
    int swap(int value) {
        int n = 0, result = 0;
        while (value > 0) {
            int curr = value & 0x3;
            result ^= ((curr&0x1)<<1 ^ (curr&0x2)>>1)<<n;
            n += 2; 
            value >>= 2;
        }
        return result;
    }
    
    public static void main(String[] args) {
        SwapBit sb = new SwapBit();
        System.out.println(sb.swap(6)); // 9
    }
}
