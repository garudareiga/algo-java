package diagonal_matrix;

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
 */

public class DiagonalMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
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
}
