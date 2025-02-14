package searching.bst;

/**
 * 12.2 given a key and  a BST find the next greater element of the key present in the BST
 */
public class NextGreaterElementBST {
    
    /*
     * Option 1: Do an inorder traversal, the 1st processed element > given_key is the answer-
     *           TC = O(n), space = O(h)
     * Option 2: Check the given element with root value- 
     *                      key = 6, 22, 14
     *                            10 [null]
     *                  4                   20[null]
     *                      8           15[20]        22
     *                                       18
     * 
     *              init current_candidate to nulll
     *              i. Compare root key with given key, if root_key is smaller than pass candidate = current_candidate and recurse on right subtree
     *              ii. if root_key is greater, update and pass root_key as current_candidate and recurse on the left subtree
     *              iii. if leaf node is reached return current candidate
     * 
     *          TC = O(h)
     *                 
     * 
     */

     public class BSTNode {
        int key;
        BSTNode left;
        BSTNode right;
     }

     public BSTNode nextGreater(BSTNode root, int key) {
        BSTNode currNext = null;
        BSTNode curr = root;
        while (curr != null) {
            if (root.key > key) {
                currNext = root;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return currNext;
     }
}
