package dev.seifeddinedridi.codingchallenges;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        var r = 0;
        var c = 0;
        var m = matrix.length;
        var n = matrix[m - 1].length;
        var zeroOutFirstRow = false;
        var zeroOutFirstColumn = false;
        while (r < m) {
            if (r == 0) {
                zeroOutFirstRow = zeroOutFirstRow || matrix[0][c] == 0;
            }
            if (c == 0) {
                zeroOutFirstColumn = zeroOutFirstColumn || matrix[r][0] == 0;
            }
            if (matrix[r][c] == 0) {
                matrix[r][0] = 0;
                matrix[0][c] = 0;
            }
            c++;
            if (c == n) {
                c = 0;
                r++;
            }
        }
        for (var i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (var i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (zeroOutFirstRow) {
            for (int j = 1; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (zeroOutFirstColumn) {
            for (int j = 1; j < m; j++) {
                matrix[j][0] = 0;
            }
        }
    }

    public void setZeroesMaskBased(int[][] matrix) {
        int mask = -999;
        if (matrix.length == 0) {
            return;
        }
        var r = 0;
        var c = 0;
        var m = matrix.length;
        var n = matrix[m - 1].length;
        while (r < m) {
            if (matrix[r][c] == 0) {
                matrix[r][c] = mask;
            }
            c++;
            if (c == n) {
                c = 0;
                r++;
            }
        }
        r = 0;
        while (r < m) {
            if (matrix[r][c] == mask) {
                matrix[r][c] = 0;
                // Fill up row with zeros
                for (int j = 0; j < n; j++) {
                    if (matrix[r][j] != mask) {
                        matrix[r][j] = 0;
                    }
                }
                // Fill up column with zeros
                for (int j = 0; j < m; j++) {
                    if (matrix[j][c] != mask) {
                        matrix[j][c] = 0;
                    }
                }
            }
            c++;
            if (c == n) {
                c = 0;
                r++;
            }
        }
    }
}
