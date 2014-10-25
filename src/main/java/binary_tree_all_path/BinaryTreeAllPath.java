package binary_tree_all_path;

import java.util.*;
import util.TreeNode;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * 
 * Collect all root-to-leaf paths in the binary tree recursively and iteratively
 *      10
 *    /    \
 *   8      2
 *  / \    /
 * 3   5  2
 * 
 * Result:
 * 	[
 *   [10, 8, 3],
 *   [10, 8, 5],
 *   [10, 2, 2]
 *  ]
 * 
 * http://www.geeksforgeeks.org/given-a-binary-tree-print-all-root-to-leaf-paths/
 * http://www.geeksforgeeks.org/print-ancestors-of-a-given-binary-tree-node-without-recursion/
 */

public class BinaryTreeAllPath {
	public List<List<Integer>> allPath(TreeNode root) {
		/*
		 * Time complexity: O(log(n))
		 * Space complexity: O(1)
		 */
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) return result;
		//allPathRecursive(root, result);
		allPathIterative(root, result);
		return result;
	}
	
	void allPathRecursive(TreeNode root, List<List<Integer>> result) {
		Stack<Integer> stack = new Stack<Integer>();
		all_path_recursive(root, stack, result);
	}
	
	void all_path_recursive(TreeNode root, Stack<Integer> stack, List<List<Integer>> result) {
		if (root.left == null && root.right == null) {
			ArrayList<Integer> list = new ArrayList<Integer>(stack);
			list.add(root.val);
			result.add(list);
			return;
		}
		stack.push(root.val);
		if (root.left != null)
			all_path_recursive(root.left, stack, result);
		if (root.right != null)
			all_path_recursive(root.right, stack, result);
		stack.pop();
	}
	
	void allPathIterative(TreeNode root, List<List<Integer>> result) {
		Stack<Integer> stack = new Stack<Integer>();
		Stack<TreeNode> keep = new Stack<TreeNode>();
		TreeNode p = root, q = null;
		do {
			// go as deep as possible
			while (p.left != null && p.right != null) {
				keep.push(p);
				stack.push(p.val);
				q = p;
				if (p.left != null) p = p.left;
				else p = p.right;
			}
			
			ArrayList<Integer> list = new ArrayList<Integer>(stack);
			list.add(p.val);
			result.add(list);
			System.out.println(list);
			
			while (!keep.isEmpty()) {
				q = p;
				p = keep.peek();
				if (p.right != null && p.right != q) {
					p = p.right;
					break;
				} else {
					keep.pop();
					stack.pop();
				}
			}
		} while (!keep.isEmpty());
	}
}
