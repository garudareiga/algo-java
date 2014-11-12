package bitOps;

public class ReverseBits {
    int reverseBits(int value) {
        // Java int type 32-bit
        boolean sign = value >= 0 ? true : false;
        value = (sign == true ? value : -value);
        for (int i = 0; i < 16; i++)
            value = swapBit(value, i, 31 - i);
        return sign == true ? value : -value;
    }

    private int swapBit(int value, int i, int j) {
        int lo = (value>>i) & 1;
        int hi = (value>>j) & 1;
        if ((lo ^ hi) == 1) {
            value ^= (lo<<j | hi<<i);
        }
        return value;
    }
}
