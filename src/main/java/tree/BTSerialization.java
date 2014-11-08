package tree;

import java.io.*;
import java.util.*;

import util.TreeNode;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Binary Tree Serialization & Deserialization
 * http://leetcode.com/2010/09/serializationdeserialization-of-binary.html
 */ 

public class BTSerialization {
    public void serialize(TreeNode root, OutputStream os) throws IOException {
        Stack<TreeNode> q = new Stack<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.pop();
            if (n == null) os.write('$');
            else { os.write(n.val); q.push(n.right); q.push(n.left); }
        }
        os.close();
    }
    
    public TreeNode deserialize(InputStream is) throws IOException {
        TreeNode root = deserialize_(is);
        is.close();
        return root;
    }
    
    public TreeNode deserialize_(InputStream is) throws IOException {
        int value = is.read();
        if (value != '$') {
            TreeNode n = new TreeNode(value);
            n.left = deserialize_(is);
            n.right = deserialize_(is);
            return n;
        } else 
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
            
            BTSerialization bt = new BTSerialization();
        
            bt.serialize(root, pos);
            TreeNode newRoot = bt.deserialize(pis);
            
            TreeNode.printTree(newRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
