package diagonal_matrix;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class DiagonalMatrixTest {

	@Test
	public void test() {
		int matrix[][] = {
			{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}
		};
		DiagonalMatrix sol = new DiagonalMatrix();
		List<Integer> result = sol.spiralOrder(matrix);
		System.out.println("1 2 4 3 5 7 6 8 10 9 11 12 ? =>");
		for (Integer n : result) System.out.print(n + " ");
		System.out.println();
		assertEquals(12, result.size());
	}

}
