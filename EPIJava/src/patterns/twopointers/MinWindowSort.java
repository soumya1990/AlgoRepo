package patterns.twopointers;

/*
 * Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
 * 
 * Example: 
 * [1,3,2,4,7,6]
 * Option 1: 
 * copy and sort the array.
 * [1,2,3,4,6,7]
 * 
 * l = find 1st out of order element
 * r = find last out of order element
 * [l,r] needs to be sorted
 * 
 * O(NlogN), O(N)
 * 
 * Option 2: 
 * 
 * Example:
 * 5,6,1,2
 * 
 * 
 * 
 * l = find 1st out of order element from left
 * r = find 1st out of order element from right
 * find min and max of the array in [l, r]
 * expand l to left till element < min - prev to l should be < min
 * expand r to right till next to r should be > max
 * return l,r
 * [TC,SC] = [O(N),O(1)]
 */

public class MinWindowSort {

    public int[] minWindowSort(int[] arr) {
        int[] window = new int[] { 0, arr.length - 1 };
        int l = 0;
        while (l + 1 <= arr.length - 1) {
            if (arr[l + 1] < arr[l]) {
                break;
            }
            l++;
        }
        int r = arr.length - 1;
        while (r - 1 >= 0) {
            if (arr[r] < arr[r - 1]) {
                break;
            }
            r--;
        }
        if (l >= r) {
            // sorted
            return new int[] { -1, -1 };
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        // expand left
        while (l - 1 >= 0) {
            if (arr[l - 1] > min) {
                l--;
            } else {
                break;
            }
        }
        // expand right
        while (r + 1 <= arr.length - 1) {
            if (arr[r + 1] < max) {
                r++;
            } else {
                break;
            }
        }
        window[0] = l;
        window[1] = r;
        return window;
    }

    /*
     * Test case : [1,2,3]
     * 
     */

}
