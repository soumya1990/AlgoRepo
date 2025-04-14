package patterns.stack;

import java.util.*;
/*
 * Given a stack, sort it using only stack operations (push and pop).

You can use an additional temporary stack, but you may not copy the elements into any other data structure (such as an array). 
The values in the stack are to be sorted in descending order, with the largest elements on top.
 * 
 * 4,3,2,1
 * []
 * [4,3,2,1]
 * 
 */

public class SortWithStack {

    public LinkedList<Integer> sort(LinkedList<Integer> stack) {
        LinkedList<Integer> tmpStack = new LinkedList<>();
        while (!stack.isEmpty()) {
            int num = stack.pop();
            while (!tmpStack.isEmpty() && num < tmpStack.peek()) {
                stack.push(tmpStack.pop());
            }
            tmpStack.push(num);

        }
        return tmpStack;

    }

}
