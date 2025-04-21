package patterns.treedfs;

import java.util.*;

public class PathsWithSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> getPaths(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        getPaths(root, path, res, sum);
        return res;

    }

    private List<List<Integer>> getPaths(TreeNode root, List<Integer> path, List<List<Integer>> res, int sum) {
        if (root == null)
            return null;
        if (sum == root.val && root.left == null && root.right == null) {
            path.add(root.val);
            res.add(path);
        }
        path.add(root.val);
        getPaths(root.left, new LinkedList<Integer>(path), res, sum - root.val);
        getPaths(root.right, new LinkedList<Integer>(path), res, sum - root.val);
        path.remove(path.size() - 1);
        return res;
    }
}
