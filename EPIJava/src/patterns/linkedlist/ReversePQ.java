package patterns.linkedlist;
/*
 * Given the head of a LinkedList and two positions ‘p’ and ‘q’,
 *  reverse the LinkedList from position ‘p’ to ‘q’.
 * Example: 
 * {1->2(pPrev) 3()<-4()<-5(p)->6(c)} p =3 q = 5
 * 
 * 1->2->3->4->5->6
 * 1->2->5->4->3->6
 * 
 */

public class ReversePQ {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val, ListNode next) {
            this.val =val;
            this.next = next;
        }
    }

    public ListNode reverse(ListNode head, int p, int q) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dHead = new ListNode(0, head);
        ListNode pPrev = dHead;
        ListNode curr = head;
        for (int i = 1; i < p; i++) {
            pPrev = curr;
            curr = curr.next;
        }
        ListNode prev = curr;
        curr = curr.next;
        ListNode next = null;
        int i = 0;
        while(i < q-p) {
            i++;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        pPrev.next.next = curr;
        pPrev.next = prev;
        return dHead.next;
    }

}
