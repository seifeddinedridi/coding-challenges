package dev.seifeddinedridi.codingchallenges;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        // minPathSum(s, t) = sumOfValue(c1, c2, c3, ..., cN)
        // minPathSum(s, t) = value(c1) + minPathSum(c2, t)
        // minPathSum(c2, t) = value(c2) + minPathSum(c3, t)
        // minPathSum(c3, t) = value(c3) + minPathSum(c4, t)
        var data = new int[grid.length][grid[0].length];
        return minPathSumBottomUp(grid, data);
    }

    public int minPathSumBottomUp(int[][] grid, int[][] data) {
        for (int r = grid.length - 1; r >= 0; r--) {
            for (int c = grid[r].length - 1; c >= 0; c--) {
                var opt1 = Integer.MAX_VALUE;
                if (r + 1 < grid.length) {
                    opt1 = data[r + 1][c];
                }
                var opt2 = Integer.MAX_VALUE;
                if (c + 1 < grid[r].length) {
                    opt2 = data[r][c + 1];
                }
                if (opt1 == Integer.MAX_VALUE && opt2 == Integer.MAX_VALUE) {
                    data[r][c] = grid[r][c];
                } else if (opt1 == Integer.MAX_VALUE) {
                    data[r][c] = grid[r][c] + opt2;
                } else {
                    data[r][c] = grid[r][c] + Math.min(opt1, opt2);
                }
            }
        }
        return data[0][0];
    }

    public int minPathSumTopDown(int r, int c, int[][] grid, int[][] data) {
        if (r >= grid.length || c >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (data[r][c] == 0) {
            var opt1 = Integer.MAX_VALUE;
            if (r + 1 < grid.length) {
                opt1 = minPathSumTopDown(r + 1, c, grid, data);
            }
            var opt2 = Integer.MAX_VALUE;
            if (c + 1 < grid[0].length) {
                opt2 = minPathSumTopDown(r, c + 1, grid, data);
            }
            if (opt1 == Integer.MAX_VALUE && opt2 == Integer.MAX_VALUE) {
                data[r][c] = grid[r][c];
            } else if (opt1 == Integer.MAX_VALUE) {
                data[r][c] = grid[r][c] + opt2;
            } else {
                data[r][c] = grid[r][c] + Math.min(opt1, opt2);
            }
        }
        return data[r][c];
    }
}
