package matrix;

import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in diagonal order.
 * 
 * For example,
 * Given the following matrix:

	[
	 [ 1,  2,  3 ],
	 [ 4,  5,  6 ],
	 [ 7,  8,  9 ],
	 [10, 11, 12 ]
	]
 * You should return [1,2,4,3,5,7,6,8,10,9,11,12].
 * 
 * http://www.geeksforgeeks.org/print-matrix-diagonally/
 * The diagonal printing of matrix[ROW][COL] always has ROW + COL - 1 lines in output.
 */

public class DiagonalMatrix {
    public List<Integer> diagonalOrder(int[][] matrix) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if (matrix.length == 0 || matrix[0].length == 0) return result;
    	int r = 0, c = 0, numr = matrix.length, numc = matrix[0].length;
    	while (!(r == numr - 1 && c == numc - 1)) {
    		int tr = r, tc = c;
    		while (tr <= numr - 1 && tc >= 0)
    			result.add(matrix[tr++][tc--]);
    		if (c < numc - 1) c++;
    		else r++;
    	} 
    	result.add(matrix[r][c]);
    	return result;
    }
    
    public void diagonalOrder_2(int[][] matrix) {
        /*
         * Print
         * 1,
         * 4, 2
         * 7, 5, 3
         * 10, 8, 6
         * 11, 9
         * 12
         */
        int numr = matrix.length, numc = matrix[0].length;
        for (int i = 0; i < numr + numc - 1; i++) {
            // row + col => i
           int col = i >= numr ? i - numr + 1 : 0,
               row = i - col;
           while (row >=0 && col < numc) 
               System.out.print(matrix[row--][col++] + " ");
           System.out.println();
        }
    }
    
    public void diagonalZigZag(int[][] matrix) {
        int nrow = matrix.length, ncol = matrix[0].length;
        for (int k = 0; k < nrow + ncol - 1; k++) {
            int sr = k < ncol ? 0 : k%ncol + 1,
                sc = k - sr;
            ArrayList<Integer> array = new ArrayList<Integer>();
            while (sr < nrow && sc >= 0)
                array.add(matrix[sr++][sc--]);
            if (k % 2 == 1) Collections.reverse(array);
            System.out.println(array.toString());
        }
    }
}
