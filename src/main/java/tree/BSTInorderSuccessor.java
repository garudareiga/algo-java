package tree;

import util.TreeNode;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * 
 * Inorder successor of a node is the next node in inorder traversal 
 * of the Binary Tree. Inorder Successor is NULL for the last node.
 * 
 * Given the root node and a target value, find the next value in the
 * binary tree. 
 * 1) Assume all tree node values are positive. 
 * 2) If the target value doesn't exist, or successor is NULL, return -1.
 * 3) Assume we have parent node 
 * 
 */

public class BSTInorderSuccessor {
	public int nextValue(TreeNode root, int target) {
		/*
		 * Time complexity: O(log(n))
		 * Space complexity: O(1)
		 */
		TreeNode curr = root;
		while (curr != null) {
			if (target == curr.val) break;
			if (target < curr.val) curr = curr.left;
			else curr = curr.right;
		}
		if (curr == null) return -1;
		//TreeNode next = inorderSuccessorUsingParent(root, curr);
		TreeNode next = inorderSuccessor(root, curr);
		return next == null ? -1 : next.val;
	}
	
	TreeNode inorderSuccessor(TreeNode root, TreeNode n) {
		// 1. The right child is not NULL
		if (n.right != null) return TreeNode.getMinTreeNode(n.right);
		// 2. The right child is NULL
		TreeNode parent = null;
		while (root != null) {
			if (n.val < root.val) {
				parent = root;
				root = root.left;
			} else if (n.val > root.val) {
				root = root.right;
			}
			else break;
		}
		return parent;
	}
	
	TreeNode inorderSuccessorUsingParent(TreeNode root, TreeNode n) {
		// 1. The right child is not NULL
		if (n.right != null) return TreeNode.getMinTreeNode(n.right);
		// 2. The right child is NULL
		TreeNode p = n.parent;
		while (p != null && p.right == n) {
			n = p;
			p = n.parent;
		}
		return p;
	}
}
