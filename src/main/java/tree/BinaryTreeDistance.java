package tree;

import util.TreeNode;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * http://www.geeksforgeeks.org/find-distance-two-given-nodes/
 * Find distance between two given keys of a binary tree
 * The distance between two nodes can be obtained in terms of lowest common ancestor.
 * Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)
 */ 

public class BinaryTreeDistance {
    public int getDistance(TreeNode root, TreeNode n1, TreeNode n2) {
        TreeNode lca = getLCA(root, n1, n2);
        return getDistance(root, n1, 0) + getDistance(root, n2, 0) 
                - 2*getDistance(root, lca, 0);
    }
    
    private TreeNode getLCA(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) return null;
        if (root == n1 || root == n2) return root;
        TreeNode ln = getLCA(root.left, n1, n2),
                 rn = getLCA(root.right, n1, n2);
        if (ln != null && rn != null) return root;
        return rn == null ? ln : rn;
    }
    
    private int getDistance(TreeNode root, TreeNode n, int dist) {
        if (root == n) return dist;
        if (root == null) return -1;
        int ld = getDistance(root.left, n, dist + 1),
            rd = getDistance(root.right, n, dist + 1);
        return Math.max(ld, rd);
    }
    
    public static void main(String[] args) {
        TreeNode node_1 = new TreeNode(1),
                 node_2 = new TreeNode(2),
                 node_3 = new TreeNode(3),
                 node_4 = new TreeNode(4),
                 node_5 = new TreeNode(5),
                 node_6 = new TreeNode(6),
                 node_7 = new TreeNode(7),
                 node_8 = new TreeNode(8);
        node_1.left = node_2; node_1.right = node_3;
        node_2.left = node_4; node_2.right = node_5;
        node_3.left = node_6; node_3.right = node_7;
                              node_6.right = node_8;
                              
        BinaryTreeDistance btd = new BinaryTreeDistance();
        System.out.println(btd.getDistance(node_1, node_4, node_5)); // 2
        System.out.println(btd.getDistance(node_1, node_4, node_6)); // 4
        System.out.println(btd.getDistance(node_1, node_3, node_4)); // 3
        System.out.println(btd.getDistance(node_1, node_2, node_4)); // 1
        System.out.println(btd.getDistance(node_1, node_8, node_5)); // 5
    }
}
