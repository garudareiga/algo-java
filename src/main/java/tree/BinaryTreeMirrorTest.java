package tree;

import org.junit.Test;

import util.TreeNode;

public class BinaryTreeMirrorTest {

    @Test
    public void test() {
        TreeNode node_1 = new TreeNode(1),
                node_2 = new TreeNode(2),
                node_3 = new TreeNode(3),
                node_4 = new TreeNode(4),
                node_5 = new TreeNode(5),
                node_6 = new TreeNode(6),
                node_7 = new TreeNode(7);
        node_1.left = node_2;
        node_1.right = node_3;
        node_2.left = node_4;
        node_2.right = node_5;
        node_4.left = node_6;
        node_4.right = node_7;
        
        System.out.println("Tree:");
        TreeNode.printTree(node_1);
        
        BinaryTreeMirror sol = new BinaryTreeMirror();
        sol.mirror(node_1);
        TreeNode.printTree(node_1);
    }

}
