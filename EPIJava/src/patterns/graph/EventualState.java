package patterns.graph;

import java.util.*;

/*
 * You are given a directed graph with n nodes, labeled from 0 to n-1. This graph is described by a 2D integer array graph, where graph[i] is an array of nodes adjacent to node i, indicating there is a directed edge from node i to each of the nodes in graph[i].

A node is called a terminal node if it has no outgoing edges. A node is considered safe if every path starting from that node leads to a terminal node (or another safe node).

Return an array of all safe nodes in ascending order.
 * 
 * [[1,2],[2,3],[2],[],[5],[6],[]]
 */
public class EventualState {

    public List<Integer> getSafeNodes(int[][] graph) {
        int V = graph.length;
        List<Integer> safeNodes = new LinkedList<>();
        int[] visited = new int[V];// 0,0,0,0,0,0,0
        for (int i = 0; i < V; i++) {
            if (dfs(graph,visited, i)) {
                safeNodes.add(i);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;

    }

    public boolean dfs(int[][] graph, int[] visited, int u) {// // 1,1,1,2,2,2,2  //    
        if (visited[u] == 1) return false;
        if (visited[u] == 2) return true;
        visited[u] = 1;
        for (int nei : graph[u]) {
            if (!dfs(graph,visited, nei)) {
                return false;
            }
        }
        visited[u] = 2;
        return true;
    }

}
