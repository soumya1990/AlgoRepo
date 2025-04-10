package patterns.cyclicsort;

import java.util.*;

/*
 * Given an unsorted array containing numbers and a number ‘k’, 
 * find the first ‘k’ missing positive numbers in the array.
 * 
 * [3, -1, 4, 5, 5], k=3
 * 1,2,6
 * [3, -1, 4, 5, 6], k=3
 * 
 * Algo:
 * Sort- Keep track of the > nums.length number in a HashSet
 * Find the missing elements by iterating through 1..n
 * if we have found(f) < k missing positive
 * then find (k-f) more by iterating from nums.length+1 while checking the hashset
 * 
 * SC = O(k)
 * TC = O(k + N)
 * 
 */
public class FirstKMissingPositive {

    public List<Integer> findKMissing(int[] nums, int k) {

        int i = 0;
        while (i < nums.length) { // [6, -1, 3, 4, 5]
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        List<Integer> missingPositives = new LinkedList<>();
        Set<Integer> hashSet = new HashSet<>();

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                missingPositives.add(i + 1); // 1,2,7
                k--;
                if (k == 0) {
                    break;
                }
                if (nums[i] > nums.length) {
                    hashSet.add(nums[i]);// 6, 
                }
            } 
        }
        i = nums.length + 1;

        while (k > 0) {
            // if element i is part of array then continue
            if (hashSet.contains(i)) {
                i++;
                continue;
            }
            missingPositives.add(i++);
            k--;
        }

        return missingPositives;

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
