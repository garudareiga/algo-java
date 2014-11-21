package bitOps;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Reverse bits of a number
 * 
 * For example:
 * 1101001 (105) -> 1001011 (75)
 * 
 * http://www.geeksforgeeks.org/write-an-efficient-c-program-to-reverse-bits-of-a-number/
 * http://leetcode.com/2011/08/reverse-bits.html
 */ 

public class ReverseBits {
    int reverseBits(int value) {
        int n = 0, tmp = value;
        while (tmp != 0) { n++; tmp >>= 1; }
        for (int i = 0; i < n/2; i++) {
            //System.out.println(Integer.toBinaryString(value));
            value = swapBit(value, i, n - 1 - i);
            //System.out.println(Integer.toBinaryString(value));
        }
        return value;
    }
    
    int reverseBitsBy32(int value) {
        // Java int 32 bits
        for (int i = 0; i < 16; i++)
            value = swapBit(value, i, 31 - i);
        return value;
    }

    private int swapBit(int value, int i, int j) {
        int lo = (value>>i) & 1;
        int hi = (value>>j) & 1;
        if ((lo ^ hi) == 1) {
            value ^= (1<<j | 1<<i);
        }
        return value;
    }
    
    public static void main(String[] args) {
        ReverseBits sol = new ReverseBits();
        System.out.println(sol.reverseBits(105)); // 1101001 (105) -> 1001011 (75)
    }
}
