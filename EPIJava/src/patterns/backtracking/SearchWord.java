package patterns.backtracking;

import java.util.*;

/*
 * Given an m x n grid of characters board and a string word, return true if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
The same letter cell may not be used more than once.

Example 1:

Input: word="ABCCED", board:

  { 'A', 'B', 'C', 'E' },
  { 'S', 'F', 'C', 'S' },
  { 'A', 'D', 'E', 'E' }
Output: true
 * 
 */
public class SearchWord {

    public boolean searchWord(char[][] m, String word) {
        int R = m.length;
        int C = m[0].length;
        Set<Integer> counted = new HashSet<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (searchWord(m, word, i, j, 0, counted)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean searchWord(char[][] m, String word, int i, int j, int mIdx, Set<Integer> counted) {
        int R = m.length;
        int C = m[0].length;
        if (mIdx >= word.length()) {
            return true;
        }
        if (i < 0 || i >= R || j < 0 || j >= C) {
            return false;
        }

        if (m[i][j] == word.charAt(mIdx)) {
            // Avoid counting already counted words
            if (counted.contains(i * C + j)) {
                return false;
            }
            counted.add(i * C + j);
            return searchWord(m, word, i + 1, j, mIdx + 1, counted) || searchWord(m, word, i - 1, j, mIdx + 1, counted)
                    || searchWord(m, word, i, j + 1, mIdx + 1, counted)
                    || searchWord(m, word, i, j - 1, mIdx + 1, counted);
        }

        return false;
    }
}
