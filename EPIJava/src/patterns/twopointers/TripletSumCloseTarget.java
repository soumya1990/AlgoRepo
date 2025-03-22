package patterns.twopointers;

import java.util.*;

/*
 * Given an array of unsorted numbers and a target number, 
 * find a triplet in the array whose sum is as close to the target number as possible,
 *  return the sum of the triplet. 
 * If there are more than one such triplet, return the sum of the triplet with the smallest sum.
 * 
 * Example = [-3,-2,1,3,4] target = 5
 * Option 1: Sort the array, 
 *           pick each element and find the two pair sum closest to target
 *           update the solution greedily, prefere the closest one less than target, if closeness is same
 * 
 * -3 - find 8 pair
 * -2 + 4  = 2 < 8  , curr_sum = -1; closeness = 6; 
 * 1+4 = 5 = 5 < 8, curr_sum = 2; closeness = 3
 * 3+4 = 7 = 7<8, curr_sum = 4; closeness = 1
 * 
 * if curr_closeness < closeness_so_far the update
 * if curr_closeness == closeness_so_far update iff curr_sum < closet_sum_so_far
 */

public class TripletSumCloseTarget {

    public List<Integer> getClosestTriplet(int[] nums, int target) {
        List<Integer> cTriplet = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            getClosestPair(nums, i, target, cTriplet);
        }
        return cTriplet;
    }

    private void getClosestPair(int[] arr, int curr, int target, List<Integer> closest) {
        int i = curr + 1;
        int j = arr.length - 1;
        while (i < j) {
            int pair_sum = arr[i] + arr[j];
            int curr_sum = pair_sum + arr[curr];
            if (curr_sum == target) {
                closest.clear();
                closest.addAll(Arrays.asList(arr[curr], arr[i], arr[j]));
                return;
            } else if (curr_sum < target) {
                i++;
            } else if (curr_sum > target) {
                j--;
            }
            int closestSum = 0;
            for (int e : closest) {
                closestSum+=e;
            }
            int d = Math.abs(target - curr_sum);// 5-4 = 1
            int min_dist = Math.abs(target - closestSum); // 5 - 2 = 3
            if (d < min_dist) {
                closest.clear();
                closest.addAll(Arrays.asList(arr[curr], arr[i], arr[j])); //[-3,1,4]->[-3,3,4]
            }
            if (d == min_dist) {
                if (curr_sum < closestSum) {
                    closest.clear();
                    closest.addAll(Arrays.asList(arr[curr], arr[i], arr[j]));
                }
            }
        }

    }

}
