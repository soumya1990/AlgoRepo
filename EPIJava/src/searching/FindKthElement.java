package searching;

import java.util.Collections;
import java.util.List;

public class FindKthElement<T extends Comparable<T>> {

    public T findKthLargest(List<T> arr, int k) {
        int l = 0;
        int h = arr.size() - 1;
        while (l <= h) {
           int p = partition(arr, l, h);
           if (p == k-1) return arr.get(p);
           else if (p>k-1) {
            h = p-1;
           }
           else {
            l = p + 1;
           }
        }
        return null;
    }

    public T findKthLargestNonDistinct(List<T> arr, int k) {
        int l = 0;
        int h = arr.size()-1;
        while (l<=h) {
            int[] p = partition3Way(arr, l, h);
            int lt = p[0];
            int gt = p[1];
            if (k-1>=lt && k-1 <= gt) return arr.get(lt);
            else if (k-1< lt) {
                h = lt-1;
            } else if (k-1>gt) {
                l = gt+1;
            }
        }
        return null;
    }

    // 3,2,4,3,3,4,1,5,1,2,3
    // 2,3,..
    // 2,2,1,1,3,3,3,3,5,4,4
    private int[] partition3Way(List<T> arr, int l, int h) {
        int lt = l;
        int gt = h;
        int i = l;
        T pivot = arr.get(i);
        while (i <= gt) {
            if (pivot.compareTo(arr.get(i)) < 0) 
            {
                Collections.swap(arr, i++, lt++);
            }
            else if (pivot.compareTo(arr.get(i)) == 0)
            {
                i++;
            }
            else {
                Collections.swap(arr, i, gt--);
            }
        }
        return new int[] {lt, gt};
    }


  // 3,4,2,1,5 -> 2,4,3,1,5 ->2,1,3,4,5 -> 
    private  int partition(List<T> arr, int l, int h) {

        T pivot = arr.get(l);
        int lt = l;
        Collections.swap(arr, h, l);
        for (int i = l; i<=h; i++) {
            if (pivot.compareTo(arr.get(i)) < 0) {
                Collections.swap(arr, i, lt++);
            }
        }
        Collections.swap(arr, h, lt);
        return lt;
    }
    
}
