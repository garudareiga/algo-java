package dynamicProgramming;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given two strings, find the length of longest common substring.
 * 
 * For example,
 * Given "ABABC" and "BABCA", the longest length is 3 of "ABC" or "BAB"
 */ 

public class LongestCommonSubstring {
    int longestCommonSubstring(String s1, String s2) {
        /*
         * Dynamic Programming
         * Runtime Complexity: O(n^2)
         * Space Complexity: O(n^2) -> easy to be optimized to be O(n)
         */
        int len1 = s1.length(), len2 = s2.length(), maxLen = 0;
        int[][] array = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) array[i][0] = 0;
        for (int i = 0; i < len2; i++) array[0][i] = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    array[i][j] = array[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, array[i][j]);
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return maxLen;
    }
}
