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
 */

public class FactorCombination {
    public List<List<Integer>> find(int value) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(value);
        find_(stack, result);
        stack.pop();
        return result;
    }
	
    private void find_(Stack<Integer> stack, List<List<Integer>> result) {
        int dividend = stack.pop();
        int start = stack.isEmpty() ? 2 : stack.peek();
        for (int divisor = start; divisor < dividend; divisor++) {
        if (dividend / divisor < divisor) break;
            if (dividend % divisor == 0) {
            	int quotient = dividend / divisor;
            	stack.push(divisor);
            	stack.push(quotient);
            	List<Integer> curr = new ArrayList<Integer>(stack);
            	result.add(curr);
            	find_(stack, result);
            	stack.pop();
            	stack.pop();
            }
        }
        stack.push(dividend);
    }
}
