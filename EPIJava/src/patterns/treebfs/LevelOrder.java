package patterns.treebfs;
import java.util.*;
/*
 * Given a binary tree, populate an array to represent its level-by-level traversal. 
 * You should populate the values of all nodes of each level from left to right in separate sub-arrays.
 */
public class LevelOrder {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> levelOeder(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> l = new LinkedList<>();
            Queue<TreeNode> nq = new LinkedList<>();
            while (q.peek() != null) {
                TreeNode n = q.poll();
                l.add(n.val);
                if (n.left != null) {
                    nq.add(n.left);
                }
                if (n.right != null) {
                    nq.add(n.right);
                }
            }
            res.add(l);
            q = nq;
        }
        return res;
    }
    
}
