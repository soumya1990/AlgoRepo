package patterns.graph;
/*
 * You are given a 2D matrix containing different characters, you need to find if there exists any cycle consisting of the same character in the matrix.

A cycle is a path in the matrix that starts and ends at the same cell and has four or more cells. From a given cell, you can move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right), if it has the same character value of the current cell.

Write a function to find if the matrix has a cycle.
 */
public class CharacterCycle {

    public boolean hasCycle(char[][] matrix) {
        int R = matrix.length;
       int C =matrix[0].length;
       boolean[] visited = new boolean[R*C];

       for (int i =0; i < R; i++) {
           for  (int j = 0; j<C; j++) {
               if (visited[i*C+j] == false) {
                   StringBuilder sb = new StringBuilder();
                   if (dfs(i, j, matrix, visited, matrix[i][j], new int[]{-1,-1})) {
                       return true;
                   }
               }
           }
       }
       return false;
 }

     private boolean dfs(int i, int j, char[][] matrix, boolean[] visited, char p, int[] parent ) {
       int C = matrix[0].length;
       if (i < 0|| i >= matrix.length || j < 0 || j >= matrix[0].length) {
           return false;
       }
        if (matrix[i][j] != p ) {
           return false;
        }

        if (visited[i*C + j]) {
           return true;
        }
        visited[i*C + j] = true;
        if (i+1 != parent[0] && dfs(i+1, j, matrix, visited, matrix[i][j], new int[]{i,j})) return true;
        if (i-1 != parent[0] && dfs(i-1, j, matrix, visited, matrix[i][j], new int[]{i,j})) return true;
        if (j-1 != parent[1] && dfs(i, j-1, matrix, visited, matrix[i][j], new int[]{i,j})) return true;
        if (j+1 != parent[1] && dfs(i, j+1, matrix, visited, matrix[i][j], new int[]{i,j})) return true;
   
        return  false;
   }
    
}
