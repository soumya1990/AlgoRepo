package patterns.linkedlist;

/*
 * Given the head of a LinkedList and a number ‘k’,
 *  reverse every ‘k’ sized sub-list starting from the head.
If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 * 
 * Example:
 * 1->2->3->4->5->6->7->8
 * 3->2->1->6->5->4 ->8-> 
 */
public class ReverseKSubList {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverse(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dHead = new ListNode(0);
        dHead.next = head;

        ListNode ph = dHead;
        ListNode first = head;
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = null;
        while (curr != null) { // dh(lp)<-1(lns)<-2()<-3(p) 4(n,c)->5->6->7->8
            // dh->3->2->1(lnp)->4(lns)<-5<-6(p)  7(c)->8
            // dh->3->2->1->6->5->4(lnp)<-7(lns)<-8(p) ->null(c)
            //dh->3->2->1->6->5->4->8->7->null
            next = null;
            int count = 0;
            while (count++ < k - 1 && curr !=null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            } 
            ph.next = prev;
            ph = first;
            prev = curr;
            if (prev == null) {
                curr = null;
            } else {
                curr = prev.next;
            }
            first.next = null;
            first = prev;
        }
        ph.next = prev;
        return dHead.next;
    }
}
