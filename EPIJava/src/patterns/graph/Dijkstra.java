package patterns.graph;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.*;

/*
 * You are given a 2D array heights[][] of size n x m, where heights[n][m] represents the height of the cell (n, m).

Find a path from the top-left corner to the bottom-right corner that minimizes the effort required to travel between consecutive points, where effort is defined as the absolute difference in height between two points. In a single step, you can either move up, down, left or right.

Return the minimum effort required for any path from the first point to the last.

Examples

Example 1:

Input: heights =
 [[1,2,3],
  [3,8,4],
  [5,3,5]]
 * 
 */
public class MinEffort {

    class Edge {
        int to;
        int w;
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
         }
    }

    private Map<Integer, List<Edge>> edges = new HashMap<>();


    private void connect(int u, int v, int w) {
        Edge e =  new Edge(v,u);
        edges.computeIfAbsent(u, x -> new LinkedList<>());
        edges.get(u).add(e);
    }


    public int minEffort(int[][] height) {
        int R = height.length;
        int C =   height[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i > 0) {
                    int v = i * C + j;
                    int vu = (i - 1) * C + j;
                    int w = Math.abs(height[i][j] - height[i-1][j]);
                    connect(v,vu, w);
                    connect(vu,v,w); // revisit
                }

                if (j > 0) {
                    int v =  i*C + j;
                    int vl = i*C + j -1;
                    int w = Math.abs(height[i][j] - height[i][j-1]);
                    connect(v,vl, w);
                    connect(vl,v, w);
                }

            }
        }
        int[] dist = new int[R*C];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Edge> minPQ =  new PriorityQueue<>((a,b) -> a.w - b.w);
        Map<Integer, Integer> parent = new HashMap<>();
        minPQ.offer(new Edge(0, 0));
        dist[0] = 0;
        for (int i =0; i < R*C; i++) {
            parent.put(i, -1);
        }
        while (!minPQ.isEmpty()) {
            Edge e = minPQ.poll();
            int u = e.to;
            for (Edge nei : edges.get(e.to)) {
                int v = nei.to;
                if (dist[u] + nei.w < dist[v]) {
                    dist[v] = dist[u] + nei.w;
                    parent.put(v, u);
                    minPQ.offer(nei);
                }
            }

        }
        return dist[R*C-1];

    }
    
}
