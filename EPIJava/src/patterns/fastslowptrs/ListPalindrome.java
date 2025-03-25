package patterns.fastslowptrs;
/*
 * Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
Your algorithm should use constant space and the input LinkedList should be in the original form once the algorithm is finished.
 The algorithm should have O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.
 * 
 * Example: 
 * 1-2-2-1
 * 1-2-3-2-1
 * Steps:
 * Find the mid with fast-slow ptr approach
 * In even case find the 1st mid
 * reverse the LL from mid +  1
 * take 2 ptrs, 1 from begining and 2 from mid +  1
 * compare each element from 1 with 2; if till ptr2 end is reached then palindrome
 * else not
* reverse the LL from mid+1
 * 
 */

public class ListPalindrome {

    class ListNode {
        int data;
        ListNode next;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode mid = findMid(head);
        mid.next = reverse(mid.next);
        ListNode p = head;
        ListNode q = mid.next;
        while (q != null) {
            if (p.data != q.data) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        mid.next = reverse(mid.next);
        return true;

    }

    private ListNode findMid(ListNode x) {
        if (x==null) {
            return null;
        }
        ListNode s = x;
        ListNode f = x;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    /*
     * 1->2->3->4
     * 1<-2<-3<-4
     * 
     * 
     * 
     * 
     */
    private ListNode reverse(ListNode x) {
        if (x == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = x;
        ListNode next = x.next;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (curr != null) {
                next = curr.next;
            }
        }
        return prev;
    }
    /** 
     * TestCase:
     *          {} ->
    */
    
}
