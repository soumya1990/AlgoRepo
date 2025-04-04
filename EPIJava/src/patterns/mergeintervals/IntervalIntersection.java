package patterns.mergeintervals;

import java.util.*;

public class IntervalIntersection {
    /*
     * Given two lists of intervals, find the intersection of these two lists. Each
     * list consists of disjoint intervals sorted on their start time.
     * 
     * Example 1:
     * 
     * Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
     * Output: [2, 3], [5, 6], [7, 7]
     * Explanation: The output list contains the common intervals between the two
     * lists.
     * 
     * [1,5][6,7][9,10]
     * [2,7][8,9]
     * 
     * Steps:
     * 1. move i on arr1
     * 2. mode j on arr2
     * find intersection add to result
     * move the one with less end value, and repeat
     * Once intersection list is ready- merge the array
     * 
     * -----
     *   --------
     * 
     */
    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> findIntersection(List<Interval> arr1, List<Interval> arr2) {

        List<Interval> intersection = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.size() && j < arr2.size()) {
            Interval e1 = arr1.get(i);// [2,7][6,7][9,10]
            Interval e2 = arr2.get(j);// [1,5][8,9]
            Interval newInterval = null;
            if (e1.start > e2.start && e1.start <= e2.end || e1.start <= e2.start && e2.start <=  e1.end) {
                newInterval = new Interval(Math.max(e1.start, e2.start), Math.min(e1.end, e2.end));
            }

            if (e1.end < e2.end) {
                i++;
            } else {
                j++;
            }

            if (newInterval != null) {
                intersection.add(newInterval);
            }

        }
        
        return intersection;

    }
}
