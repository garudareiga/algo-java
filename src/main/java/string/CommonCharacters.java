package string;

/**
 * 
 * @author raychen
 * Problem:
 * Write a program that gives count of common characters presented in an array of strings.
 */

public class CommonCharacters {
    public String common(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int bits = 0xFFFFFFFF;
        for (String str : strs) {
            int curr = 0;
            for (int i = 0; i < str.length(); i++)
                curr |= 1<<(str.charAt(i) - 'a');
            bits &= curr;
        }
        
        int cnt = 0;
        while (bits != 0) {
            if ((bits & 0x1) != 0) sb.append((char)('a' + cnt));
            bits >>= 1;
            cnt++;
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        CommonCharacters sol = new CommonCharacters();
        String[] strs = {
            "aghkafgklt",
            "dfghako",
            "qwemnaarkf"  
        };
        System.out.println(sol.common(strs));
    }
}
