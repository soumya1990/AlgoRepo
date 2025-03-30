package patterns.slidingwindow;

/*
 * Given an array nums with positive numbers and a positive integer target,
 *  return the count of contiguous subarrays whose product is less than the target number.
 * 
 * example:
 * [1,3,4,5,6] target = 12
 * [1,2,3,4,5] target = 10
 * [2, 5, 3, 10], target=30
 * 1+2+1+2+1+
 * [2]; [2,5],[5];[5,3],[3];[10] = 6
 *For each subset satisfying the product constraint- add the subarray length to answer
 * 
 */
public class CountSubArrayWithLessProduct {

    public int countProductSubArray(int[] arr, int target) {
        int start = 0;
        long product = 1;
        int count = 0;
        for (int end = 0; end < arr.length; end++) {
            product = product * arr[end];
            while (product >= target) {
                product /= arr[start++];
            }
            count += end - start + 1;

        }
        return count;
    }

}
