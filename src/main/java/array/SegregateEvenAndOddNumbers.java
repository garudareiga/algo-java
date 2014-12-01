package array;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given an array A[], write a function that segregates even and odd numbers. 
 * The functions should put all even numbers first, and then odd numbers.
 */

public class SegregateEvenAndOddNumbers {
    public void segregate(int[] A) {
        int l = -1, r = A.length;
        while (true) {
            while (l < A.length -1 && A[++l] % 2 == 0);
            while (r > 0 && A[--r] % 2 == 1);
            if (l >= r) break;
            int temp = A[l]; A[l] = A[r]; A[r] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[] A = {12,34,45,9,8,90,3};
        SegregateEvenAndOddNumbers sol = new SegregateEvenAndOddNumbers();
        sol.segregate(A);
        for (int n : A) System.out.print(n + " ");
    }
}
