package patterns.treedfs;

public class SumPathNumbers {
    /*
     * 1
     * 0 1
     * 1 6 6
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int getpathsSum(TreeNode root) {
        return getPathSums(root, new StringBuilder());
    }

    private int getPathSums(TreeNode root, StringBuilder sb) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            String val = sb.toString();
            int res = Integer.parseInt(val);
            return res;
        }
        sb.append(root.val);
        int res = getPathSums(root.left, new StringBuilder(sb.toString()))
                + getPathSums(root.right, new StringBuilder(sb.toString()));
        sb.deleteCharAt(sb.length() - 1);
        return res;
    }
}
