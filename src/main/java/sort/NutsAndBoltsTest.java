package sort;

import org.junit.Test;

import sort.NutsAndBolts.*;

public class NutsAndBoltsTest {

	@Test
	public void test() {
		Nut[] nuts = {
			new Nut(2),
			new Nut(4),
			new Nut(1),
			new Nut(5),
			new Nut(3),
		};
		
		Bolt[] bolts = {
			new Bolt(1),
			new Bolt(3),
			new Bolt(5),
			new Bolt(4),
			new Bolt(2),
		};
		
		NutsAndBolts sol = new NutsAndBolts();
		System.out.print("Nuts: ");
		for (Nut n : nuts) System.out.print(n.size + " ");
		System.out.println();
		System.out.print("Bolts: ");
		for (Bolt b : bolts) System.out.print(b.size + " ");
		System.out.println();
		
		sol.match(nuts, bolts);
		
		System.out.print("Nuts: ");
		for (Nut n : nuts) System.out.print(n.size + " ");
		System.out.println();
		System.out.print("Bolts: ");
		for (Bolt b : bolts) System.out.print(b.size + " ");
		System.out.println();
	}

}
