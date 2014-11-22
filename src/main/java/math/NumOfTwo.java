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
        //  -2 -> n/10   + (n > 2) ?    
        //  2- -> n/100  + (n > 20) ?
        // 2-- -> n/1000 + (n > 200) ?
        int count = 0;
        while (n >= 10) {
            count += n/10;
            count += n%10 >= 2 ? 1 : 0;
            n /= 10;
        }
        count += n%10 >= 2 ? 1 : 0;
        return count;
    }
    
    public static void main(String[] args) {
        NumOfTwo sol = new NumOfTwo();
        System.out.println(sol.getNumOfTwos(25));
    }
}
