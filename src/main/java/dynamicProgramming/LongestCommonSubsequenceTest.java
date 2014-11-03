package dynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonSubsequenceTest {

    @Test
    public void test1() {
        String s1 = "ABAZDC"; 
        String s2 = "BACBAD";
        LongestCommonSubsequence sol = new LongestCommonSubsequence();
        assertEquals("ABAD", sol.longestSubsequence(s1, s2));
    }
    
    @Test
    public void test2() {
        String s1 = "nematodeknowledge"; 
        String s2 = "emptybottle";
        LongestCommonSubsequence sol = new LongestCommonSubsequence();
        assertEquals("emtole", sol.longestSubsequence(s1, s2));
    }
    
}
