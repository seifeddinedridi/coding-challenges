package dev.seifeddinedridi.codingchallenges;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        var m = matrix.length;
        var n = matrix[0].length;
        return searchMatrix(matrix, 0, m * n, target);
    }

    public boolean searchMatrixSlow(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        var i = 0;
        while (i < matrix.length) {
            if (target >= matrix[i][0]
                    && (i == matrix.length - 1 || target < matrix[i + 1][0])) {
                for (int k = 0; k < matrix[i].length; k++) {
                    if (matrix[i][k] == target) {
                        return true;
                    }
                }
                return false;
            }
            i++;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int start, int end, int target) {
        var m = matrix.length;
        var n = matrix[0].length;
        if (end - start <= 1) {
            var indexes = convertToIndices(n, start);
            if (matrix[indexes[0]][indexes[1]] == target) {
                return true;
            }
            return false;
        }
        var median = (start + end) / 2;
        var indexes = convertToIndices(n, median);
        if (target < matrix[indexes[0]][indexes[1]]) {
            return searchMatrix(matrix, start, median, target);
        } else {
            return searchMatrix(matrix, median, end, target);
        }
    }

    int[] convertToIndices(int n, int index) {
        var i = index / n;
        var j = index % n;
        return new int[]{i, j};
    }
}
