package patterns.twopointers;
/*
 * Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order
 * 
 * Example: [-5,-3,1,2,4,5,6]
 * output:  [1,4,,9,16,25,25,36]
 * 
 * Option 1: create a new array and fill from the end using 2 pointers appproach: tc = O(N)
 */

public class SquareSortedArray {
    public int[] sortSquared(int[] num) {
        int i = 0;
        int j = num.length - 1;
        int[] ans = new int[num.length];
        int ansIndx = ans.length - 1;
        while (i <= j) {
            if (Math.abs(num[i]) > Math.abs(num[j])) {
                ans[ansIndx--] = num[i] * num[i];
                i++;
            } else {
                ans[ansIndx--] = num[j] * num[j];
                j--;
            }
        }
        return ans;
    }
}
