package math;

/*
 *
 * @author raychen
 * 
 * Problem:
 * Given two strings
 * A =   " 41340"
 * B =  "1567312"
 *   -> "1608652"
 */

public class AddTwoNumbers {
    public String add(String a, String b) {
        if (a.length() < b.length()) {
            String tmp = a; a = b; b = tmp;
        }
        int alen = a.length(), blen = b.length();
        
        a = (new StringBuilder(a)).reverse().toString();
        b = (new StringBuilder(b)).reverse().toString();
        
        StringBuilder sb = new StringBuilder();
        int carry = 0, va, vb, v;
        for (int i = 0; i < alen; i++) {
            va = Character.getNumericValue(a.charAt(i));
            vb = i >= blen ? 0 : Character.getNumericValue(b.charAt(i));
            v = va + vb + carry;
            carry = v / 10;
            sb.append(v%10);
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        String A = "41340", B = "1567312";
        AddTwoNumbers sol = new AddTwoNumbers();
        System.out.println(sol.add(A, B)); // 1608652
    }
}
