package patterns.cyclicsort;

import java.util.*;
/*
 * e are given an unsorted array containing n numbers taken from the range 1 to n.
 *  The array has some numbers appearing twice,
 *  find all these duplicate numbers using constant space.
 * 
 * Example: 
 * Input: [5, 5, 3, 4, 5]
Output: [4, 5]
 * 
 * Input: [3, 2, 3 , 4, 5, 5, 7]
Output: [3, 5]
 */
public class FindAllDuplicate {

    public List<Integer> findAllDuplicate(int[] nums) {
        List<Integer> dups = new LinkedList<>();
        int i = 0;
        while (i < nums.length) {
            int pos = nums[i] - 1;
            if (i == pos) {
                i++;
            } else if (nums[i] == nums[pos]) {
                dups.add(nums[i++]);
            } else {
                swap(nums, i, pos);
            }

        }
        return dups;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
}
