package string;

import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function 
 * search(char pat[], char txt[]) that prints all occurrences of pat[] 
 * and its permutations (or anagrams) in txt[]. You may assume that n > m. 
 * Expected time complexity is O(n)
 * 
 * Examples:
 * 1) Input: txt[] = "BACDGABCDA" pat[] = "ABCD"
   Output:   Found at Index 0
             Found at Index 5
             Found at Index 6
   2) Input: txt[] =  "AAABABAA"  pat[] = "AABA"
   Output:   Found at Index 0
             Found at Index 1
             Found at Index 4
 *            
 */            
             
public class AnagramSubstringSearch {
	List<Integer> search(String text, String pattern) {
		List<Integer> result = new ArrayList<Integer>();
		int[] patToFound = new int[256], patFound = new int[256];
		for (int i = 0; i < pattern.length(); i++) 
			patToFound[pattern.charAt(i)] += 1;
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			patFound[c] += 1;
			if (i >= pattern.length()) {
				char prev_c = text.charAt(i - pattern.length());
				patFound[prev_c] -= 1;
			}
			if (isMatch(patFound, patToFound))
				result.add(i - pattern.length() + 1);
		}
		return result;
	}
	
	private boolean isMatch(int[] patFound, int[] patToFound) {
		for (int i = 0; i < patFound.length; i++) 
			if (patFound[i] != patToFound[i])
				return false;
		return true;
	}

	public static void main(String[] args) {
		{
			String txt = "BACDGABCDA", pat = "ABCD";
			AnagramSubstringSearch sol = new AnagramSubstringSearch();
			List<Integer> result = sol.search(txt, pat);
			System.out.println(result.toString());
		}
		{
			String txt = "AAABABAA", pat = "AABA";
			AnagramSubstringSearch sol = new AnagramSubstringSearch();
			List<Integer> result = sol.search(txt, pat);
			System.out.println(result.toString());
		}
	}
}
