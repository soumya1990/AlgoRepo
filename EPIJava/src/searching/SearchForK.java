package searching;
/**
 * Search for 1st  occurance of K in a sorted array.
 * 
 */
public class SearchForK {
    /*
     * A method that takes a sorted array and a key and returns the index of first occurance of the key in the array.
     * @braindump: 
     *  -10, -3, 4, 4,8 ,19
     * Steps: 
     * Do a bin search for k
     * if k is found - answer is index of k, if it is not found on the left side of the array
     * repeat till the answr is found or the search is complete.
     * If k is not found return -1
     */
    public int searchSorted(int[] sortedArr, int k) { //  -10, -3, 4, 4,8 ,19 - k = 4
        int l = 0;// 0
        int h = sortedArr.length - 1;// 5,
        int m = 0;
        int ans = -1; 
        while (l<=h) {// 0 <= 5, 0 <= 1, 1 <= 1, !2 <= 1
            m = l + (h - l)/2; // 2, 0, 1
            if (sortedArr[m] == k) { // 4 = 4, -10 < 4, 1 < 4
                ans = m; // 2
                // search for the first element for the possible previous occurance
                h = m -1; // 1
            } else if (sortedArr[m] > k) {
                h = m - 1;
            } else {
                // mid is smaller, search in the right side
                l = m + 1; // 1, 2
            }
        }
        return ans;// 2
    }
    /**
     * TC = O(lgN);
     * SC = O(1)
     */
    /*
     * Possible optimization:
     * Move to left in case of fisrt hit only if the previous element is also equal to K
     */
}
