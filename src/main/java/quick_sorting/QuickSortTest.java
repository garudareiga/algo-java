package quick_sorting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {

	@Test
	public void test() {
		int A[] = {8, 5, 1, 2, 3, 4, 2, 5, 7};
		for (int v : A) System.out.print(v + " ");
		System.out.println();
		QuickSort sol = new QuickSort();
		sol.sort(A);
		for (int v : A) System.out.print(v + " ");
		System.out.println();
	}

}
