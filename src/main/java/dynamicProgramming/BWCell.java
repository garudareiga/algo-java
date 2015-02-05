package dynamicProgramming;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Having a pile of black and white chesses, arranged in a line.
 * We can not have more than two neighboring chesses with one color.
 * How many combinations we can have?
 */

public class BWCell {
	public int combinations(int numBlacks, int numWhites) {
		if (numBlacks != numWhites) return 0;
		int num = numBlacks + numWhites;
		int[] arrayB = new int[num + 1], arrayW = new int[num + 1];
		arrayB[0] = 1; arrayB[1] = 1;
		arrayW[0] = 1; arrayW[1] = 1;
		for (int i = 2; i <= num; i++) {
			arrayB[i] = arrayW[i - 1] + arrayW[i - 2];
			arrayW[i] = arrayB[i - 1] + arrayB[i - 2];
		}
	}
}
