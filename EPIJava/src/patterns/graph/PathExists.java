package patterns.graph;

import java.util.*;

/*
 * Given an undirected graph, represented as a list of edges. 
 * Each edge is illustrated as a pair of integers [u, v], 
 * signifying that there's a mutual connection between node u and node v.
You are also given starting node start, and a destination node end, return true if a path exists between the starting node and the destination node. Otherwise, return false.
 * 
 */
public class PathExists {
    /*
     * {0,1}
     * {1,2}
     * {3,4}
     */

    public boolean isPath(int u, int v, int[][] edges) {

        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            adj.putIfAbsent(v1, new LinkedList<>());
            adj.putIfAbsent(v2, new LinkedList<>());
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }
        stack.push(u);
        while (!stack.isEmpty()) {
            int u1 = stack.pop();
            visited.add(u1);
            for (int neighbour : adj.get(u1)) {
                if (!visited.contains(neighbour)) {
                    stack.push(neighbour);
                }
            }

        }
        return visited.contains(u) && visited.contains(v);

    }
}
