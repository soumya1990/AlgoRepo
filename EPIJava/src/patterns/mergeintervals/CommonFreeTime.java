package patterns.mergeintervals;

import java.util.*;

/*
 * For ‘K’ employees, we are given a list of intervals representing each employee’s working hours. 
 * Our goal is to determine if there is a free interval which is common to all employees.
 * Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
Output: [3,5]
Explanation: All the employees are free between [3,5].
 * 
 * 
 */

public class CommonFreeTime {

    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // O(Nk), O(Nk)

    public List<Interval> getFreeTime(List<List<Interval>> workingHours) {
        List<Interval> combined = new ArrayList<>();
        for (List<Interval> work : workingHours) {
            combined.addAll(work);
        }
        int start = combined.get(0).start;
        int end = combined.get(0).end;
        List<Interval> merged = new LinkedList<>();
        Collections.sort(combined, (Interval a, Interval b) -> Integer.compare(a.start, b.start));
        for (int i = 1; i < combined.size(); i++) {
            if (combined.get(i).start < end) {
                end = Math.max(end, combined.get(i).end);
            } else {
                start = combined.get(i).start;
                end = combined.get(i).end;
                merged.add(new Interval(start, end));
            }
        }
        merged.add(new Interval(start, end));
        List<Interval> free = new LinkedList<>();

        for (int i = 0; i < merged.size() - 1; i++) {
            free.add(new Interval(merged.get(i).end, merged.get(i + 1).start));
        }
        return free;
    }

    // Option 2:
    // Create Min PQ of size K - on start Index
    // Add first elements for all the K employees
    // while (!pq.empty) {
    // e =pq.poll()
    // pq.add(next)
    // if e intersects then merge and
    // curr = merge(curr, e)
    // else free.add(curr.end, e.start)
    // }

    // O(N) O(K)

    public List<Interval> findEmployeeFreeTime(List<List<Interval>> workhours) {// [[1,3], [5,6]], [[2,3], [6,8]]]
        List<Interval> free = new LinkedList<>();
        if (workhours == null || workhours.size() == 0)
            return free;
        PriorityQueue<Element> minPQ = new PriorityQueue<>(workhours.size(), (a, b) -> a.in.start - b.in.start);
        for (List<Interval> e : workhours) {
            Iterator<Interval> itr = e.iterator();
            if (itr.hasNext()) {
                minPQ.add(new Element(itr.next(), itr)); // [[ ]
            }
        }
        Interval curr = null;
        while (!minPQ.isEmpty()) {
            Element smallest = minPQ.poll();// [1,3];[2,3];[5,6];[6,8];
            if (curr == null) {
                curr = smallest.in;// [1,3];
            } else {
                if (smallest.in.start <= curr.end) {
                    curr = new Interval(curr.start, Math.max(curr.end, smallest.in.end));// [1,3];[5,8]
                } else {
                    free.add(new Interval(curr.end, smallest.in.start)); // [3,5];
                    curr = smallest.in; // [5,6]
                }
            }
            if (smallest.itr.hasNext()) {
                minPQ.offer(new Element(smallest.itr.next(), smallest.itr));
            }

        }
        return free;

    }

    class Element {
        Interval in;
        Iterator<Interval> itr;

        Element(Interval in, Iterator<Interval> itr) {
            this.in = in;
            this.itr = itr;
        }
    }

}
