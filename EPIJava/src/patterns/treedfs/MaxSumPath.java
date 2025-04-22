package patterns.treedfs;

/*
 * Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum.

A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root. 
The path must contain at least one node.
 * 
 *      -1
 *   -3   
 *  
 *
 */
public class MaxSumPath {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private int maxSum = Integer.MIN_VALUE;

    public int maxPath(TreeNode root) {
        calmaxPath(root);
        return maxSum;
    }

    private int calmaxPath(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left_max = calmaxPath(root.left);
        int right_max = calmaxPath(root.right);
        maxSum = Math.max(maxSum, left_max + right_max + root.val);

        return Math.max(Math.max(left_max, right_max) + root.val, root.val < 0 ? 0 : root.val);

    }

}
