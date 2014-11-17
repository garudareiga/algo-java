package util;

public class TreeUtil {
    public static TreeNode createBSTTree_1() {
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
         return node_1;
    }
}
