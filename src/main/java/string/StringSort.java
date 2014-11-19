package string;

import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given {"face", "ball", "apple", "art", "ah" }
 * and string "htarfbp"
 * Sort according to string
 */ 

public class StringSort {
    class StringComparator implements Comparator<String> {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        
        public StringComparator(String strorder) {
            for (int i = 0; i < strorder.length(); i++)
                hm.put(strorder.charAt(i), i);
        }
        
        public int compare(String str0, String str1) {
            int len0 = str0.length(), len1 = str1.length();
            for (int i = 0; i < Math.min(len0, len1); i++) {
                char c0 = str0.charAt(i), c1 = str1.charAt(i);
                if (hm.get(c0) == hm.get(c1)) continue;
                else if (hm.get(c0) > hm.get(c1)) return 1;
                else if (hm.get(c0) < hm.get(c1)) return -1;
            }
            if (len0 == len1) return 0;
            return len0 > len1 ? 1 : -1;
        }
    }
    
    public String[] sort(String[] strArray, String strOrder) {
        StringComparator comparator = new StringComparator(strOrder);
        Arrays.sort(strArray, comparator);
        return strArray;
    }
    
    public static void main(String[] args) {
        String[] strArray = {"bc", "ca", "a", "aa", "bac" };
        String strOrder = "abc";
        
        StringSort ss = new StringSort();
        String[] result = ss.sort(strArray, strOrder);
        for (String str : result) {
            System.out.println(str);
        }
    }
}
