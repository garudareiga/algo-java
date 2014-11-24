package tree;

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
	    /*
	     * Without parent node
	     */
		if (root == null) return root;
		if (root.val == p.val || root.val == q.val) return root;
		TreeNode ln = ancestorBottomUp(root.left, p, q);
		TreeNode rn = ancestorBottomUp(root.right, p, q);
		if (ln != null && rn != null) return root;
		return ln == null ? rn : ln;
	}
	
	   public TreeNode ancestorBottomUpWithParent(TreeNode root, TreeNode p, TreeNode q) {
	        /*
	         * With parent node
	         */
	       int cp = 0, cq = 0;
	       TreeNode n;
	       n = p;
	       while (n != null) { cp++; n = n.parent; }
	       n = q;
	       while (n != null) { cq++; n = n.parent; }
	       if (cp < cq) { n = p; p = q; q = n; }
	       for (int i = 0; i < Math.abs(cp - cq); i++)
	           p = p.parent;
	       while (p.val != q.val) { p = p.parent; q = q.parent; }
	       return p;
	    }
}
