package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayDeque;

public class NearestExistFromEntranceInMaze {

    public int nearestExit(char[][] maze, int[] entrance) {
        var queue = new ArrayDeque<int[]>();
        var x = entrance[0];
        var y = entrance[1];
        maze[x][y] = '+';
        queue.offer(new int[]{x, y});
        int steps = 0;
        var directions = new int[][] { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var cell = queue.poll();
                for (var direction : directions) {
                    x = cell[0] + direction[0];
                    y = cell[1] + direction[1];
                    if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == '+') {
                        continue;
                    }
                    if ((x == maze.length - 1 || x == 0 || y == 0 || y == maze[0].length - 1)) {
                        return steps + 1;
                    }
                    maze[x][y] = '+';
                    queue.offer(new int[]{x, y});
                }
            }
            steps++;
        }
        return -1;
    }
}
