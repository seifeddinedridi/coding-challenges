package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/rotate-image

public class RotateImage {
    public void rotate(int[][] matrix) {
        // This is a matrix transpose operation
        for (int r = 0; r < matrix.length; r++) {
            for (int c = r + 1; c < matrix.length; c++) {
                var temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
            for (int c = 0; c < matrix.length / 2; c++) {
                var temp = matrix[r][c];
                matrix[r][c] = matrix[r][matrix.length - 1 - c];
                matrix[r][matrix.length - 1 - c] = temp;
            }
        }
    }
}