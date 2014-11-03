package dynamicProgramming;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given two strings, find the length of longest common subsequence.
 * 
 * For example,
 * Given "ABAZDC" and "BACBAD", the longest length is 4 of "ABAD".
 */ 

public class LongestCommonSubsequence {
    String longestSubsequence(String s1, String s2) {
        /*
         * Dynamic Programming
         * Runtime Complexity: O(n^2)
         * Space Complexity: O(n^2) -> easy to be optimized to be O(n)
         */
        int len1 = s1.length(), len2 = s2.length();
        int[][] array = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) { array[i][j] = 0; continue; }
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    array[i][j] = array[i - 1][j - 1] + 1;
                } else {
                    array[i][j] = Math.max(array[i][j - 1], array[i - 1][j]);
                }
            }
        }
        
        // read the substring out of matrix
        StringBuilder sb = new StringBuilder();
        for (int i = len1, j = len2; i > 0 && j > 0; ) {
            if (array[i][j] == array[i - 1][j])
                i--;
            else if (array[i][j] == array[i][j - 1])
                j--;
            else {
                sb.append(s1.charAt(i - 1)); i--; j--;
            }
        }
        return sb.reverse().toString();
        //return array[len1][len2];
    }
}
