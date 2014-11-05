package math;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class IntegerDivisionTest {

	@Test
	public void test() {
		IntegerDivision sol = new IntegerDivision();
		List<List<Integer>> result = sol.find(24);
		for (List<Integer> lt : result) {
			for (Integer v : lt) 
				System.out.print(v + " ");
			System.out.println();
		}
	}

}
