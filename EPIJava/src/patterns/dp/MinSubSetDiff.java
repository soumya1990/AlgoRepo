package patterns.dp;
/*Given a set of positive numbers, partition the set into two subsets with minimum difference between their subset sums.
\
Example 1:

Input: {1, 2, 3, 9}
Output: 3
 * 
 *  Find Sum
 * for select i =0 - diff = sum
 * for every inclusion i = 1; min [i-1]
 * 
 *  
 * {1, 10} 
 * 11 0 0
 * 
 *   {1, 2, 3, 9} sum = 15
 * 15 13 9  3  3
 * 
 *    {1, 2, 7, 1, 5} sum = 16
 * 16 14 10  0  0  0
 *     {1,  3,  100, 4}
 * 108 106 100  92   92
 * */
public class MinSubSetDiff {

    public int minDiff(int[] nums) {
        int R= nums.length; // Do not calculate nums[nums.length] as it is calcualted as nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int[] dp = new int[R];
        dp[0] = sum;
        for (int i = 1; i < R; i++) {
            dp[i] = dp[i-1];
            for (int j = i-1; j >= 0; j--) {
                dp[i] = Math.min(dp[i], Math.abs(dp[j] - 2*nums[i-1]));
            }
            
        }
        return dp[R-1];
    }
    
}
