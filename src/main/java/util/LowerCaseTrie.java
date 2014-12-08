package util;

import java.util.Arrays;

public class LowerCaseTrie {
	public static class TrieNode {
		private TrieNode[] children = new TrieNode[26];
		private boolean leaf;
		private int wordCount;
		
		public TrieNode() {
			Arrays.fill(children, null);
			leaf = false;
			wordCount = 0;
		}
	}
	
	public static void insertString(TrieNode root, String s) {
		insertString(root, s, 0);
	}
	
	public static String minPrefix(TrieNode root, String s) {
		return s.isEmpty() ? "" : minPrefix(root, s, 0);
	}
	
	public static String longestPrefix(TrieNode root, String s) {
		StringBuilder sb = new StringBuilder();
		if (!s.isEmpty())
			longestPrefix(root, s, 0, sb);
		return sb.toString();
	}
	
	private static void insertString(TrieNode root, String s, int p) {
		if (s.isEmpty()) return;
		if (p == s.length()) { root.leaf = true; return; }
		int index = s.charAt(p) - 'a';
		if (root.children[index] == null)
			root.children[index] = new TrieNode(); 
		TrieNode node = root.children[index];
		node.wordCount++;
		insertString(node, s, p + 1);
	}
	
	private static String minPrefix(TrieNode root, String s, int p) {
		if (p == s.length() || root.wordCount == 1 || root.leaf) return "";
		int index = s.charAt(p) - 'a';
		TrieNode node = root.children[index];
		if (node == null) return "";
		else return s.charAt(p) + minPrefix(node, s, p + 1);
	}
	
	private static void longestPrefix(TrieNode root, String s, int p, StringBuilder sb) {
		if (root.leaf) return;
		if (s.length() == p) sb.setLength(0);
		else {
			int index = s.charAt(p) - 'a';
			TrieNode node = root.children[index];
			if (node == null) sb.setLength(0);
			else {
				sb.append(s.charAt(p));
				longestPrefix(node, s, p + 1, sb);
			}
		}
	}
}
