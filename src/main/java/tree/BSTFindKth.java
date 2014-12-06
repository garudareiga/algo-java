package tree;

import util.TreeNode;
import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * 
 * Find the Kth element in a binary search tree
 * 
 */

public class BSTFindKth {
	public int findKth(TreeNode root, int K) {
		int index = 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p.left);
				p = p.left;
			} else {
				p = stack.pop();
				if (++index == K) return p.val;
			}
		}
		return 0;
	}
}
