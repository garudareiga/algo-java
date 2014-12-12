package tree;

import java.util.*;
import util.LowerCaseTrie;

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
		LowerCaseTrie trie = new LowerCaseTrie();
		for (int i = 0; i < words.length; i++)
			trie.put(words[i], i);
		
		HashMap<String, String> minPrefix = new HashMap<String, String>();
		for (String word : words) {
			String prefix = trie.minPrefix(word);
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
