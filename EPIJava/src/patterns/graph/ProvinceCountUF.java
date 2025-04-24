package patterns.graph;
/*
 * There are n cities. Some of them are connected in a network. 
 * If City A is directly connected to City B, and City B is directly connected to City C, city A is indirectly connected to City C.
If a group of cities are connected directly or indirectly, they form a province.
Given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise, determine the total number of provinces.
 * 
 *  0 0 0 1
 *  0 0 1 1
 *  0 0 0 1
 *  0 0 0 0
 * 
 * A B C
 * 1 1 0   A - B
 *         B - C
 * 0 1 1
 * 0 0 1
 * 
 */
public class ProvinceCountUF {

    public int getCount(int[][] connections) {
        int V = connections.length;
        int pCount = V;
        UnionFind uf  = new UnionFind(V);
        for (int i = 0; i<V; i++) {
            for (int j =0; j < V ; j++) {
                if (connections[i][j] == 1) {
                    if (uf.find(i, j)) {
                        pCount--;
                    } else {
                        uf.union(i, j);
                    }
                }
            }
        }
        return pCount;
    }
    
}
