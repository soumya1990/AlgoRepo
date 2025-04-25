package patterns.graph;

public class UnionFind {

    int[] parent;
    int[] rank;

    public UnionFind(int V) {
        parent = new int[V];
        rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private int findParent(int v) {
     /*    while (parent[v] != v) {
            int tmp = v;
            v = parent[v];
            parent[tmp] = parent[v];
        }
        return v;*/

        if (parent[v] != v) {
            parent[v] = findParent(parent[v]);
        }
        return parent[v];
    }

    public boolean find(int u, int v) {
        if (findParent(u) == findParent(v)) {
            return true;
        }
        return false;
    }

    public void union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (rank[pu] < rank[pv]) {
            parent[pu] = parent[pv];
        } else if ( rank[pv] < rank[pu]) {
            parent[pv] = parent[pu];
        } else {
            parent[pv] = parent[pu];
            rank[pu]++;
        }
    }

}
