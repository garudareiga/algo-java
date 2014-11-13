package tree;

import util.TreeNode;

/**
 * 
 * @author raychen
 * Problem:
 * http://leetcode.com/2010/11/largest-binary-search-tree-bst-in_22.html
 * 
 * Given a binary tree, find the largest BST, where
 * largest means subtree with largest number of nodes in it.
 * 
 * Note: BST may or may not include all its descendants
 */ 

public class LargestBST {
    private int maxNum = 1;
    
    public int largestBSTSubtree(TreeNode root) {
       largestBSTSubtree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
       return maxNum;
    }

    private int largestBSTSubtree(TreeNode root, int minValue, int maxValue) {
        if (root == null) return 0;
        int ln = largestBSTSubtree(root.left, minValue, root.val),
            rn = largestBSTSubtree(root.right, root.val, maxValue);
        if (root.val < minValue || root.val > maxValue) return 0;
        int currNum = ln + rn + 1;
        maxNum = Math.max(maxNum, currNum);
        return currNum;
    }
    
    public static void main(String[] args) {
        TreeNode node_1 = new TreeNode(15),
                node_2 = new TreeNode(10),
                node_3 = new TreeNode(20),
                node_4 = new TreeNode(5),
                node_5 = new TreeNode(7),
                node_6 = new TreeNode(2),
                node_7 = new TreeNode(5),
                node_8 = new TreeNode(0),
                node_9 = new TreeNode(8),
                node_10 = new TreeNode(3);
        node_1.left = node_2;
        node_1.right = node_3;
        node_2.left = node_4;
        node_2.right = node_5;
        node_5.left = node_6;
        node_5.right = node_7;
        node_6.left = node_8;
        node_6.right = node_9;
        node_7.left = node_10;
        
        LargestBST sol = new LargestBST();
        // shall be 4
        System.out.println(sol.largestBSTSubtree(node_1));
    }
}
