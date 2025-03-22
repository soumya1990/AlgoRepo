package patterns.twopointers;

/*
 * Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, 
 * hence, we can’t count 0s, 1s, and 2s to recreate the array.
 * The flag of the Netherlands consists of three colors: red, white and blue; 
 * and since our input array also consists of three different numbers that is why it is called Dutch National Flag proble
 * 
 * Example: 
 * [1,0,0,1,2,0,1]
 * 
 * Option 1: 
 * 1. Sort the array - O(lgN)
 * Option 2:
 * Use modified partition used in quick sort.
 * 
 * - Use 2 variables lt and gt 
 * - invariants - before lt all are 0
 * - after gt all are 2
 * from lt to gt all are 1
 * 
 * 1,0,2,1,2,0,1,0

 * i =0,
 * j = 6
 * lt = 0
 * gt = 0 -> 1 
* 
== 1 then gt++, i++
== 0 then lt++, gt++, exchange
 */
public class DutchFlag {

    public void segregate(int[] arr) { // [1,0,2,1,2,0,1,0]; [1,0,2,1,2,0,1,0]; [0,1,2,1,2,0,1,0] ; [0,0,0,1,1,1,2,2]
        int i = 0;
        int j = arr.length-1;// 7
        while (i < j) {
            int lt = 0;//  Invariant [lt, i-1] are 1
            if (arr[i] == 1) {
                i++;// 1,4
            }
            if (arr[i] == 0) {
                exchange(arr, lt, i);
                lt++; // 1,2
                i++;// 2,3
            }

            if (arr[i] == 2) {
                exchange(arr, j, i);
                j--;// 6,5
            }
        }
    }

    private void exchange(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
