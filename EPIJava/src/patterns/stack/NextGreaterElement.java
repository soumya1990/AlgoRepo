package patterns.stack;

import java.util.*;

/*
 * Given an array, print the Next Greater Element (NGE) for every element.
 * The Next Greater Element for an element x is the first greater element on the right side of x in the array.
 * Elements for which no greater element exist, consider the next greater element as -1.
 * 
 * Example: 1,3, 2,4,5
 * 
 * Keep a running stack left to right- 
 * If at any point of time stack top is < curr;
 * pop the stack till stack top is greater or stack is empty
 * for all popped element curr is the NGE
 * 
 */
public class NextGreaterElement {

    public int[] getNGE(int[] nums) {
        int[] nge = new int[nums.length];// 1,3, 2,4,5
        Arrays.fill(nge, -1);// [3,4,4,5,-1]
        LinkedList<Integer> stack = new LinkedList<>(); // {5}
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int e = stack.pop();
                nge[e] = nums[i];
            }
            stack.push(i);

        }
        return nge;
    }

}
