package dev.seifeddinedridi.codingchallenges;

public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        var m = obstacleGrid.length;
        var n = obstacleGrid[m - 1].length;
        if (obstacleGrid[m - 1][n - 1] == 1) {
            // Impossible to reach destination
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        var paths = new int[m][n];
        for (int i = m - 2; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] == 1) {
                break;
            }
            paths[i][n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] == 1) {
                break;
            }
            paths[m - 1][i] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                // Check if the current cell can reach the cell below or to the right
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                if (obstacleGrid[i + 1][j] == 0) {
                    paths[i][j] += paths[i + 1][j];
                }
                if (obstacleGrid[i][j + 1] == 0) {
                    paths[i][j] += paths[i][j + 1];
                }
            }
        }
        return paths[0][0];
    }
}
