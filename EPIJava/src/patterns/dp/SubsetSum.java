package patterns.dp;
/*
 * Given a set of positive numbers, determine if a subset exists whose sum is equal to a given number ‘S’.

Example 1:

Input: {1, 2, 3, 7}, S=6
Output: True
The given set has a subset whose sum is '6': {1, 2, 3}
 * 
 */
public class SubsetSum {

    public boolean IsSubsetSum(int[] nums, int target) {
        int R = nums.length + 1;
        int C = target + 1;
        boolean[] dp = new boolean[C];
        dp[0] = true;
        for (int t = 1 ; t < C; t++) {
            dp[t] = false;
        }

        for (int i = 1; i<R; i++) {
            for (int t = C-1; t >=0; t--) {
                if (t - nums[i-1] >= 0) {
                    dp[t] = dp[t] || dp[t - nums[i-1]];
                }
                
            }
        }
        return dp[target];
    }
    
}
