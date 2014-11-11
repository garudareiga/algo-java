package tree;

import util.TreeNode;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Delete a node from a binary search tree
 * 
 */ 

public class BSTDeleteNode {
    public TreeNode delete(TreeNode root, int value) {
        if (root == null) return root;
        if (root.val > value) root.left = delete(root.left, value);
        else if (root.val < value) root.right = delete(root.right, value);
        else {
            // find matching value
            if (root.left == null) { 
                TreeNode n = root.right;
                return n;
            } else if (root.right == null) {
                TreeNode n = root.left;
                return n;
            } else {
                // Get the inorder successor (find the minimum in the right tree)
                TreeNode n = TreeNode.getMinTreeNode(root.right);
                root.val = n.val;
                root.right = delete(root.right, n.val);
            }
        }
        return root;
    }
}
