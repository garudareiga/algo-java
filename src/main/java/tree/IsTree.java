package tree;

import util.TreeNode;
import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given a list of nodes with getParent() method, verify
 * these nodes form a tree or not.
 * 
 * Traverse to root from any node
 * - visited: store nodes on the traversal
 * - treenodes: store nodes considered as tree nodes
 */  

public class IsTree {
    boolean isTree(List<TreeNode> nodes) {
        HashSet<TreeNode> visited = new HashSet<TreeNode>(),
                          treenodes = new HashSet<TreeNode>();
        for (TreeNode node : nodes) {
            if (treenodes.contains(node)) continue;            
            while (node != null) {
                if (visited.contains(node)) // loop ?
                    return false;
                visited.add(node);
                node = node.parent;
            }
            if (!treenodes.isEmpty() && node == null) // different root
                return false;
            treenodes.addAll(visited);
            visited.clear();
        }
        return true;
    }
}
