package math;

import java.util.ArrayList;
import com.google.common.base.Joiner;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Find missing number between 0-99
 * input:[5,6,80]
 * output:"0-4,7-79,81-99"
 */

public class FindMissingNumbers {
    public String findMissingNumbers(int[] A) {
        ArrayList<String> result = new ArrayList<String>();
        int l = 0, r = 0;
        for (int i = 0; i < A.length; i++) {
            if (l != A[i]) {
                r = A[i] - 1;
                if (l == r)
                    result.add(String.valueOf(l));
                else
                    result.add(l + "-" + r);
            }
            l = A[i] + 1;
        }
        if (l < 100) {
            if (l == 99) result.add(String.valueOf(l));
            else result.add(l + "-99");
        }
        // Use Guava Joiner
        return Joiner.on(",").join(result);
        /*
        StringBuilder sb = new StringBuilder();
        String prefix = "";
        for (String str : result) {
            sb.append(prefix);
            prefix = ",";
            sb.append(str);
        }
        return sb.toString();
        */
    }
    
    public static void main(String[] args) {
        FindMissingNumbers sol = new FindMissingNumbers();
        
        int[] A = {5,6,80};
        System.out.println(sol.findMissingNumbers(A));
        
        int[] B = {0,2,8,22,23,55,56,57,59,80,98,99};
        System.out.println(sol.findMissingNumbers(B));
    }
}
