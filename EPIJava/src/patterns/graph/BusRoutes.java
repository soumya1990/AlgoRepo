package patterns.graph;

import java.util.*;

/*You are given an array routes where routes[i] is the list of bus stops that the ithe bus travels in a cyclic manner. For example, if routes[0] = [2, 3, 7], it means that bus 0 travels through the stops 2 -> 3 -> 7 -> 2 -> 3 -> 7 ... and then repeats this sequence indefinitely.
You start at a bus stop called source and wish to travel to a bus stop called target using the bus routes. You can switch buses at any bus stop that is common to the routes of two buses.
Return the minimum number of buses you need to take to travel from source to target. If it is not possible to reach the target, return -1.
 * Input: routes = [[2, 3, 4], [5, 6, 7, 8], [4, 5, 9, 10], [10, 12]], source = 3, target = 12
Expected Output: 3
 * 
 */
public class BusRoutes {

    class Pair {
        int station;
        int count;// no. of buses used

        Pair(int station, int count) {
            this.count = count;
            this.station = station;
        }
    }

    public int getMinBusses(int[][] routes, int start, int dest) {
        Map<Integer, List<Integer>> stationBusMap = new HashMap<>(); // 2 - {0} .. ;5 ->{1,2}, 3 -> {0}
        int B = routes.length;
        for (int i = 0; i < B; i++) {
            int S = routes[i].length;
            for (int j = 0; j < S; j++) {
                stationBusMap.computeIfAbsent(routes[i][j], x -> new LinkedList<>());
                stationBusMap.get(routes[i][j]).add(i);
            }
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));
        Set<Integer> vS = new HashSet<>();
        Set<Integer> vB = new HashSet<>();

        while (!q.isEmpty()) {
            Pair curr = q.poll(); // (3,0)
            vS.add(curr.station);
            int count = curr.count;
            List<Integer> busses = stationBusMap.get(curr.station);
            for (int bus : busses) {
                if (!vB.contains(bus)) {
                    for (int st : routes[bus]) {
                        if (!vS.contains(st)) {
                            if (st == dest) {
                                return count + 1;
                            }
                            q.offer(new Pair(st, count + 1));
                        }
                    }
                    vB.add(bus);
                }
            }

        }

        return -1;
    }

}
