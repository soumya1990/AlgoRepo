package patterns.fastslowptrs;

/*
 * Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
If the total number of nodes in the LinkedList is even, return the second middle node.
 * 
 * Ex:
 * 1->2->3->4->5
 * 
 * Ex:
 * 1->2->3->4
 * 
 * 
 */
public class MiddleLinkedList {

    class LinkedList<T> {
        T data;
        LinkedList<T> next;
    }

    public LinkedList<Integer> findMid(LinkedList<Integer> head) {
        LinkedList<Integer> s = head;
        LinkedList<Integer> f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

}
/*
 * TestCase: {} -> {}
 * 2. {1} -> {1}
 * 3. {1,2} -> {2}
 * 4.{1,2,3} -> {2}
 * 5.{1,2,3,4} -> {3}
 * 
 */
