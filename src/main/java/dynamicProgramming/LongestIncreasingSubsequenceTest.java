package dynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void test1() {
        int[] A = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence();
        assertEquals(6, sol.find(A));
    }
    
}
