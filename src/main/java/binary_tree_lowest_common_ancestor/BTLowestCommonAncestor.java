package binary_tree_lowest_common_ancestor;

import util.TreeNode;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * 
 * Find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure.
 * 
 */

public class BTLowestCommonAncestor {
	public TreeNode ancestorBottomUp(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return root;
		if (root.val == p.val || root.val == q.val) return root;
		TreeNode ln = ancestorBottomUp(root.left, p, q);
		TreeNode rn = ancestorBottomUp(root.right, p, q);
		if (ln != null && rn != null) return root;
		return ln == null ? rn : ln;
	}
}
