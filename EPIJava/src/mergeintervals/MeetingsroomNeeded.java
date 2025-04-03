package mergeintervals;

import java.util.*;

/*
 * Given a list of intervals representing the start and end time of ‘N’ meetings,
 *  find the minimum number of rooms required to hold all the meetings.
 * 
 * Example: 
 * [2,4] [3,5] [9-10] [12-14] [13-15]
 * 
 * Maintain the max continuous overlap count = meeting rooms
 * 
 * 1. Sort by start
 * 2. left to right
 * if overlap mergeInterval, coninue
 * 
 * [1,2],[3,5] [4,6]
 * 
 * make a sorted array of end times
 * find floorIndex of the current start
 * remove elements lower that the current start as meeting has ended
 * 
 *  make a sorted array of end times => correction - use MinHeap
 */

public class MeetingsroomNeeded {

    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end =end;
        }
    }

    public int getMeetingRoomsNeeded(Interval[] intervals) {
        if (intervals == null || intervals.length == 0){
            return 0;
        }
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(); //5,6
        int max_meeting = 1;
        for (int i = 0; i < intervals.length; i++) {
            // check if current time conflicts with blocked
            while(!minPQ.isEmpty() && minPQ.peek() <= intervals[i].start) {
                minPQ.poll();
            }
            minPQ.add(intervals[i].end);
            max_meeting = Math.max(max_meeting, minPQ.size());
        }
        return max_meeting;//2,

    }
    
}
