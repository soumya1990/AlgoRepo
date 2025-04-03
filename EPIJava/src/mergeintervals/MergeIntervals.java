package mergeintervals;

import java.util.*;

/*
 * Given a list of intervals, 
 * merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
 * 
 * Example:
 * [[1,5],[1,7],[2,9],[5,10],[11,15],[12,17]]
 * 
 * Sort by left limit
 * Create answer list and add 1st element, merge all intervals in sequence
 */
public class MergeIntervals {

    class Pair {
        int left;
        int right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public List<Pair> mergeIntervals(List<Pair> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.left, b.left));
        List<Pair> merged = new ArrayList<>();
        merged.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Pair interval2 = intervals.get(i);
            Pair interval1 = merged.get(merged.size() - 1);
            if (interval2.left <= interval1.right) {
                Pair m = new Pair(interval1.left, Math.max(interval1.right, interval2.right));
                merged.remove(merged.size() - 1);
                merged.add(m);
            } else {
                merged.add(interval2);
            }

        }
        return merged;
    }
}
