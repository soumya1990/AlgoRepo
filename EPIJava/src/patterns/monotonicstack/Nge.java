package patterns.monotonicstack;

import java.util.LinkedList;
import java.util.*;

/*Given two integer arrays nums1 and nums2, return an array answer 
such that answer[i] is the next greater number for every nums1[i] in nums2.
 * The next greater element for an element x is the first element to the right of x that is greater than x. If there is no greater number, output -1 for that number.
The numbers in nums1 are all present in nums2.
 * 
 * Example: 
 * Input: nums1 = [4,2,6], nums2 = [6,2,4,5,3,7]
   Output: 
 */
public class Nge {

    public int[] nge(int[] nums1, int[] nums2) {
        Map<Integer, Integer> ngeMap = new HashMap<>();// <7,-1>,<3,7>,<5,7>,<4,5>,<2,4>,<6,7>
        LinkedList<Integer> stack = new LinkedList<>();// 7,6
        for (int i = nums2.length-1; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            } 
            ngeMap.put(nums2[i],stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        int ans[] = new int[nums1.length];
        for (int i = 0; i<nums1.length; i++){
            ans[i] = ngeMap.get(nums1[i]);
        }
        return ans;
    }
    
}
