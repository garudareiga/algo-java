package tree;

import util.TreeNode;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given a binary tree, convert it to a doubly linked list.
 */

public class ConvertBT2DoublyLinkedList {
    TreeNode head = null, prev = null;

    public TreeNode convert(TreeNode root) {
        convertRecursive(root);
        return head;
    }
    
    void convertRecursive(TreeNode root) {
        if (root == null) return;
        convertRecursive(root.left);
        if (prev == null) head = root;
        else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        convertRecursive(root.right);
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
         ConvertBT2DoublyLinkedList sol = new ConvertBT2DoublyLinkedList();
         TreeNode head = sol.convert(root);
         while (head != null) {
             System.out.print(head.val + " ");
             head = head.right;
         }
    }
}
