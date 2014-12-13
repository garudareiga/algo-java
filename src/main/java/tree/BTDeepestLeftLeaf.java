package tree;

import util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Deepest left leaf node in a binary tree
 */

public class BTDeepestLeftLeaf {
    private int maxLevel;
    private int value;
    
    public int deepestLeftLeaf(TreeNode root) {
        deepestLeftLeaf(root, 0, false);
        return value;
    }
    
    public void deepestLeftLeaf(TreeNode root, int level, boolean isLeft) {
        if (root == null) return;
        if (root.left == null && root.right == null && isLeft && level > maxLevel)
            value = root.val;
        deepestLeftLeaf(root.left, level + 1, true);
        deepestLeftLeaf(root.right, level + 1, false);
    }
}
