package stream;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Find running average of a infinite stream of integers
 * 
 */

public class AverageOfIntegerStream {
    double average = 0;
    int count = 0;
    
    public double average(int value) {
    	average = (average*count + value)/(++count);
        return average;
    }
    
    public static void main(String[] args) {
        AverageOfIntegerStream sol = new AverageOfIntegerStream();
        int[] A = {10,20,30,40,50,60};
        for (int v : A) {
            System.out.println(String.format("Median of add %d: %.2f", v, sol.average(v)));
        }
    }
    
}
