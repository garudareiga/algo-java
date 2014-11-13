package tree;

import java.util.Stack;

import util.TreeNode;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given a binary tree, convert it to a doubly linked list.
 */

public class ConvertBT2DoublyLinkedList {

    TreeNode convertIterative(TreeNode root) {
        if (root == null) return null;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        TreeNode head = TreeNode.getMinTreeNode(root);
        TreeNode prev = TreeNode.getMaxTreeNode(root);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            if (n.right != null) stack.push(n.right);
            if (n.left != null) stack.push(n.left);
            prev.right = n;
            n.left = prev;
            prev = n;
        }
        return head;
    }
}
