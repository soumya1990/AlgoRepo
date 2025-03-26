package patterns.fastslowptrs;
/*
 * Given the head of a Singly LinkedList, write a method to modify the LinkedList such that the nodes from the second half of the LinkedList
 *  are inserted alternately to the nodes from the first half in reverse order. 
 * So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, 
 * your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
Your algorithm should use only constant space the input LinkedList should be modified in-place.
 *  
 * Example: 1 -> 2 -> 3 -> 4 -> 5 -> 6
 * 
 * 1 -> 2 -> 3  6 -> 5 -> 4
 * p = 1
 * q = 6
 * 1 > 6 > 2
 * p = 2
 * q = 5
 * 1 > 6 > 2 > 5 > 3
 * p = 3
 * q = 4
 *  1 > 6 > 2 > 5 > 3 > 4 ->
 *  
 * 
 * Example: 1->2->3 5->4
 * 
 * Algo find mid and reverse
 * 1->2->3->5->4
 * 
 * 
 * 
 */

public class RearrangeLinkedList {

    class ListNode {
        int data;
        ListNode next;
    }

    public ListNode rearrange(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode q = reverse(mid.next);
        ListNode p = head;
        mid.next = null;

        while (p != null && q != null) {

            ListNode pN = p.next;
            ListNode qN = q.next;
            p.next = q;
            q.next = pN;
            p = pN;
            q = qN;
        }
        return head;
    }
    /*
     * TestCase:
     * 1. empty returns empty
     * {1} -> {1}
     * {1->2}
     * 1->2->null
     * p = 1
     * q = 2
     * pN =null
     * qn = null
     * p = null
     * q = null
     * {1->2->3}
     * 1->2 3
     * p =1
     * q = 3
     * pN = 2
     * qN = null
     * 1 -> 3 -> 2
     * p = 2
     * q = null
     * 1->2->4->3
     * 1->2 3->4
     * p = 1
     * q = 3
     * pN = 2
     * qN = 4
     * 1->3->2
     * p = 2
     * q = 4
     * pN = null
     * qN = null
     * 1->3->2->4->null
     * 
     */

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
