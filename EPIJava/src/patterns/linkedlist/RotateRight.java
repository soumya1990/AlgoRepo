package patterns.linkedlist;
/*
 * Given the head of a Singly LinkedList and a number ‘k’, rotate the LinkedList to the right by ‘k’ nodes.
 * Example: 
 * 1->2->3->4->5, k = 8 
 * k % 5 = 3
 * 
 */
public class RotateRight {

    class ListNode {
        int val;
        ListNode next;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        k = k%length;
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while (count++ < k) {
            fast = fast.next;
        }
        while (true) {
            if (fast.next == null ) {
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
    
}
