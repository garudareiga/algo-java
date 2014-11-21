package dynamicProgramming;

import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given a target number, return a smallest set of square numbers (1, 4, 9, 16, ...)
 * such that the sum equals to the target number
 * 
 * For example:
 * 14 = 9 + 4 + 1
 * 12 = 4 + 4 + 4
 * 10 = 9 + 1
 */ 

public class SumOfSquareNumbers {
    List<Integer> find(int target) {
        ArrayList<Integer> items = new ArrayList<Integer>();
        for (int i = 1; ; i++) {
            if (i*i > target) break;
            items.add(i*i);
        }
        //return useDynamicProgramming(target, items);
        return bfs(target, items);
    }
    
    List<Integer> bfs(int target, ArrayList<Integer> items) {
        Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>();
        q.add(new ArrayList<Integer>());
        while (!q.isEmpty()) {
            ArrayList<Integer> prev = q.poll();
            int sum = 0;
            for (int n : prev) sum += n;
            for (int i = 0; i < items.size(); i++) {
                if (sum + items.get(i) > target) break;
                ArrayList<Integer> curr = new ArrayList<Integer>(prev);
                curr.add(items.get(i));
                if (sum + items.get(i) == target) return curr;
                q.add(curr);
            }
        }
        return null;
    }
        
    List<Integer> useDynamicProgramming(int target, ArrayList<Integer> items) {    
        // Unbounded Knapsack problem
        ArrayList<ArrayList<Integer>> itemsArray = new ArrayList<ArrayList<Integer>>();
        itemsArray.add(new ArrayList<Integer>());
        for (int i = 1; i <= target; i++) {
            int prevItemCount = Integer.MAX_VALUE;
            ArrayList<Integer> prevItems = null;
            int newItem = 0;
            for (int j = 0; j < items.size(); j++) {
                if (i < items.get(j)) continue;
                ArrayList<Integer> prev = itemsArray.get(i - items.get(j));
                if (prev.size() < prevItemCount) {
                    prevItemCount = prev.size();
                    prevItems = prev;
                    newItem = items.get(j);
                }
            }
            
            ArrayList<Integer> curr = new ArrayList<Integer>(prevItems);
            curr.add(newItem);
            itemsArray.add(curr);
        }
        return itemsArray.get(target);
    }
    
    public static void main(String[] args) {
        SumOfSquareNumbers sol = new SumOfSquareNumbers();
        
        List<Integer> r1 = sol.find(14);
        for (Integer n : r1) System.out.print(n + " ");
        System.out.println();
        
        List<Integer> r2 = sol.find(12);
        for (Integer n : r2) System.out.print(n + " ");
        System.out.println();
        
        List<Integer> r3 = sol.find(10);
        for (Integer n : r3) System.out.print(n + " ");
        System.out.println();
    }
}
