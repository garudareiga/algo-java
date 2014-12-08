package tree;

import java.util.*;
import util.LowerCaseTrie;
import util.LowerCaseTrie.TrieNode;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Use the shorest unique prefix to represent each word in the array
 * input: ["zebra", "dog", "duck"]
 * output: {zebra: z, dog: do, duck: du}
 * 
 * [zebra, dog, duck, dove]
 * {zebra:z, dog: dog, duck: du, dove: dov}
 * 
 * [bearcat, bear]
 * {bearcat: bearc, bear: ""}
 */ 

public class MinPrefix {
	HashMap<String, String> minPrefix(String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words)
			LowerCaseTrie.insertString(root, word);
		
		HashMap<String, String> minPrefix = new HashMap<String, String>();
		for (String word : words) {
			String prefix = LowerCaseTrie.minPrefix(root, word);
			minPrefix.put(word, prefix);
		}
		return minPrefix;
	}
	
	public static void main(String[] args) {
		MinPrefix mp = new MinPrefix();
		{
			String[] words = {"zebra", "dog", "duck"};
			HashMap<String, String> minPrefix = mp.minPrefix(words);
			for (Map.Entry<String, String> entry : minPrefix.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
		}
	}
}
