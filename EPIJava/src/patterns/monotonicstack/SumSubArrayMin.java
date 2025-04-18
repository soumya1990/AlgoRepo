package patterns.monotonicstack;

import java.util.*;

/*Given an array of integers arr, return the sum of the minimum values from all possible contiguous subarrays within arr. 
Since the result can be very large, return the final sum modulo (109 + 7).
 * 1 <= arr[i] <= 3 * 104
 * Exampe: 
 * [3, 1, 2, 4, 5]
 * Output:30
 * 
 */
public class SumSubArrayMin {

    public int minSumSubArrays(int[] nums) {
        // monotonic increasing stack
        LinkedList<Integer> stack = new LinkedList<>(); // 1,2,
        long minSum = 0;
        int MOD = 1_000_000_007;
        // 1 <= arr[i] <= 3 * 104
        for (int i = 0; i <= nums.length; i++) { // 1;2,..;5
            int currVal = i < nums.length ? nums[i] : 0;// 0
            while (!stack.isEmpty() && currVal < nums[stack.peek()]) {// 1<3;0<4
                // previous min will end here
                int minIdx = stack.pop(); // 0;4
                int prevMinIdx = stack.isEmpty() ? -1 : stack.peek();// -1; 3
                int countMinSumArrs = (i - minIdx) * (minIdx - prevMinIdx); // (1-0) * (0-(-1)) * 3 => 3 // only one
                                                                            // subarray has 3 as minimun; 5-4*4-3*5 = 5
                minSum = (minSum + (long) countMinSumArrs * nums[minIdx] % MOD) % MOD;// 3+5+8+6+8 = 30
            }
            stack.push(i);
        }
        return (int) minSum % MOD;
    }
}
