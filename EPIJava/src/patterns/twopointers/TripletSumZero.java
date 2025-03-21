package patterns.twopointers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.*;

/*
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 * Example: [3,-2,1,1,-3,0]
 * Option 1: find all triplets- check their sum, if zero and if not already added then add to answer- TC = O(N^3) SC = Use HashSet of List
 * Option 2: sort the array, pick 1st element and find sum = -1st element contiune
 * [-3,-2,0,1,1,3]
 * -3 - pick 2 elements with sum in rest of the sorted array.
 * When to terminate: [-3,0,1,2,3,4] - if found - add to list and repeat again by decrementing j 
 * 
 * Algorithm:
 Step-by-Step Algorithm

Sort the Array:

Sort the input array in non-decreasing order. This helps in easily skipping duplicate elements and applying the two-pointer technique.
Iterate through the Array:

Use a for loop to iterate through the array, stopping at the third-to-last element.
For each element, check if it's the same as the previous one to avoid duplicates.
If it's the same, skip to the next iteration.
Fix the Current Element and Find Pairs:

Fix the current element and use two pointers to find pairs whose sum is the negative of the fixed element (targetSum = -arr[i]).
The left pointer starts from the next element (i + 1) and the right pointer starts from the end of the array.
Find Pairs with Two Pointers:
Calculate the sum of the left pointer and the right pointer (currentSum = arr[left] + arr[right]).
If the currentSum equals targetSum, add the triplet to the list ([-targetSum, arr[left], arr[right]]) and move both pointers to the next unique elements.
If currentSum is less than targetSum, move the left pointer to the right to increase the sum.
If currentSum is greater than targetSum, move the right pointer to the left to decrease the sum.
Skip Duplicates:

Ensure that the left and right pointers skip duplicate elements to avoid counting the same triplet multiple times.
Return the Result:

After processing all elements, return the list of unique triplets
 */
public class TripletSumZero {
    Set<List<Integer>> tripletSet = new HashSet<>();

    public Set<List<Integer>> findUniqueTriplets(int[] nums) {
        Arrays.sort(nums);// [-3,0,1,2,3,4] 
        for (int i =0; i< nums.length-2; i++) {
            // check if duplicate then skip
            if (i> 0 && nums[i] == nums[i-1]) {
                continue;
            }
             findSum(nums, i);
        }
        return tripletSet;
    }

    private void findSum(int[] sortedArr ,int targetIdx) {// [-3,0,1,2,3,4] , 0
        int i = targetIdx + 1;
        int j = sortedArr.length -1;
        int target = -sortedArr[targetIdx];// 3
        while (i<j) {// 0,5; 1,5;1,4;1,3;2,3;2,2
            if (sortedArr[i] + sortedArr[j] == target) { // 4, 3, 2, 3
                List<Integer> triplet = new LinkedList<Integer>();
                triplet.add(-target);
                triplet.add(sortedArr[i]);
                triplet.add(sortedArr[j]);
                tripletSet.add(triplet); //-3,0,3; -3,1,2;
                // move left to next unique
                //0,0,0,0,1,1,1,1
                do {
                    i++;
                } while (i< j && sortedArr[i] == sortedArr[i-1]) ;

                // move right to next unique

                do {
                    j--;
                } while (i< j && sortedArr[j] == sortedArr[j+1]) ;
            }
            else if (sortedArr[i] + sortedArr[j] < target) {
                i++;// 2,3;
            }
            else if (sortedArr[i] + sortedArr[j] > target) {
                j--;//1,4;
            }
        }

    }
    // Observation: 1. start searching from targetIdx+1
    // Observation: 2. keep the current search from 0 but terminate at after 1st pair is found

}
