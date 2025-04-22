package patterns.treedfs;
/*
 * Given a binary tree, find the length of its diameter.
 *  The diameter of a tree is the number of nodes on the longest path between any two leaf nodes. 
 * The diameter of a tree may or may not pass through the root.
 *       1
 *  1          1
 * 1  1      1    1
 */
public class TreeDiameters {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private int diameter = Integer.MIN_VALUE;

    public int getTreeDiameter(TreeNode root) {
        getTreeDiameterInternal(root);
        return diameter;
    }

    private int getTreeDiameterInternal(TreeNode root) {
        if (root == null ) return 0;
        int ld = getTreeDiameterInternal(root.left);
        int rd = getTreeDiameterInternal(root.right);
        diameter = Math.max(diameter, ld+rd+1);
        return Math.max(ld,rd)+1;
    }
    
}
