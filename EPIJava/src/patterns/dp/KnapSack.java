package patterns.dp;

import java.util.Arrays;

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
        Integer[][] dp = new Integer[wt.length][C + 1];
        return solveKnapSackR(wt, pr, C, 0, dp);

    }

    private int solveKnapSackR(int[] w, int[] p, int C, int i, Integer[][] dp) {
        if (i == p.length || C <= 0) {
            return 0;
        }
        if (dp[i][C] != null) {
            return (dp[i][C]);
        }
        int profit1 = 0;
        int profit2 = 0;
        if (w[i] <= C) {
            profit1 = p[i] + solveKnapSackR(w, p, C - w[i], i + 1, dp);
        }
        profit2 = solveKnapSackR(w, p, C, i + 1, dp);
        dp[i][C] = Math.max(profit1, profit2);
        return dp[i][C];
    }

    // dp[i] = Math.max(dp[i-1] + pr[i], dp[i-1])

    private int solveBF(int[] w, int[] p, int C, int i) {

        if (C <= 0 || i >= p.length) {
            return 0;
        }
        int profit1 = 0;
        int profit2 = 0;
        if (w[i] <= C) {
            profit1 = p[i] + solveBF(w, p, C - w[i], i + 1);
        }
        profit2 = solveBF(w, p, C, i + 1);
        return Math.max(profit1, profit2);
    }

    private int solveDPBU(int[] w, int[] p, int cap) {
        int R = w.length + 1;
        int C = cap + 1;

        int[][] dp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    int profit1 = dp[i-1][j];
                    int profit2 = 0;
                    if (w[i-1] <= j) {
                        profit2 = p[i-1] + dp[i-1][j - w[i-1]];
                    }
                    dp[i][j] = Math.max(profit1, profit2);
                }
            }
        }
        return dp[R-1][C-1];
    }

    private int solveKSSO(int[] w, int[] p, int cap) {
        int R = p.length + 1;
        int C = cap + 1;
       // int[] prev = new int[C];
        int[] curr =  new int[C];
        for (int i = 0; i < R; i ++) {
            for (int c = C-1; c>= 0; c--) { // pro-tip, come right to left and use 1 array
                if (c == 0 || i == 0) {
                    curr[c] = 0;
                } else {
                    int pr1 = curr[c];
                    int pr2 = 0;
                    if (c - w[i-1] >= 0) {
                        pr2 = p[i-1] + curr[c - w[i-1]];
                    }
                    curr[c] = Math.max(pr1, pr2);
                }
            }
           // prev = Arrays.copyOf(curr, prev.length);
        }
        return curr[C-1];
    }

}
