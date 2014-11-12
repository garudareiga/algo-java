package array;

import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given an array A of integers, find the maximum of j-i subjected to the 
 * constraint of A[i] < A[j].
 */

public class MaximumDistance {
    class IntObj implements Comparable<Object> {
        public int value;
        public int original_index;

        public int compareTo(Object r) {
            return this.value - ((IntObj)r).value;
        }
    }
    
    int maximumDistance(int[] A) {
        int len = A.length;
        ArrayList<IntObj> array = new ArrayList<IntObj>();
        for (int i = 0; i < len; i++) {
            IntObj obj = new IntObj();
            obj.value = A[i];
            obj.original_index = i;
            array.add(obj);
        }
             
        Collections.sort(array);
        int maxDist = 0, r = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (array.get(i).original_index < array.get(r).original_index) {
                if (array.get(i).value < array.get(r).value)
                    maxDist = Math.max(maxDist, array.get(r).original_index - array.get(i).original_index);
            } else
                r = i;
        }
        return maxDist;
    }
}
