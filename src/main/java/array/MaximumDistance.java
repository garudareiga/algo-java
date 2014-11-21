package array;

import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given an array A of integers, find the maximum of j-i subjected to the 
 * constraint of A[i] < A[j].
 * 
 * http://leetcode.com/2011/05/a-distance-maximizing-problem.html
 */

public class MaximumDistance {
    class Line implements Comparable<Line> {
        public int value;
        public int index;

        public Line(int value, int index) {
            this.value = value; this.index = index;
        }
        
        public int compareTo(Line r) {
            if (this.value == r.value)
                return this.index - r.index;
            return this.value - r.value;
        }
    }
    
    int maximumDistance(int[] A) {
        int len = A.length;
        ArrayList<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < len; i++)
            lines.add(new Line(A[i], i));
             
        Collections.sort(lines);
        int maxDist = 0, r = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (lines.get(i).index < lines.get(r).index) {
                if (lines.get(i).value < lines.get(r).value) 
                    maxDist = Math.max(maxDist, lines.get(r).index - lines.get(i).index);
            } else
                r = i;
        }
        return maxDist;
    }
}
