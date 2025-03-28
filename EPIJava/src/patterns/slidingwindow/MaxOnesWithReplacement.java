package patterns.slidingwindow;

/*
 * 
 * Given an array containing 0s and 1s, 
 * if you are allowed to replace no more than ‘k’ 0s with 1s, 
 * find the length of the longest contiguous subarray having all 1s.
 * Example: [1,1,0,0,1,0,1,1]
 * k = 3
 * <= k zeros can exist in a valid window
 */
public class MaxOnesWithReplacement {

    public int getMaxOnes(int[] arr, int k) {
        int start = 0;
        int zeros = 0;
        int longest = 0;
        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (arr[start] == 0) {
                    zeros--;
                }
                start++;
            }
            longest = Math.max(longest, end - start + 1);
        }
        return longest;
    }

}
