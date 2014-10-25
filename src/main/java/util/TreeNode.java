package util;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public TreeNode(int x) { val = x; left = null; right = null; parent = null; }
    
	static public void printTree(TreeNode root) {
		StringBuilder bs = new StringBuilder();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.remove();
			if (node != null) {
				bs.append(node.val + " ");
				if (node.left != null || node.right != null) {
					q.add(node.left);
					q.add(node.right);
				}
			} else {
				bs.append('#');
			}
		}
		System.out.println(bs.toString());
	}
}
