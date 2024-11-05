package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/maximal-square

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        var m = matrix.length;
        var n = matrix[0].length;
        var data = new int[m][n];
        // 1 0 1 0 0
        // 1 0 1 1 1
        // 1 1 1 1 1
        // 1 0 0 1 0
        var largest = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == '1') {
                    data[r][c] = 1;
                    if (c > 0 && r > 0 && data[r - 1][c - 1] > 0 && data[r][c - 1] > 0 && data[r - 1][c] > 0) {
                        data[r][c] += Math.min(Math.min(data[r - 1][c - 1], data[r][c - 1]), data[r - 1][c]);
                    }
                    largest = Math.max(largest, data[r][c] * data[r][c]);
                }
            }   
        }
        return largest;
    }

    public int maximalSquare2(char[][] matrix) {
        // Maximal square has 1s in every one of its cells
        // At the every cell (r, c) the maximum square length is min(m - r, n - c)
        // Skip cells whose value is not 1
        // If there is a square of size N then there are also squares of sizes N - 1, N - 2,...,1
        var r = 0;
        var c = 0;
        var m = matrix.length;
        var n = matrix[0].length;
        var maxSquareSize = 0;
        while (r < m) {
            while (r < m && matrix[r][c] == '0') {
                c++;
                if (c == n) {
                    c = 0;
                    r++;
                }
            }
            if (r < m && c < n) {
                // We found a cell with value 1
                // Find the largest square
                maxSquareSize = Math.max(maxSquareSize, 1);
                var maxLength = Math.min(m - r, n - c);
                var foundOneSquare = false;
                var s = maxLength;
                var ri = 0;
                var ci = 0;
                while (s > 1 && !foundOneSquare) {
                    var found = true;
                    for (int i = 0; i < s * s; i++) {
                        ri = r + (i / s);
                        ci = c + (i % s);
                        if (matrix[ri][ci] == '0') {
                            found = false;
                            break;
                        }
                    }
                    if (found) {
                        maxSquareSize = Math.max(maxSquareSize, s * s);
                        foundOneSquare = true;
                    }
                    s--;
                }
                c++;
                if (ri == m - 1 && ci == n - 1) {
                    return maxSquareSize;
                }
                if (c == n) {
                    r++;
                    c = 0;
                }
            }
        }
        return maxSquareSize;
    }
}