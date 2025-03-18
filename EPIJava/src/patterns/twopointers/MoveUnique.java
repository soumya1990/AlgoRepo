package patterns.twopointers;
/*
 * Given an array of sorted numbers, move all non-duplicate number instances at the beginning of the array in-place.
 *  The non-duplicate numbers should be sorted and you should not use any extra space so that the solution
 *  has constant space complexity 
 * 
 * Move all the unique number instances at the beginning of the array 
 * and after moving return the length of the subarray that has no duplicate in it.
 * 
 * Example: {1,3,5,5,6,6,8,8} - 
 */

public class MoveUnique {

    public int moveUniqueElements(int[] num) {

        int uniqueCount = 1;
        for (int i = 1; i<num.length; i++) {
            if (num[i] != num[i-1]) {
                uniqueCount++;
                num[uniqueCount-1] = num[i];
            }
        }
        return uniqueCount;
    }
    
}
