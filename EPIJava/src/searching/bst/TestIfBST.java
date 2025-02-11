// TEST IF A BINARY TREE IS BST
package searching.bst;

public class TestIfBST {
    /*
     * Option 1: In order traversal is sorted - TC = O(N) SC = O(N)
     * Option 2(Wrong): left ST BST & rightST BST && if (leftchild  null or root >= left child && if root <= right chide
     *          Empty is BST-
     *          Example: 
     *                          5(-inf, inf)
                        4(-inf, 5)               6(5, inf]
                    1 (-inf, 4]      9(4,5)   3(5,6)      8(6, inf)

                   This will NOT work as there is no range check - The above will return True instead of false 

      Option 3:'Validate range at each stage'  TC = O(N), SC = O(h)            
      Option 4: During inorder traversal, keep track of previous value, if previous value is > current value return false, 
      else return true; TC = O(N) SC = O(h)\
      Option 5: For early exit and sub linear performance - Do BFS with queue entry of range and node- and iteratively verify the range

    */  

    public class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
    }

    public boolean isTreeBST(TreeNode root) {
        
        return areNodesInRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    //Option 3
    private boolean areNodesInRange(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.key <= max && root.key >= min) {
            return areNodesInRange(root.left, min, root.key ) && areNodesInRange(root.right, root.key, max);
        }
        return true;
    }
    /*
     *                            20[-inf, inf]
     *       [-inf,20]10                                [20, inf]30
     * 
     * [-inf, 10]1       [10, 20]15             [20, 30]25                 [30, inf]40
     */

     // TODO: Option 4, Option 5 Impl
}
