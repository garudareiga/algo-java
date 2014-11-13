package string;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * http://leetcode.com/2010/11/microsoft-string-replacement-problem.html
 * Replace all occurrence of the given pattern to 'X'. 
 * 
 * For example,
 * Given pattern "abc", replace "abcdeffdfegabcabc" with "XdeffdfegX".
 * 
 * Note: multiple occurrences of contiguous abc's wil be replaced with
 * only one 'X'.
 */ 

public class StringReplacement {
    String replace(String S, String P) {
        /*
         * Do in-place replacement
         */
        StringBuilder sb = new StringBuilder();
        int plen = P.length();
        for (int p = 0; p <= S.length() - plen; ) {
            if (P.equals(S.substring(p, p + plen))) {
                if (sb.length() == 0 || sb.charAt(sb.length() - 1) != 'X')
                    sb.append('X');
                p += plen;
            } else 
                sb.append(S.charAt(p++));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        StringReplacement sol = new StringReplacement();
        System.out.println(sol.replace("abcdeffdfegabcabc", "abc"));
    }
}
