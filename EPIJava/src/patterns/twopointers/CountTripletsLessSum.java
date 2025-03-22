package patterns.twopointers;

import java.util.Arrays;

/*
 *Given an array arr of unsorted numbers and a target sum, 
 count all triplets in it such that arr[i] + arr[j] + arr[k] < target
 where i, j, and k are three different indices. Write a function to return the count of such triplets. 
 * 
 * Example = [-3,2,3,4] t = 1
 * -3 -> look for < 8
 * No. of pairs sum < 8
 * 
 * count # of pairs with sum less than target
 * 
 *Example [-3, -2, 0,5,7] target < 3
 1. -3 -> [-2, 0,5,7] less than 6  ans  = 3+ 1 + 
 2. -2 -> [0,5,7] less than 5 
 * 
 */
public class CountTripletsLessSum {

    public int lessThanTargetCount(int[] arr, int target) {
        int tripletLessCount = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int pairTarget = target - arr[i];
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int pairSum = arr[left] + arr[right];
                if (pairSum < pairTarget) {
                    // Add the count
                    tripletLessCount = (right - left); // including the current pair
                    // select the next greater pair and repeat the process
                    left++;
                } else if (pairSum >= target) {
                    // reduce the sum and retry
                    right--;
                }
            }
        }
        return tripletLessCount;
    }

}
