package patterns.treebfs;

import java.util.*;

/*Given a root of the binary tree, connect each node with its level order successor. 
The last node of each level should point to the first node of the next level.


 * 
 */
public class ConnectAllLevels {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;
    }

    public TreeNode connectAll(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            TreeNode prev = null;
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }
        return root;
    }

}
