package mergeintervals;

import java.util.*;
/*
 * Given an array of intervals representing ‘N’ appointments,
 *  find out if a person can attend all the appointments.
 * 
 * Example: 
 * Appointments: [[1,4], [2,5], [7,9]]
Output: false
Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
 * 
 * If any 2 intervals intersect then conflict
 * 
 * [[6,7], [2,4], [13, 14], [8,12], [45, 47]] true
 * 
 * [[4,5], [2,3], [3,6]]
 */
public class ConflictingAppointment {

    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

   

    public boolean isConflict(Interval[] intervals) {
        if (intervals == null || intervals.length == 1) {
            return true;
        }
        Arrays.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        for (int i = 1; i<intervals.length; i++) {
            if(intervals[i].start <= intervals[i-1].end)  {
                return false;
            }

        }
        return true;

    }
    
}
