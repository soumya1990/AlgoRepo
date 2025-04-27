package patterns.backtracking;

import java.util.*;

/*Given an array of distinct positive integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target.
 You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

Example 1:

Input: candidates = [2, 3, 6, 7], target = 7  
Output: [[2, 2, 3], [7]]  
Explanation: The elements in these two combinations sum up to 7.
 * 
 * 
 */
public class CombinationSum {

    public List<List<Integer>> getSubSets(int[] nums, int target) {
        return getSubSets(nums, target, 0,  new LinkedList<>(), new LinkedList<>());

    }

    private List<List<Integer>> getSubSets(int[] nums, int target, int start, List<Integer> selected, List<List<Integer>> res) {

        if (target == 0) {
            res.add(new LinkedList<>(selected));
        }

        for (int i = start; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                selected.add(nums[i]);
                getSubSets(nums, target - nums[i], t, selected, res);
                selected.remove(selected.size() - 1);
            }

        }
        return res;

    }

}
