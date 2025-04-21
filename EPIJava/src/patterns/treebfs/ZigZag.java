package patterns.treebfs;

import java.util.*;

/*
 * Given a binary tree, populate an array to represent its zigzag level order traversal.
 *  You should populate the values of all nodes of the first level from left to right, 
 * then right to left for the next level and keep alternating in the same manner for the following levels.
 *       12
 *    7       1
 * 9      10     5
 */
public class ZigZag {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> getZigZag(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();// [12,7,1,9,null, 10,5,null, null, 20, 17]
        // 7,1
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int levelSize = q.size();// 2,
            List<Integer> levelNodes = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = q.poll();
                if (level % 2 == 0) {
                    levelNodes.add(currNode.val);// [12],
                } else {
                    levelNodes.add(0, currNode.val);
                }
                if (currNode.left != null) {
                    q.offer(currNode.left);
                }
                if (currNode.right != null) {
                    q.offer(currNode.right);
                }
            }
            res.add(levelNodes);
            level++;
        }
        return res;

    }

}
