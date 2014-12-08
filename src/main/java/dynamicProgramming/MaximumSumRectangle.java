package dynamicProgramming;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=44
 * 
 * Kadane's 2D Algorithm
 * Good explanation here: convert 
 * http://ihaventyetdecided.blogspot.com/2010/10/kadanes-2d-algorithm.html
 */

public class MaximumSumRectangle {
    public int maxSum(int[][] A) {
        /*
         * Runtime Complexity: O(n^3)
         * Space Complexity: O(n^2)
         */
        int nrow = A.length, ncol = A[0].length;
        int[][] sumCols = new int[nrow][ncol];
        for (int r = 0; r < nrow; r++)
            for (int c = 0; c < ncol; c++)
                sumCols[r][c] = r == 0 ? A[r][c] : sumCols[r - 1][c] + A[r][c];
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nrow; i++) {
            for (int j = i; j < nrow; j++) {
                int[] rows = new int[ncol];
                for (int k = 0; k < ncol; k++)
                    rows[k] = sumCols[j][k] - (k == 0 ? 0 : sumCols[i][k]);
                int currMaxSum = Integer.MIN_VALUE;
                for (int k = 0; k < ncol; k++) {
                    rows[k] = Math.max(rows[k], (k == 0 ? 0 : rows[k - 1]) + rows[k]);
                    currMaxSum = Math.max(rows[k], currMaxSum);
                }
                maxSum = Math.max(maxSum, currMaxSum);
            }
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[][] A = {
            { 1, 2,-1,-4,-20},
            {-8,-3, 4, 2,  1},
            { 3, 8,10, 1,  3},
            {-4,-1, 1, 7, -6}
        };
        MaximumSumRectangle sol = new MaximumSumRectangle();
        System.out.println(sol.maxSum(A));
    }
}
