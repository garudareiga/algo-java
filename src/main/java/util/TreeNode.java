 package util;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public TreeNode(int x) { val = x; left = null; right = null; parent = null; }
    
	public static void printTree(TreeNode root) {
		StringBuilder bs = new StringBuilder();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.remove();
			if (node != null) {
				bs.append(node.val + " ");
				q.add(node.left);
				q.add(node.right);
			} else {
				bs.append("# ");
			}
		}
		System.out.println(bs.toString());
	}
	
	public static String inorderString(TreeNode root) {
	    StringBuilder sb = new StringBuilder();
	    inorderString(root, sb);
	    return sb.toString();
	}
	
	private static void inorderString(TreeNode root, StringBuilder sb) {
	    if (root == null) return;
	    inorderString(root.left, sb);
	    sb.append(root.val);
	    inorderString(root.right, sb);
	}
	
   public static String preorderString(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorderString(root, sb);
        return sb.toString();
    }
    
    private static void preorderString(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        preorderString(root.left, sb);        
        inorderString(root.right, sb);
    }
    
    public static boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return (root1.val == root2.val) && 
                isSameTree(root1.left, root2.left) &&
                isSameTree(root1.right, root2.right);
    }
    
    public static TreeNode getMinTreeNode(TreeNode root) {
        // Get the smallest in the tree
        if (root == null || root.left == null) return root;
        return getMinTreeNode(root.left);
    }
    
    public static TreeNode getMaxTreeNode(TreeNode root) {
        // Get the largest in the tree
        if (root == null || root.right == null) return root;
        return getMinTreeNode(root.right);
    }
}
