package array;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Input array: [1,3,4,5]
 * Output array: [60,20,15,12]
 * 
 * Don't use division.
 */

public class Multiplication {
    int[] multiplication(int A[]) {
        int[] result = new int[A.length];
        int left = 1, right = 1;
        for (int i = 0; i < A.length; i++) {
            result[i] = left; left *= A[i];
        }
        for (int i = A.length - 1; i >= 0; i--) {
            result[i] *= right; right *= A[i];
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] A = {1,3,4,5};
        Multiplication mul = new Multiplication();
        int[] R = mul.multiplication(A);
        for (int n : R) System.out.print(n + " ");
    }
}
