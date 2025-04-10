package patterns.linkedlist;

/*
 * Given the head of a Singly LinkedList, 
 * reverse the LinkedList.
 *  Write a function to return the new head of the reversed LinkedList.
 * 
 * 1->2->3->4
 */
public class Reverse {

    class ListNode {
        int data;
        ListNode next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        do { // null<-1()<-2()<-3()<-4(p) null(c)
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } while (curr != null);

        return prev;
    }

}
