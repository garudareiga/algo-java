package math;

import java.util.*;

/*
 *
 * @author raychen
 * 
 * Problem:
 * Print all factors of a given int:
 * e.g. input: 20 -> output: 1,2,4,5,10,20
 */

public class AllFactors {
    List<Integer> allFactors(int input) {
        List<Integer> result = new ArrayList<Integer>();
        int rb = input;
        for (int i = 1; i <= rb; i++) {
            if (input%i != 0) continue;
            int j = input/i;
            result.add(i);
            if (i != j) result.add(j);
            rb = j - 1;
        }
        return result;
    }
    
    public static void main(String[] args) {
        AllFactors af = new AllFactors();
        {
            List<Integer> result = af.allFactors(20);
            System.out.println(result.toString());
        }
        {
            List<Integer> result = af.allFactors(100);
            System.out.println(result.toString());
        }
        {
            List<Integer> result = af.allFactors(1);
            System.out.println(result.toString());
        }
    }
}
