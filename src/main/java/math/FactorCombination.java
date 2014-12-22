package math;

import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Print all possible division combinations ?
 * 
 * For example:
 * 
 * 24 -> 2*2*2*3
 *       2*3*4
 *       3*8
 *       4*6
 *       
 * Different version:
 * 4 -> 1 + 1 + 1 + 1
 *      1 + 1 + 2
 *      2 + 2    
 */

public class FactorCombination {   
    public List<List<Integer>> combination(int value) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        dfs(value, stack, result);
        return result;
    }
 
    private void dfs(int dividend, Stack<Integer> stack, List<List<Integer>> result) {
        if (!stack.isEmpty()) {
            List<Integer> lt = new ArrayList<Integer>(stack);
            lt.add(dividend);
            result.add(lt);
        }
        int divisor = stack.isEmpty() ? 2 : stack.peek();
        for (; divisor < dividend; divisor++) {
            if (dividend/divisor < divisor) break;
            if (dividend%divisor == 0) {
                int quotient = dividend/divisor;
                stack.push(divisor);
                dfs(quotient, stack, result);
                stack.pop();
            }
        }
    }
}
