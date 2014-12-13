package stream;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Select a random number from stream, with O(1) space
 * 
 */

public class RandomOfIntegerStream {
    double average = 0;
    int count = 0;
    
    public double average(int value) {
    	average = (average*count + value)/(++count);
        return average;
    }
    
    public static void main(String[] args) {
        RandomOfIntegerStream sol = new RandomOfIntegerStream();
        int[] A = {10,20,30,40,50,60};
        for (int v : A) {
            System.out.println(String.format("Median of add %d: %.2f", v, sol.average(v)));
        }
    }
    
}
