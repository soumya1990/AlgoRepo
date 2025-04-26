package patterns.dp;

/*
 * Given a set of positive numbers, 
 * find if we can partition it into two subsets such that the sum of elements in both subsets is equal.
 * Input: {1, 2, 3, 4} -> t = 10
Output: True
Find subset with sum = array_sum/2
2^n bf
use dp for 
dp[i][target] = dp[i-1][target] || dp[i-1][target - arr[i]]
{1, 2, 3, 4}
0 1 2 3 4 5 6 7 8 9 10
T T T T T T T T T T T ;i = 3
                    


 */
public class EqualSubsetSum {

    public boolean isEqualSumParition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        return findSubSet(nums, target);

    }

    private boolean findSubSet(int[] arr, int target) {
        int R = arr.length + 1;
        int C = target + 1;
        boolean[] dp = new boolean[target + 1];
        // for 0 element should be true
        dp[0] = true;
        for (int s = 1; s < C; s++) {
            dp[s] = false;
        }
        for (int i = 1; i < R; i++) {
            for (int s = C - 1; s >= 0; s--) { // i = 2
                dp[s] = dp[s]; // dp[10] = F
                if (arr[i - 1] <= s) {
                    dp[s] = dp[s] || dp[s - arr[i - 1]]; // dp[10-1] 9
                }
            }
        }
        return dp[C - 1];
    }

}
