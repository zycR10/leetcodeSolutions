package org.leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.') {
                    // number in row
                    if (!seen.add(number + " in row " + i) ||
                            // number in column
                            !seen.add(number + " in column " + j) ||
                            // number in gird
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3))
                        return false;
                }
            }
        }
        return true;
    }
}
