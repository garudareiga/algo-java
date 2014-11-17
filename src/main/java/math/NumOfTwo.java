package math;

/**
 * 
 * @author raychen
 * Problem:
 * http://www.careercup.com/question?id=56794
 * Count number of 2's in a given range [0, n]
 */ 

public class NumOfTwo {
    public int getNumOfTwos(int n) {
        //   2 ->     n*(1/10)
        //  2- ->   n*(10/100)
        // 2-- -> n*(100/1000)
        return 0;
    }
    
    public static void main(String[] args) {
        NumOfTwo sol = new NumOfTwo();
        // Shall be 9
        System.out.println(sol.getNumOfTwos(25));
    }
}
