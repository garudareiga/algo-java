package dynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void test1() {
        int[] A = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int[] B = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence();
        assertEquals(6, sol.find(A));
        assertEquals(6, sol.find(B));
    }
    
    @Test
    public void test2() {
        int[] A = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int[] B = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence();
        assertEquals(6, sol.longestIncreasingSubsequence(A));
        assertEquals(6, sol.longestIncreasingSubsequence(B));
    }
    
}
