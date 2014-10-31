package tree;

import util.TreeNode;

/*
 * Check if a small binary tree is subtree of another big binary tree
 */

public class BinarySubtree {
    /*
     * root1 is the bigger tree
     * root2 is the smaller tree
     */
    boolean isSubtree(TreeNode root1, TreeNode root2) {
        /*
         * Runtime complexity: O(n^2)
         */
        if (root1 == null || root2 == null) return false;
        if ((root1.val == root2.val) && TreeNode.isSameTree(root1, root2)) return true;
        return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }

    boolean isSubtreeFast(TreeNode root1, TreeNode root2) {
        /*
         * Runtime complexity: O(n)
         * 1. inorder and preorder traversal: O(n)
         * 2. check if substring using KMP: O(n)
         */
        String inorderStr1 = TreeNode.inorderString(root1);
        String inorderStr2 = TreeNode.inorderString(root2);
        String preorderStr1 = TreeNode.preorderString(root1);
        String preorderStr2 = TreeNode.preorderString(root2);
        return inorderStr1.contains(inorderStr2) && preorderStr1.contains(preorderStr2);
    }
    

}
