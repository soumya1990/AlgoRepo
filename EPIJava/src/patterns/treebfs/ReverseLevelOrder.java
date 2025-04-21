package patterns.treebfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., the lowest level comes first in left to right order.)
 * 
 * 
 */
public class ReverseLevelOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> getReverseLevelorder(TreeNode root) {

        if (root == null)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            LinkedList<Integer> levelNodes = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = q.poll();
                if (currNode.left != null) {
                    q.offer(currNode.left);
                }
                if (currNode.right != null) {
                    q.offer(currNode.right);
                }
                levelNodes.add(currNode.val);
            }
            res.add(0, levelNodes);
        }
        return res;
    }

}
