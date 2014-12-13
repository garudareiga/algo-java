package string;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given two strings containing digits, return the one which represents
 * the largest integer once the digits have been sorted in non-increasing order.
 * 
 * “245” -> 542
 * “178” -> 871
 * return "178"
 */ 

public class StringCompare {
    public String compare(String A, String B) {
        if (A.length() != B.length()) return A.length() > B.length() ? A : B;
        int[] a = new int[10], b = new int[10];
        for (int i = 0; i < A.length(); i++) a[Character.getNumericValue(A.charAt(i))] += 1;
        for (int i = 0; i < B.length(); i++) b[Character.getNumericValue(B.charAt(i))] += 1;
        for (int i = 9; i >= 0; i--) {
            if (a[i] > b[i]) return A;
            else if (a[i] < b[i]) return B;
        }
        return A;
    }
    
    public static void main(String[] args) {
        String A = "245", B = "178";
        StringCompare sc = new StringCompare();
        System.out.println(sc.compare(A, B));
    }
}
