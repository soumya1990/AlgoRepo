package patterns.fastslowptrs;
/*
 * Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not
 * 
 * 
 * 
 */

public class DetectCycle {

    class LinkedList<T> {
        T data;
        LinkedList<T> next;
    }

    public boolean hasCycle(LinkedList<Integer> head) {

        LinkedList<Integer> s = head;
        LinkedList<Integer> f = head;
        while (f != null) {
            s = s.next;
            f = f.next;
            if (f.next == null) {
                return false;
            }
            f = f.next;
            if (s == f) {
                return true;
            }
        }
        return false;
    }
    /*
     * Testcase:
     * 1,2,3,4,1
     * s = 1-2-3-4-1
     * f = 1-3-1-3-1
     * true
     * {} -> false
     * {1,2}
     * 1->2
     * 1->null 
     * false
     * 
     */
    
}
