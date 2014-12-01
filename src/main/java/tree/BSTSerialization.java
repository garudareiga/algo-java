package tree;

import java.io.*;
import java.util.*;

import util.TreeNode;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Binary Search Tree Serialization & Deserialization
 * http://leetcode.com/2010/09/saving-binary-search-tree-to-file.html
 */ 

public class BSTSerialization {
    private int value;
    
    public void serialize(TreeNode root, OutputStream os) throws IOException {
        Stack<TreeNode> q = new Stack<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.pop();
            os.write(n.val);
            if (n.right != null) q.push(n.right);
            if (n.left != null) q.push(n.left);
        }
        os.close();
    }
    
    public TreeNode deserialize(InputStream is) throws IOException {
        this.value = is.read();
        TreeNode root = deserialize(is, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }
    
    public TreeNode deserialize(InputStream is, int min, int max) throws IOException {
        if (this.value > min && this.value < max) {
            TreeNode n = new TreeNode(this.value);
            /*
             * Tricky!!!
             * We need use this.value instead of passing value, cause we need track
             * value change when we traverse backwards. In other words, value is different
             * calling deserialize on left and right.
             */
            this.value = is.read();
            if (this.value != -1) { 
                n.left = deserialize(is, min, n.val);
                n.right = deserialize(is, n.val, max);
            } else 
                is.close();
            return n;
        }
        return null;
    }
    
    public static void main(String[] args) {
       /*    binary tree
        *           30                  
        *          /  \                
        *        20    40               
        *       /     /  \                   
        *     10     35  50                
        *                
        */                           
        TreeNode node_1 = new TreeNode(30),
                node_2 = new TreeNode(20),
                node_3 = new TreeNode(40),
                node_4 = new TreeNode(10),
                node_5 = new TreeNode(35),
                node_6 = new TreeNode(50);
        node_1.left = node_2;
        node_1.right = node_3;
        node_2.left = node_4;
        node_3.left = node_5;
        node_3.right = node_6;
        
        TreeNode root = node_1;
        try {
            TreeNode.printTree(root);
            
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
            
            BSTSerialization bst = new BSTSerialization();
        
            bst.serialize(root, pos);
            TreeNode newRoot = bst.deserialize(pis);
            
            TreeNode.printTree(newRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
