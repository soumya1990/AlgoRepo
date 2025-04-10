package patterns.cyclicsort;

/*
 * We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
 *  The array originally contained all the numbers from 1 to ‘n’, but due to a data error,
 *  one of the numbers got duplicated which also resulted in one number going missing.
 *  Find both these numbers.
 * 
 * Input: [3, 1, 2, 5, 2]
Output: [2, 4]
Explanation: '2' is duplicated and '4' is missing.
 * 
 * Algo:
 * Cyclic sort.
 * Find missing and duplicate in another go 
 */

public class MissingAndDuplicate {

    public int[] findCorruptPair(int[] nums) {
        int i = 0;
        while (i < nums.length) { //[1, 2, 3, 2, 5]
            int pos = nums[i] - 1;
            if (nums[pos] != nums[i]) {
                swap(nums, i, pos);
            } else {
                i++;
            }
        }

        int[] pair = new int[]{-1,-1};
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                pair[0] = nums[i];
                pair[1] = i + 1;
            }
        }
        return pair;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
