package dev.seifeddinedridi.codingchallenges;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        var dp = new int[m][n];
        for (var i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (var i = 0; i < n; i++) {
            dp[m - 1][i] = 1;
        }
        for (int r = m - 2; r >= 0; r--) {
            for (int c = n - 2; c >= 0; c--) {
                dp[r][c] = dp[r + 1][c] + dp[r][c + 1];
            }
        }
        return dp[0][0];
    }
}
