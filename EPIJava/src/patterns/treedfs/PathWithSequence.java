package patterns.treedfs;
/*
 * Given a binary tree and a number sequence, 
 * find if the sequence is present as a root-to-leaf path in the given tree.
 */
public class PathWithSequence {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean findPath(TreeNode root, int[] sequence) {

        int sum = 0;

        for (int s: sequence) {
            sum = sum*10 + s;
        }

        return findPathWithSum(root, 0, sum);

    }

    private boolean findPathWithSum(TreeNode root, int sum_so_far, int target) {
        if (root == null) {
            return false;
        }
        int sum = sum_so_far  * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum==target ? true: false;
        }
        return findPathWithSum(root.left, sum, target) || findPathWithSum(root.right, sum, target);
    }
    
}
