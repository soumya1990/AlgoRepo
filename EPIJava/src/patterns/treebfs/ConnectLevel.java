package patterns.treebfs;

import java.util.*;
/*
 * Given a root of the binary tree, connect each node with its level order successor. 
 * The last node of each level should point to a null node.
 */

public class ConnectLevel {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;
    }

    public TreeNode connectLevels(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            TreeNode currNode = null;
            for (int i = 0; i < levelSize; i++) {
                if (currNode == null) {
                    currNode = q.poll();
                } else {
                    TreeNode node = q.poll();
                    currNode.next = node;
                    currNode = node;
                }
                if (currNode.left != null) {
                    q.offer(currNode.left);
                }
                if (currNode.right != null) {
                    q.offer(currNode.right);
                }

            }
            currNode.next = null;

        }
        return root;

    }
}
