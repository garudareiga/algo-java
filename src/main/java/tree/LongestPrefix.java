package tree;

import util.LowerCaseTrie;
import util.LowerCaseTrie.TrieNode;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * http://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/
 * 
 * Given a dictionary of words and an input string, 
 * find the longest prefix of the string which is also a word in dictionary.
 * 
 * Examples:
   Let the dictionary contains the following words:
   {are, area, base, cat, cater, children, basement}

   Below are some input/output examples:
   --------------------------------------
   Input String            Output
   --------------------------------------
   caterer                 cater
   basemexy                base
   child                   <Empty>
 *
 */ 

public class LongestPrefix {
	public String longestPrefix(String input, String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) LowerCaseTrie.insertString(root, word);
		return LowerCaseTrie.longestPrefix(root, input);
	}
	
	public static void main(String[] args) {
		String[] words = {"are", "area", "base", "cat", "cater", "children", "basement"};
		LongestPrefix lp = new LongestPrefix();
		System.out.println("caterer -> " + lp.longestPrefix("caterer", words));
		System.out.println("basemexy -> " + lp.longestPrefix("basemexy", words));
		System.out.println("child -> " + lp.longestPrefix("child", words));
	}
}
