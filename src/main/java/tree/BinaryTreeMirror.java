package tree;

import util.*;
import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * 
 * Mirror of a binary tree
 *          1                    1
 *         / \                  / \
 *        2   3                3   2 
 *       / \                      / \  
 *      4   5                    5   4
 *     / \                          / \ 
 *    6   7                        7   6 
 */

public class BinaryTreeMirror {
    public void mirror(TreeNode root) {
        if (root == null) return;
        mirrorIterative(root);
    }
    
    public void mirrorRecursive(TreeNode root) {
        if (root.left == null && root.right == null) return;
        TreeNode left = root.left, right = root.right;
        root.left = right; 
        root.right = left;
        mirror(left);
        mirror(right);
    }
    
    public void mirrorIterative(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            TreeNode l = stack.pop();
            TreeNode r = stack.pop();
            n.left = l;
            n.right = r;
            if (l != null) {
                stack.push(l.left); stack.push(l.right); stack.push(l);
            }
            if (r != null) {
                stack.push(r.left); stack.push(r.right); stack.push(r);
            }
        }
    }
}
