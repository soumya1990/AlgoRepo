package patterns.dp;
/*
 * Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of these items which will give us maximum profit such that their cumulative weight is not more than a given number ‘C.’
 *  Each item can only be selected once, which means either we put an item in the knapsack or we skip it.
 * Example: 
 * Weights: { 2, 3, 1, 4 }
   Profits: { 4, 5, 10, 7 }
Knapsack capacity: 5

   max_profit  =max(p[i]+ f(i-1, C-wt), f(i-1,C))
   mp[1] = max(4 + mp[0], mp[0]) = 4
   mp[2] = max(mp[1] + 5, mp[1]) = 9
   mp[3] = max(mp[2])

[1,6,10,16]
[1,2,3,5]



f(0,0,0)


 */
public class KnapSack {
     public int solveKnapSack(int[] wt, int[] pr, int C) {
        Integer[][] dp = new Integer[wt.length][C+1];
        return solveKnapSackR(wt, pr, C, 0, dp);

     }

     private int solveKnapSackR(int[] wt, int[] pr, int C, int i, Integer[][] dp) {
        if (i == pr.length || C < 0) {
            return 0;
        }
        if (dp[i][C] != null) {
            return (dp[i][C];
        }
        if (wt[i] <= C) {
            if(dp[i+1][C-wt[i]] == null) {
                dp[i+1][C-wt[i]] = pr[i] + solveKnapSackR(wt, pr, C - wt[i], i+1, dp);
            }
        }
        if (dp[i+1][C] == null) {
            dp[i+1][C] = solveKnapSackR(wt, pr, C, i+1 , dp);
        }

        dp[i][C] = Math.max(dp[i+1][C-wt[i]], dp[i+1][C]);
        return dp[i][C];
     }

     // dp[i] = Math.max(dp[i-1] + pr[i], dp[i-1])
    
}
