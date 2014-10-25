package binary_tree_inorder_successor;

import static org.junit.Assert.*;

import org.junit.Test;
import util.TreeNode;

public class BinaryTreeInorderSuccessorTest {

	@Test
	public void test() {
		TreeNode node_1 = new TreeNode(20),
				 node_2 = new TreeNode(8),
				 node_3 = new TreeNode(22),
				 node_4 = new TreeNode(4),
				 node_5 = new TreeNode(12),
				 node_6 = new TreeNode(10),
				 node_7 = new TreeNode(14);
		node_1.left = node_2;
		node_1.right = node_3;
		node_2.parent = node_1;
		node_3.parent = node_1;
		
		node_2.left = node_4;
		node_2.right = node_5;
		node_4.parent = node_2;
		node_5.parent = node_2;
		
		node_5.left = node_6;
		node_5.right = node_7;
		node_6.parent = node_5;
		node_7.parent = node_5;
		
		TreeNode.printTree(node_1);
		
		BinaryTreeInorderSuccessor sol = new BinaryTreeInorderSuccessor();
		assertEquals(10, sol.nextValue(node_1, 8));
		assertEquals(12, sol.nextValue(node_1, 10));
		assertEquals(20, sol.nextValue(node_1, 14));
	}

}
