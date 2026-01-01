package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayDeque;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        var queue = new ArrayDeque<int[]>();
        var freshOrangesCount = 0;
        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[] {row, col});
                } else if (grid[row][col] == 1) {
                    freshOrangesCount++;
                }
            }
        }
        if (queue.isEmpty() || freshOrangesCount == 0) {
            if (freshOrangesCount > 0) {
                return -1;
            }
            return 0;
        }
        // if rotted oranges are left, then return -1
        // if there are no fresh oranges, then return 0
        // if there are no rotten oranges and no fresh ones, then return 0
        // if there are fresh oranges and no rotten ones, then return -1
        var steps = -1;
        var directions = new int[][] { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var cell = queue.poll();
                for (var direction : directions) {
                    var x = cell[0] + direction[0];
                    var y = cell[1] + direction[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 2 || grid[x][y] == 0) {
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.offer(new int[] {x, y});
                    freshOrangesCount--;
                }
            }
            steps++;
        }
        return freshOrangesCount > 0 ? -1 : steps;
    }
}
