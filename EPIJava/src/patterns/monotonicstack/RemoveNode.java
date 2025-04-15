package patterns.monotonicstack;

import java.util.*;

/*
 * Given the head node of a singly linked list, modify the list such that any node that has a node with a greater value 
 * to its right gets removed. 
 * The function should return the head of the modified list
 *  Example:
 *  8->4->2->5->-1
 *  
 */
public class RemoveNode {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode remove(ListNode head) {
        if (head == null)
            return null;
        Stack<ListNode> stack = new Stack<>();// 8,5,-1
        ListNode curr = head;
        while (curr != null) {
            while (!stack.isEmpty() && stack.peek().val < curr.val) {
                stack.pop();
            }
            stack.push(curr);
            curr = curr.next;
        }
        ListNode dH = new ListNode();
        curr = dH;
        for (ListNode node : stack) {
            curr.next = node;
            curr = curr.next;
        }
        curr.next = null;
        return dH.next;
    }

}
