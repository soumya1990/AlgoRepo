package mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running. 
 * Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.
 * 
 * Jobs: [[1,4,3], [2,5,4], [7,9,6]]
Output: 7
 */
public class MaxCPULoad {

    class Interval {
        int start;
        int end;
        int load;

        Interval(int start, int end, int load) {
            this.start = start;
            this.end = end;
            this.load = load;
        }

    }

    public int getMaxLoad(Interval[] cpuIntervals) {

        Arrays.sort(cpuIntervals, (a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Interval> minPQ = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));
        int max_load = 0;
        int curr_load = 0;
        for (int i = 0; i < cpuIntervals.length; i++) {
            while (!minPQ.isEmpty() && minPQ.peek().end <= cpuIntervals[i].start) {
                Interval completed = minPQ.poll();
                curr_load -= completed.load;// 7-3=4, 4-4 = 0
            }
            minPQ.offer(cpuIntervals[i]); // [7,9,6]
            curr_load += cpuIntervals[i].load; // 3+4; 6
            max_load = Math.max(curr_load, max_load);// 3,7,7

        }

        return max_load;

    }

}
