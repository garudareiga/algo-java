package string;

import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given a list of words, write a method that takes two words 
 * and returns the shortest distance between those two words.
 * Example:
 * Given list of words : {"the", "quick", "brown", "fox", "quick"}
 * distance("fox","the") == 3
 * distance("quick", "fox") == 1.
 */ 

public class WordDistance {
    final List<String> words;
    
    public WordDistance(List<String> words) {
        this.words = words;
    }
    
    int distance(String word1, String word2) {
        int first = -1, dist = Integer.MAX_VALUE;
        for (int i = 0; i < words.size(); i++) {
            String curr = words.get(i);
            if (curr.equals(word1) || curr.equals(word2)) {
                if (first == -1 || words.get(first).equals(curr)) {
                    first = i;
                } else if (first >= 0 && !words.get(first).equals(curr)) {
                    dist = Math.min(dist, i - first);
                    first = i;
                }
            }
        }
        return dist;
    }
    
    public static void main(String[] args) {
        List<String> words = new ArrayList<String>();
        words.add("the");
        words.add("quick");
        words.add("brown");
        words.add("fox");
        words.add("quick");
        
        WordDistance sol = new WordDistance(words);
        System.out.println(sol.distance("fox", "the")); // 3
        System.out.println(sol.distance("quick", "fox")); // 1
    }
}
