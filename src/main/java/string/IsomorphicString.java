package string;

import java.util.HashMap;

/**
 * 
 * @author raychen
 * Problem:
 * Given two (dictionary) words as Strings, determine if they are isomorphic.
 * Two words are called isomorphic if the letters in one word can be remapped 
 * to get the second word.
 * 
 * Remapping a letter means replacing all occurrences of it with another letter 
 * while the ordering of the letters remains unchanged.
 * No two letters may map to the same letter, but a letter may map to itself.
 * 
 * Example:
 * given "foo", "app"; returns true we can map f -> a and o->p
 * given "bar", "foo"; returns false we can't map both 'a' and 'r' to 'o'
 * given "ab", "ca"; returns true we can map 'a' -> 'c' and 'b' -> 'a'
 */

public class IsomorphicString {
    public boolean isIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        HashMap<Character, Character> map1 = new HashMap<Character, Character>(),
                                      map2 = new HashMap<Character, Character>();
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i),
                 c2 = str2.charAt(i);
            if (map1.containsKey(c1))
                if (map1.get(c1) != c2)
                    return false;
            if (map2.containsKey(c2))
                if (map2.get(c2) != c1)
                    return false;
            map1.put(c1, c2);
            map2.put(c2, c1);
        }
        return true;
    }
    
    public static void main(String[] args) {
        IsomorphicString sol = new IsomorphicString();
        System.out.println(sol.isIsomorphic("foo", "app"));
        System.out.println(sol.isIsomorphic("bar", "foo"));
        System.out.println(sol.isIsomorphic("ab",  "ca"));
    }
}
