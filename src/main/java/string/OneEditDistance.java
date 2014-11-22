package string;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given two strings S and T, determine if they are both one edit distance apart.
 */ 

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        /*
         * Runtime Complexity: O(n)
         * Space Complexity: O(1)
         */
        int slen = s.length(), tlen = t.length();
        if (Math.abs(slen - tlen) > 1) return false;
        if (slen == tlen) {
            for (int i = 0; i < slen; i++)
                if ((s.substring(0, i) + s.substring(i + 1, slen)).
                    equals(t.substring(0, i) + t.substring(i + 1, tlen))) 
                    return true;
        } else {
            if (slen < tlen) { String w = s; s = t; t = w; }
            for (int i = 0; i < slen; i++) {
                if (t.equals(s.substring(0, i) + s.substring(i + 1, slen)))
                    return true;
            }
        }
        return false;
    }
}
