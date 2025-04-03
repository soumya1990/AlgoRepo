package patterns.slidingwindow;

import java.util.*;

/*
 * Given an array with positive numbers and a positive target number, 
 * find all of its contiguous subarrays whose product is less than the target number.
 * Example: [1,3,2,4] target 10
 * [1];[3],[1,3];[2],[1,3,2][3,2]
 * for each sub array- append 4 to all subsets ending with the prevous end
 * 
 * 
 * 1,2,3
 * [1,2,3]  
 *   
 * TC = O(N^3)
 * 
 */
public class SubArraysWithLessProduct {

    public List<List<Integer>> getSubArrays(int[] arr, int target) {
        List<List<Integer>> resSubArrays = new LinkedList<>();
        int product = 1;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            product *= arr[end];
            while (product >= target) {
                product /= arr[start++];
            }

            LinkedList<Integer> tmp = new LinkedList<>();
            for (int j = end; j >= start; j--) {
                tmp.addFirst(arr[end]);
                resSubArrays.add(new LinkedList<>(tmp));
            }

        }
        return resSubArrays;

    }

}
