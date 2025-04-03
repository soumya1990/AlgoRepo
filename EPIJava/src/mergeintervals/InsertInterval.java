package mergeintervals;

import java.util.*;
/*
 * Given a list of non-overlapping intervals sorted by their start time, 
 * insert a given interval at the correct position and merge all necessary 
 * intervals to produce a list that has only mutually exclusive intervals.
 * 
 * Example: [1,4],[7,8], [9,20] Insert :  [5,6]
 * 
 * Algo:
 * move from left to right, merge incoming with each element
 */

public class InsertInterval {

    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> insertInterval(List<Interval> intervals, Interval n) {
        List<Interval> res = new LinkedList<>();
        if (intervals.isEmpty()) {
            res.add(n);
            return res;
        }
        int i = 0;
        while (i < intervals.size() && intervals.get(i).start > n.end) {
            res.add(intervals.get(i++));
        }

        Interval merged = null;

        while (i < intervals.size() && n.end >= intervals.get(i).start) {
            merged = new Interval(Math.min(n.start, intervals.get(i).start), Math.max(n.end, intervals.get(i).end));
            i++;
        }

        if (merged != null) {
            res.add(merged);
        }

        while (i < intervals.size()) {
            res.add(intervals.get(i++));
        }
        return res;
    }

}
