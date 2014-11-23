package math;

import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Print all possible addition combinations ?
 * 
 * For example:
 *       
 * Different version:
 * 4 -> 1 + 1 + 1 + 1
 *      1 + 1 + 2
 *      2 + 2    
 */

public class AdditionCombination {   
    public List<List<Integer>> combination(int value) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        dfs(value, stack, result);
        return result;
    }
 
    private void dfs(int value, Stack<Integer> stack, List<List<Integer>> result) {
        if (!stack.isEmpty()) {
            List<Integer> lt = new ArrayList<Integer>(stack);
            lt.add(value);
            result.add(lt);
        }
        int start = stack.isEmpty() ? 1 : stack.peek();
        for (int minus = start; minus < value; minus++) {
            if (value - minus < minus) break;
            stack.push(minus);
            dfs(value - minus, stack, result);
            stack.pop();
        }
    }
    
    public static void main(String[] args) {
        AdditionCombination sol = new AdditionCombination();
        List<List<Integer>> result = sol.combination(4);
        for (List<Integer> lt : result) {
            for (Integer n : lt)
                System.out.print(n + " ");
            System.out.println();
        }
    }
}
