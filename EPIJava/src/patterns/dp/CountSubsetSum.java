package patterns.dp;

/*
 * Given a set of positive numbers, find the total number of subsets whose sum is equal to a given number ‘S’.

Example 1:

Input: {1, 1, 2, 3}, S=4
Output: 3
 */
public class CountSubsetSum {

    public int countSubSetSum(int[] nums, int S) {
        int R = nums.length + 1;
        int C = S + 1;
        int[] dp = new int[C];
     

        for (int i = 1; i < R; i++) {
            for (int t = C - 1; t >= 0; t--) {
                if (t - nums[i-1] >= 0) {
                    dp[t] = dp[t] + dp[t - nums[i-1]];
                }
            }
        }
        return dp[S];
    }

}
