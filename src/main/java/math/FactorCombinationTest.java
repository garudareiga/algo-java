package math;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class FactorCombinationTest {

	@Test
	public void test1() {
		FactorCombination sol = new FactorCombination();
		List<List<Integer>> result = sol.combination(24);
		for (List<Integer> lt : result)
			System.out.println(lt.toString());
		assertEquals(6, result.size());
	}

	@Test
    public void test2() {
        FactorCombination sol = new FactorCombination();
        List<List<Integer>> result = sol.combination(64);
        for (List<Integer> lt : result)
            System.out.println(lt.toString());
        assertEquals(10, result.size());
    }

}
