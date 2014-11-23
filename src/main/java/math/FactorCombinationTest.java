package math;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class FactorCombinationTest {

	@Test
	public void test() {
		FactorCombination sol = new FactorCombination();
		List<List<Integer>> result = sol.combination(24);
		for (List<Integer> lt : result) {
			for (Integer v : lt) 
				System.out.print(v + " ");
			System.out.println();
		}
		assertEquals(6, result.size());
	}

}
