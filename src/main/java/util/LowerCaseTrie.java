package util;

import java.util.*;

public class LowerCaseTrie {
    private TrieNode root;
    
	public static class TrieNode {
		private TrieNode[] children = new TrieNode[26];
		//private boolean leaf;
		private int index;    // index of word in the dictionary
		private int wordCount;
		
		public TrieNode() {
			Arrays.fill(children, null);
			//leaf = false;
			index = -1;
			wordCount = 0;
		}
	}
	
	public int getIndex(String s) {
	    TrieNode tn = get(root, s, 0);
	    if (tn == null) return -1;
	    return tn.index;
	}
	
	public void put(String s, int index) {
	    root = put(root, s, index, 0);
	}

	public List<String> wordsWithPrefix(String prefix) {
	    List<String> result = new LinkedList<String>();
	    TrieNode tn = get(root, prefix, 0);
	    collect(tn, new StringBuilder(prefix), result);
	    return result;
	}
	
	public String minPrefix(String s) {
	    return minPrefix(root, s, 0);
	}
	
	public String longestPrefix(String s) {
	    return longestPrefix(root, s, 0, 0);
	}
	
    public TrieNode get(TrieNode tn, String s, int d) {
        if (tn == null) return null;
        if (d == s.length()) return tn;
        char c = s.charAt(d);
        return get(tn.children[c - 'a'], s, d + 1);
    }
    
    public TrieNode put(TrieNode root, String s, int index, int d) {
        if (root == null) root = new TrieNode();
        root.wordCount += 1;
        if (d == s.length()) {
            root.index = index;
            return root;
        }
        char c = s.charAt(d);
        root.children[c - 'a'] = put(root.children[c - 'a'], s, index, d + 1);
        return root;
    }
    
    public void collect(TrieNode tn, StringBuilder prefix, List<String> result) {
        if (tn == null) return;
        if (tn.index != -1) result.add(prefix.toString());
        for (char c = 'a'; c <= 'z'; c++) {
            prefix.append(c);
            collect(tn.children[c - 'a'], prefix, result);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
    
    public String minPrefix(TrieNode tn, String s, int d) {
        if (tn == null) return null;
        if (d == s.length()) return s;
        if (tn.wordCount == 1) return s.substring(0, d);
        char c = s.charAt(d);
        return minPrefix(tn.children[c - 'a'], s, d + 1);
    }
    
    public String longestPrefix(TrieNode tn, String s, int d, int len) {
        if (tn == null || d == s.length()) return s.substring(0, len);
        if (tn.index != -1) len = d;
        char c = s.charAt(d);
        return longestPrefix(tn.children[c - 'a'], s, d + 1, len);
    }
}
