package tree;

import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Consider this string representation for binary trees. 
 * Each node is of the form (lr), where l represents the 
 * left child and r represents the right child. If l is 
 * the character 0, then there is no left child. 
 * Similarly, if r is the character 0, then there is no 
 * right child. Otherwise, the child can be a node of the 
 * form (lr), and the representation continues recursively.
 * For example: 
 * (00) is a tree that consists of one node. 
 * ((00)0) is a two-node tree in which the root has a left child, 
 *         and the left child is a leaf. 
 * ((00)(00)) is a three-node tree, with a root, a left and a right child.
 * Write a function that takes as input such a string, and returns -1 
 * if the string is malformed, and the depth of the tree if the string is well-formed.
 * 
 * For instance:
    find_depth('(00)') -> 0
    find_depth('((00)0)') -> 1
    find_depth('((00)(00))') -> 1
    find_depth('((00)(0(00)))') -> 2
    find_depth('((00)(0(0(00))))') -> 3
    find_depth('x') -> -1
    find_depth('0') -> -1
    find_depth('()') -> -1
    find_depth('(0)') -> -1
    find_depth('(00)x') -> -1
    find_depth('(0p)') -> -1
 *   
 */

public class BTDepth {
    public int depth(String str) {
        int numPar = 0, maxNum = 0;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') { 
                stack.push(c); 
                numPar++;
                maxNum = Math.max(maxNum, numPar);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '0') stack.pop();
                else return -1;
                if (!stack.isEmpty() && stack.peek() == '0') stack.pop();
                else return -1;    
                if (!stack.isEmpty() && stack.peek() == '(') {   
                    numPar--;
                    stack.pop();
                } else return -1;
                stack.push('0');
            } else if (c == '0') {
                stack.push('0');
            } else return -1;
        }
        return (stack.size() == 1 && stack.peek() == '0') ? maxNum - 1 : -1;
    }
    
    public static void main(String[] args) {
        BTDepth sol = new BTDepth();
        System.out.println(sol.depth("()"));
        System.out.println(sol.depth("(0)"));
        System.out.println(sol.depth("0"));
        System.out.println(sol.depth("((00)(0(00)))")); // 2
        System.out.println(sol.depth("((00)(0(0(00))))")); // 3
    }
}
