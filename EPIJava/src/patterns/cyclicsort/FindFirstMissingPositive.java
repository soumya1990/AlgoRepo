package patterns.cyclicsort;

/*
 * Given an unsorted array containing numbers, find the smallest missing positive number in it.
Note: Positive numbers start from '1'.
 * 
 * Input: [-3, 1, 5, 4, 2]
Output: 3
Explanation: The smallest missing positive number is '3'
 * 
 */

public class FindFirstMissingPositive {

    public int findMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) { // [1, 2, -3, 4, 5]
            if (nums[i] <= 0 || nums[i] > nums.length) {
                i++;
            } else {
                int pos = nums[i] - 1;
                if (nums[i] == nums[pos]) {
                    i++;
                } else {
                    swap(nums, i, pos);
                }
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
