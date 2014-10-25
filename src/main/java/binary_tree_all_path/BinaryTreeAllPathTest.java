package binary_tree_all_path;

import static org.junit.Assert.*;

import org.junit.Test;

import util.TreeNode;

import java.util.*;

public class BinaryTreeAllPathTest {

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
		
		node_2.left = node_4;
		node_2.right = node_5;
		
		node_5.left = node_6;
		node_5.right = node_7;
		
		TreeNode.printTree(node_1);
		
		BinaryTreeAllPath sol = new BinaryTreeAllPath();
		List<List<Integer>> result = sol.allPath(node_1);
		System.out.println("All paths:");
		for (List<Integer> r : result) {
			for (Integer v : r) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
		assertEquals(4, result.size());
	}

}
