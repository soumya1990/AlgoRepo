package patterns.twopointers;

/**
 * Given an array of numbers sorted in ascending order and a target sum, find a
 * pair in the array whose sum is equal to the given target.
 * Write a function to return the indices of the two numbers (i.e. the pair)
 * such that they add up to the given target.
 * If no such pair exists return [-1, -1
 * 
 * Option 1: Use 2 pointers, one from left and another from right- move till the
 * point the target is found
 * Example: {-4, 3, 4,7, 8} target = 16
 */
public class TargetSum {

    public int[] findTarget(int[] sortedArr, int target) {
        int l = 0;
        int h = sortedArr.length - 1;
        while (l < h) {
            int sum = sortedArr[l] + sortedArr[h];
            if (sum == target) {
                return new int[] { l, h };
            } else if (sum < target) {
                l++;
            } else {
                h--;
            }
        }
        return new int[] { -1, -1 };
    }

}
