package patterns.treedfs;

import java.util.*;

public class CountPathsForSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int countPaths(TreeNode root, int S) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return countPaths(root,0, S, new HashMap<>());
    }

    private int countPaths(TreeNode root, int path_sum, int target, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int pathCount = 0;
        path_sum = path_sum + root.val;
        pathCount += map.getOrDefault(path_sum - target, 0);
        map.put(path_sum, map.getOrDefault(path_sum, 0 ) + 1);
        pathCount += countPaths(root.left, path_sum, target, map);
        pathCount += countPaths(root.right, path_sum, target, map);
        map.put(path_sum, map.getOrDefault(path_sum, 0 ) - 1);
        return pathCount;
    }

}
