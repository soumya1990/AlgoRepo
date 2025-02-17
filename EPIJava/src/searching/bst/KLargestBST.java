package searching.bst;

import java.util.LinkedList;
import java.util.List;

/*
 * 15.3 K Largest element in BST return in decreasing order
 * Option 1: Create a List, in the process of inorder traversal, ignore n-k elements and add others to list
 *              TC = O(N), SC = O(h) - Use Queue and remove elements from when size > k
 * 
 *Option 2:
                Do reverse inorder traversal and return when list size is k
                TC = O(h + k) : No. of times the program decents is at most h more than k. Most no. of ascents is k

                          10
                       4       20
                     1    8  16    21
 */

public class KLargestBST {

    private class BSTNode {
        int key;
        BSTNode left;
        BSTNode right;
    }

    public List<Integer> kLargestInDecreasing(BSTNode root, int K) {
        List<Integer> topK = new LinkedList<>();
        reverseInOrder(root, topK, K);
        return topK;
    }

    private void reverseInOrder(BSTNode node, List<Integer> topK, int k) {
        if (node == null)
            return;
        if (topK.size() == k)
            return;
        reverseInOrder(node.right, topK, k);
        if (topK.size() < k) { // Important: This check is important as the previous recursive calls would have
                               // checked the size on the older topK size
            topK.add(node.key);
            reverseInOrder(node.left, topK, k);
        }
    }
}