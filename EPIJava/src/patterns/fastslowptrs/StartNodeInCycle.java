package patterns.fastslowptrs;
/*
 * Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
 * 
 * Example: 1-2->3->4->5->3
 * s = 1-2-3-4-5-3-4-5-3-4-5-
 * f = 1-3-5-4-3-5-4-5-4-3-5
 * Example: 1-2->3->4->5->1
 * 1-2-3-4-5-1-2-3-4-5-1
 * 1-3-5-2-4-1-3-5-2-4-1
 *  Example: 1-2->3->4->5->2
 * 1-2-3-4-5-2-3-4-5-2-3
 * 1-3-5-3-5
 * 
 * intution: if circle length is L - L+1 step for slow and fast to meet
 * // cycle length can be found by moving s till it reached f again as well.
 * 
 * Now cirleLenth = L
 * Non circleLength = x
 * Total length = L + x
 * After x-1 steps both will reach the cycle start point
 */

public class StartNodeInCycle {

    class ListNode {
        int v;
        ListNode next;
    }

    public ListNode getIntersection(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        int circleLength = 0;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            circleLength++;
            if (s == f) {
                break;
            }
        }
        s = head;
        f = head;
        int i = circleLength;
        while (i > 0) {
            f = f.next;
            i--;
        }
        while (s != f) {
            s = s.next;
            f = f.next;
        }
        return f;

    }

}
