package patterns.graph;

import java.util.*;

/*
 *    0
 * 1    2
 */

public class Bipartite {
    public boolean isBipartite(int[][] graph) {
        int V  = graph.length;
        UnionFind uf = new UnionFind(V);
        for (int u = 0; u < V; u++) {
            int f = -1;
           for (int v = 0; v < V ; v++) {
            if (graph[u][v] ==  1) {
                if (uf.find(u,v)) {
                    return false;
                }
                if (f == -1) {
                    f = v;
                }
                uf.union(f,v);

            }
           }
        }
        return true; 

    }
}
