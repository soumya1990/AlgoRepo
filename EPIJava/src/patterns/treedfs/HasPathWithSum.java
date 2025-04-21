package patterns.treedfs;

public class HasPathWithSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean hasPathWithSum(TreeNode root, int S) {
        if (root == null) {
            return false;
        }
        if (root.val == S && root.left == null && root.right == null) {
            return true;
        }
        return hasPathWithSum(root.left, S - root.val) || hasPathWithSum(root.right, S - root.val);
    }
}
