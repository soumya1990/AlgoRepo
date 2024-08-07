

import java.util.Arrays;

import searching.FindKthElement;
import searching.MinMaxFind;
import sorting.HoarePartitionSort;

public class App {
    public static void main(String[] args) throws Exception {
        testSearching();
        testSorting();
    }

    private static void testSearching() {
        testMinMaxFind();
        testKLargest();
    }

    private static void testKLargest() {
        Integer[] a = {4,6,1,2,3,5};
        Integer e = new FindKthElement<Integer>().findKthLargest(Arrays.asList(a), 1);
        System.out.println("element = " + e);
    }

    private static void testMinMaxFind() {

        Integer[] a = {5,6,1,2,3,5};
        MinMaxFind<Integer>.MinMax res = new MinMaxFind<Integer>().findMinMax(Arrays.asList(a));
        System.out.println(res);
        a = new Integer[]{6,5,4,3,2,1};
        res = new MinMaxFind<Integer>().findMinMax(Arrays.asList(a));
        System.out.println(res);
    
    }

    private static void testSorting() {
        Integer[] a = {3,2,1,2,4,5,3,3,1,3,6};
        new HoarePartitionSort<Integer>().sort(Arrays.asList(a));
        System.out.println(Arrays.toString(a));
    }
}
