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

public class ProvincesCount {

    public int countProvinces(int[][] roads) {
        int N = roads.length;
        int[] visited = new int[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                visit(roads, i, visited);
                count++;
            }
        }
        return count;
    }

    private void visit(int[][] road, int i, int[] visited) {
       int N = road.length;
       visited[i] = 1;
       for (int j = 0; j < N; j++) {
         if (road[i][j] == 1 && visited[j] == 0) {
            visit(road, j, visited);
         }
       }
        
    }
    
}
