package patterns.warmup;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums, return the number of good pairs.
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 * 
 * Option 1: find frequency of each elements- check how many pairs possible
 * using those.
 * SC = O(N), TC = O(N)
 */
public class CountGoodPairs {

    public long countGoodPairs(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
        }
        long pairCounts = 0;
        for (int key : countMap.keySet()) {
            int f = countMap.get(key);
            pairCounts += (f * f - 1) / 2;
        }

        return pairCounts;

    }
}
