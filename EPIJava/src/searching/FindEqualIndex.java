package searching;
/**
 * Find an element in a sorted array of unique integers where index == element
 */
public class FindEqualIndex {

    /**
     * Approach: sorted, at any index k, if a[k] == k ans
     * a[k] > id: 
     * 2,3,5,6,7
     * since the elements are unique, all the elements on the right side will be > its element and hence search left
     * case 3: a[k] < id
     * -2, 0, 1 
     * search for right
     */
    public int findIndexElement(int[] arr, int k) { // [-2,0,1,3,4] k = 3
        int l = 0;
        int h = arr.length -1; // 4;
        while (l<=h) {// 0 < 4; 3 < 4; 
            int m = l + (h-l)/2; // 2;3;
            if (arr[m] == k ) { // 1 != 2;3==3
                return k; // 3
            } else if (arr[m] > k) { // 1 > 2;
                h = m -1;
            } else // arr[m] < k { // 1 < 2;
                l = m + 1; // 3;
            }
        return -1;
    }
    /**
     * test case =  -3, -2, -1 returns -1
     * [1,2,3] returns -1
     */
    
}
