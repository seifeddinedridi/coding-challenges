package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/valid-sudoku

import java.util.stream.IntStream;
import java.util.Set;
import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // To validate the columns and rows for reptition
        // we can store the results of the validation in a boolean matrix

        // Validate rows
        for (int j = 0; j < board.length; j++) {
            final int index = j;
            var list = IntStream.range(0, board[j].length)
                .filter(x -> board[index][x] != '.')
                .map(x -> ((int) board[index][x]))
                .boxed()
                .toList();
            var set = list.stream().collect(HashSet::new, Set::add, Set::addAll);
            if (set.size() != list.size()) {
                return false;
            }
        }
        // Validate columns
        for (int j = 0; j < board.length; j++) {
            final int index = j;
            var list = IntStream.range(0, board.length)
                .filter(x -> board[x][index] != '.')
                .map(x -> ((int) board[x][index]))
                .boxed()
                .toList();
            var set = list.stream().collect(HashSet::new, Set::add, Set::addAll);
            if (set.size() != list.size()) {
                return false;
            }
        }
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                // Validate the subbox
                var set = new HashSet<Integer>();
                var n = board[3 * r][3 * c];
                if (n != '.') {
                    if (set.contains((int) n)) {
                        return false;
                    }
                    set.add((int) n);
                }
                n = board[3 * r][3 * c + 1];
                if (n != '.') {
                    if (set.contains((int) n)) {
                        return false;
                    }
                    set.add((int) n);
                }
                n = board[3 * r][3 * c + 2];
                if (n != '.') {
                    if (set.contains((int) n)) {
                        return false;
                    }
                    set.add((int) n);
                }
                n = board[3 * r + 1][3 * c];
                if (n != '.') {
                    if (set.contains((int) n)) {
                        return false;
                    }
                    set.add((int) n);
                }
                n = board[3 * r + 1][3 * c + 1];
                if (n != '.') {
                    if (set.contains((int) n)) {
                        return false;
                    }
                    set.add((int) n);
                }
                n = board[3 * r + 1][3 * c + 2];
                if (n != '.') {
                    if (set.contains((int) n)) {
                        return false;
                    }
                    set.add((int) n);
                }
                n = board[3 * r + 2][3 * c];
                if (n != '.') {
                    if (set.contains((int) n)) {
                        return false;
                    }
                    set.add((int) n);
                }
                n = board[3 * r + 2][3 * c + 1];
                if (n != '.') {
                    if (set.contains((int) n)) {
                        return false;
                    }
                    set.add((int) n);
                }
                n = board[3 * r + 2][3 * c + 2];
                if (n != '.') {
                    if (set.contains((int) n)) {
                        return false;
                    }
                }

            }
        }
        return true;
    }
}