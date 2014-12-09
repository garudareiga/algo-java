package string;

/*
 *
 * @author raychen
 * 
 * Problem:
 * aabbbcccc -> 2a3b4c
 * abc -> abc
 */

public class StringCompress {
    public String compress(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            char c = str.charAt(i);
            if (i == str.length() - 1 || c != str.charAt(i + 1)) {
                if (count == 1) sb.append(c);
                else sb.append(String.format("%d%c", count, c));
                count = 0;
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        StringCompress sc = new StringCompress();
        System.out.println(sc.compress("aabbbcccc"));
        System.out.println(sc.compress("abc"));
    }
}
