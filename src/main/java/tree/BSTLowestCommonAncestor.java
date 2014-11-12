package tree;

import util.TreeNode;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * 
 * Find the first common ancestor of two nodes in a binary *search* tree.
 * Avoid storing additional nodes in a data structure.
 * 
 * Allow a node to be a descendant of itself.
 */

public class BSTLowestCommonAncestor {
	public TreeNode ancestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) return null;
		if (Math.max(p.val, q.val) < root.val) return ancestor(root.left, p, q);
		else if (Math.min(p.val, q.val) > root.val) return ancestor(root.right, q, q);
		else return root;
	}
}
