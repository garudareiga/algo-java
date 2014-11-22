package list;

import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given a nested list of integers, returns the sum of all integers 
 * in the list weighted by their depth 
 * For example, 
 * Given the list {{1,1},2,{1,1}} the function should return 10 
 * (four 1's at depth 2, one 2 at depth 1)
 * Given the list {1,{4,{6}}} the function should return 27 
 * (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3)
 */

public class NestedListOfIntegers {
    int sum(List<Object> nestedlist) {
        return sum(nestedlist, 1);
    }
    
    @SuppressWarnings("unchecked")
    int sum(List<Object> nestedlist, int level) {
        int sum = 0;
        for (Object o : nestedlist) {
            if (o instanceof Integer)
                sum += (Integer) o * level;
            else if (o instanceof List)
                sum += sum((List<Object>) o, level + 1);
        }
        return sum;
    }
    
    public static void main(String[] args) {
        List<Object> nl = new ArrayList<Object>();
        List<Integer> n1 = new ArrayList<Integer>();
        n1.add(1); n1.add(1);
        List<Integer> n2 = new ArrayList<Integer>();
        n2.add(1); n2.add(1);
        nl.add(n1); nl.add(2); nl.add(n2);
        
        NestedListOfIntegers sol = new NestedListOfIntegers();
        System.out.println(sol.sum(nl));
    }
}
