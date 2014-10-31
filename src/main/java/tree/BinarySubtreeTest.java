package tree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import util.TreeNode;

public class BinarySubtreeTest {
    TreeNode root1 = null, root2 = null;
    BinarySubtree sol = null;

    @Before
    public void setUp() throws Exception {
        // Small Tree
        TreeNode node_11 = new TreeNode(10),
                node_12 = new TreeNode(4),
                node_13 = new TreeNode(6),
                node_14 = new TreeNode(30);
        node_11.left = node_12;
        node_11.right = node_13;
        node_12.right = node_14;
        root2 = node_11;
        // Large Tree
        TreeNode node_21 = new TreeNode(26),
                node_22 = new TreeNode(10),
                node_23 = new TreeNode(3),
                node_24 = new TreeNode(4),
                node_25 = new TreeNode(6),
                node_26 = new TreeNode(3),
                node_27 = new TreeNode(30);
        node_21.left = node_22;
        node_21.right = node_23;
        node_22.left = node_24;
        node_22.right = node_25;
        node_24.right = node_27;
        node_23.right = node_26;
        root1 = node_21;
        
        sol = new BinarySubtree();
    }

    @Test
    public void test1() {
        assertEquals(true, sol.isSubtree(root1, root2));
    }
    
    @Test
    public void test2() {
        assertEquals(true, sol.isSubtreeFast(root1, root2));
    }

}
