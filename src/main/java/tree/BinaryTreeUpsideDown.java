package tree;

import util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * 
 * Given a binary tree where all the right nodes are leaf nodes, flip it upside down.
 * and turn it into a tree with left leaf nodes.
 *          1                    1
 *         / \                  /
 *        2   3                2 - 3
 *       / \                  /
 *      4   5                4 - 5
 *     / \                  /
 *    6   7                6 - 7
 */

public class BinaryTreeUpsideDown {
    public TreeNode flip(TreeNode root) {
        if (root == null) return null;
        //return flipRecursive(root, null, null);
        return flipIterative(root);
    }
    
    public TreeNode flipRecursive(TreeNode curr, TreeNode left, TreeNode right) {
        if (curr == null) return right;
        TreeNode currLeft = curr.left,
                 currRight = curr.right;
        curr.left = left;
        curr.right = right;
        return flipRecursive(currLeft, currRight, curr);
    }
    
    public TreeNode flipIterative(TreeNode root) {
        TreeNode left = null, right = null;
        while (root != null) {
            TreeNode nextLeft = root.left, nextRight = root.right;
            root.left = left;
            root.right = right;          
            left = nextRight;
            right = root;
            root = nextLeft;
        }
        return right;
    }
}
