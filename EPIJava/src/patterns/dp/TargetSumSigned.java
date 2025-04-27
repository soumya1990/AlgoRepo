package patterns.dp;

import java.util.Arrays;

/*
 * You are given a set of positive numbers and a target sum ‘S’. 
 * Each number should be assigned either a ‘+’ or ‘-’ sign. 
 * We need to find the total ways to assign symbols to make the sum of the numbers equal to the target ‘S’.

Example 1:

Input: {1, 1, 2, 3}, S=1
      {} 1 0
      {1}
Output: 3
 * 
 */
public class TargetSumSigned {

    public int findTargetSubsets(int[] nums, int S) {
        int total = 0;
         for (int num : nums) {
            total += num;
         }
         int target = (total + S)/2;
         if (target * 2 != total + S) {
            return 0;
         }
         else {
            return findSumWithTargetCount (nums, target);
         }
      }
    
      private int findSumWithTargetCount(int[] nums, int target) {
        int R = nums.length + 1;
        int C = target + 1;
        int[] dp = new int[C];
        dp[0] = 1;
        for (int i =1; i < R; i++) {
            for (int t = C-1; t >=0; t--) {
                if (t - nums[i-1] >= 0) {
                    dp[t] = dp[t] + dp[t-nums[i-1]];
                }
            }
        }
        return dp[C-1];
    
      }    
    
}
