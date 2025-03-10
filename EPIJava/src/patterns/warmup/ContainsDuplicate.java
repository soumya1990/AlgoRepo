/*
 * Given an integer array nums, return true if any value appears at least twice in the array,
 *  and return false if every element is distinct
 *  
 * 
 * Approach 1: hash set, O(N) - sc = O(N)
 * Approach 2: Sort and identify - TC = O(NlgN) Sc = based on sorting implementation- Arrays.sort() - O(lgN) quick sort variant
 */

package patterns.warmup;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class ContainsDuplicate {

    public boolean hasDuplicate(int[] arr) {
        Set<Integer> elementsSet = new HashSet<>();
        for (int element : arr) {
            if (elementsSet.contains(element)) {
                return true;
            } else {
                elementsSet.add(element);
            }
        }
        return false;
    }

    public boolean hasDuplicateSort(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1])
                return true;
        }
        return false;
    }

}
