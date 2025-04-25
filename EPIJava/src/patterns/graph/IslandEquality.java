package patterns.graph;

import java.util.HashSet;
import java.util.Set;

/*
 * You are given a 2D matrix containing only 1s (land) and 0s (water).

An island is a connected set of 1s (land) and is surrounded by either an edge or 0s (water). Each cell is considered connected to other cells horizontally or vertically (not diagonally).

Two islands are considered the same if and only if they can be translated (not rotated or reflected) to equal each other.

Write a function to find the number of distinct islands in the given matrix.
 * 
 * 
 */
public class IslandEquality {

    public int findUniqueIsland(int[][] matrix) {
        int R =  matrix.length;
        int C = matrix[0].length;
        Set<String> isLands = new HashSet<>();

        boolean[] visited = new boolean[R*C];

        for (int i = 0; i<R; i++) {
            for (int j =0; j<C; j++) {
                if(matrix[i][j] == 1 && visited[i*C+j]  == false) {
                    StringBuilder path = new StringBuilder();
                    dfs(i, j, matrix, visited, path, "");
                    isLands.add(path.toString());
                }
            }
        }
        if (isLands.size() == 0) return 0;
        return isLands.size();
    }
    
    private void dfs(int i, int j, int[][] matrix, boolean[] visited, StringBuilder path, String dir) {
        int C = matrix[0].length;
        if (i < 0 || i >= matrix.length || j >= C || j < 0) {
            return;
        }
        if (matrix[i][j] == 0 || visited[i * C + j]) {
            return;
        }
        visited[i * C + j] = true;
        path.append(dir);
        dfs(i+1, j, matrix, visited, path, "u");
        dfs(i-1, j, matrix, visited, path, "d");
        dfs(i, j+1, matrix, visited, path,"r" );
        dfs(i, j-1, matrix, visited, path, "l");
    }
}
