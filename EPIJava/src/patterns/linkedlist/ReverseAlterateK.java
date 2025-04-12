package patterns.linkedlist;
/*
 * 
 * Given the head of a LinkedList and a number ‘k’, reverse every alternating ‘k’ sized sub-list starting from the head.

If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too

Example: 
1->2->3->4->5->6->7
2-1-3->4->5->7->6
 */

public class ReverseAlterateK {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode reverseAlt(ListNode head, int k) { // dh(ple)<-1(cle)<-2(p) 3(n,c) k = 2 //dh->2->1()->3(p,ple)->null(c)
        if (head == null && k < 1) {
            return null;
        }
        boolean reverse = true;
        ListNode dH = new ListNode();
        dH.next = head;
        ListNode prev = dH;
        ListNode curr = head;
        ListNode next = null;
        ListNode ple = prev;
        ListNode cse = curr;

        while (true) {
            if (reverse) {
                int count = 0;
                while (count++ < k && curr != null) {
                    next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }
                ple.next = prev;
                cse.next = curr;
                prev = cse;

            } else {
                int count = 0;
                while (count++ < k && curr != null) {
                    next = curr.next;
                    prev = curr;
                    curr = next;
                }

            }
            if (curr == null) {
                break;
            }
            ple = prev;
            cse = curr;
            reverse = !reverse;
        }
        return dH.next;

    }

}
