package patterns.slidingwindow;
/*
 * Given an array of positive integers and a number ‘S,’ 
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to 'S'.
 * Return 0 if no such subarray exists.
 * 
 * Example: [2,1,3,5,6] S = 7 
 * 
 * Algo:
 * 1. start from 0
 * 2. move end till the sum > S
 * 3. Register the size if smaller and move the start to next
 * 4. if (left> right || end == arr.length) exit
 * 
 */

public class SmallestSubArraySum {

    public int getSmallestSubArray(int[] arr, int S) {
        int smallest = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            while (sum > S && start <= end) { // start > end is not possible
                smallest = Math.min(smallest, end - start + 1);
                sum -= arr[start];
                start++;
            }
        }
        if (smallest == Integer.MAX_VALUE)
            return 0;
        return smallest;
    }

    /*
     * TestCase:
     * [2,3,1,2,4,3] S = 7
     * 
     * 
     */

}
