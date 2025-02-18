package searching.bst;

/*
 * Find LCA of 2 nodes in BST
 * Option 1: 
 * LCA of x and y: 
 *  if (x> root.key && y > root.key) find on the right subtree
 *  if (x< root.key && y < root.key) find on the left
 * if (x == root.key) || (y == root.key) return root;
 * if  return y;
 *   else root is the LCA provided  both keys are present
 * 
 * TC = O(h), SC = O(h)
 * 
 * Option 2 :
 * The solution will work for distinct nodes, to be able to use BST property.
 * Solution without using BST property-
 * Do post order traversal, the 1st node traversed when we have found both x and y is the answer. 
 * 
 *          10
 *     4          20
 * 1      6    16     21
 *  
 */

public class LcaBST {

    private class BSTNode {
        int key;
        BSTNode left;
        BSTNode right;
    }


    public BSTNode  findLCA(BSTNode node, int x, int y) {
        BSTNode curr = node;
        while (curr != null) {
            if (curr.key == x || curr.key == y) {
                return curr;
            }
             if (curr.key < x && curr.key < y) {
                curr= curr.right;
             }
             if (curr.key > x && curr.key > y) {
                curr = curr.left;
             } else {
                return curr;
             }
            
        }
        return null;
    }
    
}
