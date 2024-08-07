package sorting;
import java.util.Collections;
import java.util.List;

public class HoarePartitionSort<T extends Comparable<T>> {

    public void sort(List<T> arr) {
        int l = 0;
        int h = arr.size()-1;        
        quickSort(arr, l, h);
    }

    private void quickSort(List<T> arr, int l, int h) {
        if (l >= h) {
            return;
        }
        int pivotIndex = partition(arr,l,h);
        quickSort(arr, l, pivotIndex);
        quickSort(arr, pivotIndex+1, h);
    }

    public int partition(List<T> arr, int l, int h) {

        T pivot = arr.get(l);
        int left = l-1;
        int right = h+1;
        while (true) {
            do {
                left++;
            } while(arr.get(left).compareTo(pivot) < 0);
            
            do {
                right--;
            } while(arr.get(right).compareTo(pivot) > 0);

            if (left >= right) return right;
            Collections.swap(arr, left, right);
        }
    }

}
