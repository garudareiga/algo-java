package array;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given a sorted array of unique elements R, that are letters of English alphabet 
 * and an input character x. The elements in R are sorted with the least element 
 * appearing first. Find the minimum r in R such that r > x. If there is no r > x, 
 * find the first element of the array (wrap around).
 * 
 * e.g. R = ['c', 'f', 'j', 'p', 'v']
 * if x equals:
 * 'a' => return 'c'
 * 'c' => return 'f'
 * 'k' => return 'p'
 * 'z' => return 'c' (wrap around case)
 * 
 */ 
        
public class FirstLargerCharacter {
    public char getCharacter(char[] R, char x) {
        int len = R.length;
        int index = getRigthMostInsertion(R, x);
        return R[index%R.length];
//        int index = getCharacter(R, 0, len - 1, x);
//        if (index == -1) return R[0];
//        else return R[index];
    }
    
    private int getRigthMostInsertion(char[] R, char x) {
		int l = 0, r = R.length - 1;
		while (l <= r) {
			int m = (l + r)/2;
			if (x >= R[m]) l = m + 1;
			else r = m - 1;
		}
		return l;
	}

	public int getCharacter(char[] R, int lo, int hi, char x) {
        if (lo > hi) return -1; // not exist, return index -1
        int m = (lo + hi)/2;
        if (x < R[m]) { // the element is in the right side including R[m]
            int index = getCharacter(R, lo, m - 1, x);
            if (index == -1) return m;
            else return index;
        } else {
            return getCharacter(R, m + 1, hi, x); // not including R[m]
        }
    }
    
    public static void main(String[] args) {
        char[] R = {'c', 'f', 'j', 'p', 'v'};
        FirstLargerCharacter sol = new FirstLargerCharacter();
        System.out.println(sol.getCharacter(R, 'a'));
        System.out.println(sol.getCharacter(R, 'c'));
        System.out.println(sol.getCharacter(R, 'k'));
        System.out.println(sol.getCharacter(R, 'z'));
    }
}





