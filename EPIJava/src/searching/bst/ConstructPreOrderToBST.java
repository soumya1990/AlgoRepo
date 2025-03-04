package searching.bst;
/*
 *           10
 *     4            20
 *  1      5    15      21
 *            7
 * PreOrder: 10, 4, 1, 5, 7, 20, 15, 21
 * Option 1: 
 *          1st element is root(10)
 *          All elements till greatest < 10 will be left sub tree
 *          All elements post that are the to the right
 *          recurse
 * Algorithm 
 *             root = f{10, 4, 1, 5, 7, 20, 15, 21}
 *      root.left = f({4, 1, 5, 7})
 *      root.right = f({20, 15, 21})
 * TC = balanced:  f(n) = 2f(n/2) + O(n) = O(nlgn)
 *      left skewed: f(n) = f(n-1) + O(n) = O(n^2)
 *      right skewed: f(n) = f(n-1) + O(1) = O(n)
 * SC = O(h)
 * 
 * Option 2: Optimize- instead of calculating subset of the list every time pass range to the next level
 * TC = O(n)
 */

import java.util.List;

class BSTNode {
    int key;
    BSTNode left;
    BSTNode right;

    BSTNode(int key) {
        this.key = key;
    }
}

public class ConstructPreOrderToBST {

    public BSTNode constructBST(List<Integer> pre) {
        BSTNode root = null;
        root = constructBST(root, pre, 0, pre.size() - 1);
        return root;
    }
    //Option 1
    private BSTNode constructBST(BSTNode node, List<Integer> pre, int s, int e) {
        if (e > s)
            return null;
        node = new BSTNode(pre.get(s));
        int gt = s + 1;
        while (gt < e && pre.get(gt) < pre.get(s)) {
            gt++;
        }
        node.left = constructBST(node.left, pre, s + 1, gt - 1);
        node.right = constructBST(node.right, pre, gt, e);
        return node;
    }
    /**10, 4, 1, 5, 7, 20, 15, 21
     *           
     *          f(0,7) 10
     *    f(1,4) 4         f(5,7)
     * f(2,2)1     5 f(3,4)
     *                  7f(4,4)
     *
     */
}
