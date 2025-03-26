package patterns.slidingwindow;
/*
 * Given an array of positive numbers and a positive number 'k,' find the maximum sum of any contiguous subarray of size 'k'.
 * 
 * Example: [2,4,3,6,4] K = 3
 * 
 * 
 */

public class MaxSumSubArray {

    public int maxSumSubArray(int[] arr, int K) {
        // Assumption arr.length <= K
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= K) {
                sum -= arr[i - K];
                maxSum = Math.max(sum, maxSum);
            }
        }
        maxSum = Math.max(maxSum, sum);
        return sum;
    }

}
