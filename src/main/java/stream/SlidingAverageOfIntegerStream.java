package stream;

import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Find moving average in a slide window of a infinite stream of integers
 * http://rosettacode.org/wiki/Averages/Simple_moving_average#Java
 * 
 */

public class SlidingAverageOfIntegerStream {
    private double sum = 0;
    private final int windowSize;
    private final Queue<Integer> window = new LinkedList<Integer>();
    
    public SlidingAverageOfIntegerStream(int windowSize) {
    	this.windowSize = windowSize;
    }
    
    public double newAvg(int value) {
    	sum += value;
    	window.add(value);
    	if (window.size() > windowSize)
    		sum -= window.poll();
    	return sum/window.size();
    }
    
    public static void main(String[] args) {
        SlidingAverageOfIntegerStream sol = new SlidingAverageOfIntegerStream(5);
        int[] A = {10,20,30,40,50,60};
        for (int v : A) {
            System.out.println(String.format("Median of add %d: %.2f", v, sol.newAvg(v)));
        }
    }
    
}
