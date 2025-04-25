package patterns.graph;

import java.util.*;

/*
 * Given a directed acyclic graph with n nodes labeled from 0 to n-1,
 *  determine the smallest number of initial nodes such that you can access all the nodes by traversing edges. Return these nodes.
 * 
 * Example 1:
Input:
n = 6
edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
Expected Output: [0,3]
 */

public class MinVertices {


    public List<Integer> getMinVertices(int[][] edges, int V) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] hasIncomingEdge = new boolean[V];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, x -> new LinkedList<>());
            graph.get(u).add(v);
            hasIncomingEdge[v] = true;

        } // 0->1,2; 2->5; 3->4; 4->2
        List<Integer> vertices = new LinkedList<>();
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
            if (!hasIncomingEdge[i] && visited[i] == 0) {
                vertices.add(i);
            }

        }
        return vertices;
    }

 

}
