package patterns.hashmap;

import java.util.*;
/*
 * Given an array of integers, i
 * dentify the highest value that appears only once in the array.
 *  If no such number exists, return -1.
 * Input: [5, 7, 3, 7, 5, 8]
Expected Output: 8
 */
public class HighestUniue {

    public int getMaxUnique(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>(); // <5,2>;<7,2>; <3,1>; <8,1>
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int maxUnique = Integer.MIN_VALUE;
        for (int k : countMap.keySet()) {
            if (countMap.get(k) == 1) {
                maxUnique = Math.max(maxUnique, k);
            }
        }
        return maxUnique == Integer.MIN_VALUE ? -1 : maxUnique;
    }

}
