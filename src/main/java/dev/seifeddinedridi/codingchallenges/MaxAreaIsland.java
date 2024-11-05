package dev.seifeddinedridi.codingchallenges;

import java.util.LinkedList;

public class MaxAreaIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        // Create a boolean matrix of the same size to flag visited cells
        // Go over each cell, if it was not visited, increase the cell count
        // Then add its 4 neighbors the queue of cells to visit
        // Break when the queue is empty
        // We can avoid the extra storage by changing the value of visited cells to 0
        var maxSize = 0;
        var m = grid.length;
        var n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    var queue = new LinkedList<Integer>();
                    queue.add(i * n + j);
                    var islandSize = 0;
                    while (!queue.isEmpty()) {
                        var cellId = queue.poll();
                        var x = cellId / n;
                        var y = cellId % n;
                        if (grid[x][y] == 0) {
                            continue;
                        }
                        grid[x][y] = 0;
                        islandSize++;
                        if (x + 1 < m && grid[x + 1][y] != 0) {
                            queue.add((x + 1) * n + y);
                        }
                        if (x - 1 >= 0 && grid[x - 1][y] != 0) {
                            queue.add((x - 1) * n + y);
                        }
                        if (y + 1 < n && grid[x][y + 1] != 0) {
                            queue.add(x * n + y + 1);
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] != 0) {
                            queue.add(x * n + y - 1);
                        }
                    }
                    maxSize = Math.max(maxSize, islandSize);
                }
            }
        }
        return maxSize;
    }
}
