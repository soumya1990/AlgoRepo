package patterns.cyclicsort;

/*
 * We are given an unsorted array containing n+1 numbers taken from the range 1 to n. 
 * The array has only one duplicate but it can be repeated multiple times.
 *  Find that duplicate number without using any extra space. You are, however, allowed to modify the input array.
 * 
 * Example: 
 * Input: [1, 4, 4, 3, 2]
 * [1,3,4,4,2]
 * [1,4,3,4,2]
 * [1,4,3,4,2]
    Output: 4
 * 
 * Input: [1,2,2,3,2]
 */
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) { // [1, 4, 4, 3, 2]
            int pos = nums[i] - 1;// 0; 3 ; 2; 3
            if (i == pos) {
                i++;//1;
            } else if (nums[pos] == nums[i]) {
                return nums[i];
            } else {
                swap(nums, i, pos); // 1,4,3,4,2
            }
        }
        return -1;

    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
