package dynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonSubstringTest {

    @Test
    public void test1() {
        String s1 = "BABAC"; 
        String s2 = "CBABB";
        LongestCommonSubstring sol = new LongestCommonSubstring();
        assertEquals(3, sol.longestCommonSubstring(s1, s2));
    }
    
    @Test
    public void test2() {
        String s1 = "fashion"; 
        String s2 = "crashes";
        LongestCommonSubstring sol = new LongestCommonSubstring();
        assertEquals(3, sol.longestCommonSubstring(s1, s2));
    }
    
    @Test
    public void test3() {
        String s1 = "technical"; 
        String s2 = "echniacea";
        LongestCommonSubstring sol = new LongestCommonSubstring();
        assertEquals(5, sol.longestCommonSubstring(s1, s2));
    }
    
}
