package patterns.twopointers;

import java.util.*;

/*
 * Given an array of unsorted numbers and a target number,
 *  find all unique quadruplets in it, whose sum is equal to the target number.
 * Example :
 * {-3,0,1,3,4,5}
 */
public class UniqueQardrupletTarget {

    public List<List<Integer>> getUniqueQuarduplets(int[] arr, int target) {
        List<List<Integer>> uniqueQs = new LinkedList<>();
        Arrays.sort(arr);
        List<Integer> currSelection;
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            currSelection = new LinkedList<>();
            currSelection.add(arr[i]);
            findUniqueTriplets(arr, target - arr[i], i, uniqueQs, currSelection);
        }
        return uniqueQs;
    }

    private void findUniqueTriplets(int[] arr, int target, int curr, List<List<Integer>> uniqieQs,
            List<Integer> prevSelection) {
        List<Integer> currSelection;
        for (int i = curr + 1; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            currSelection = new LinkedList<>(prevSelection);
            currSelection.add(arr[i]);
            findUniquePairs(arr, target - arr[i], i, uniqieQs, prevSelection);
        }
    }

    private void findUniquePairs(int[] arr, int target, int curr, List<List<Integer>> uniqueQs,
            List<Integer> prevSelection) {
        int i = curr + 1;
        int j = arr.length;
        while (i < j) {
            if (arr[i] + arr[j] == target) {
                prevSelection.addAll(Arrays.asList(arr[i], arr[j]));
                uniqueQs.add(prevSelection);
                do {
                    i++;
                } while (i < j && arr[i] == arr[i - 1]);

                do {
                    j--;
                } while (i < j && arr[j] == arr[j + 1]);
            }

            else if (arr[i] + arr[j] < target) {
                i++;
            } else if (arr[i] + arr[j] > target) {
                j--;
            }
        }
    }

}
