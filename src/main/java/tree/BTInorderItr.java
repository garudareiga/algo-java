package tree;

import java.util.EmptyStackException;
import java.util.Stack;

import util.TreeNode;
import util.TreeUtil;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Binary Tree In-order Iterator
 */ 

public class BTInorderItr {
    TreeNode root;
    Stack<TreeNode> stack = new Stack<TreeNode>();

    public BTInorderItr(TreeNode root) {
        this.root = root;
        traverse(root);
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public int next() {
        if (!hasNext())
            throw new EmptyStackException();
        TreeNode n = stack.pop();
        int r = n.val;
        traverse(n.right);
        return r;
    }
    
    private void traverse(TreeNode n) {
        while (n != null) {
            stack.push(n);
            n = n.left;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = TreeUtil.createBSTTree_1();
        BTInorderItr iter = new BTInorderItr(root);
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}
