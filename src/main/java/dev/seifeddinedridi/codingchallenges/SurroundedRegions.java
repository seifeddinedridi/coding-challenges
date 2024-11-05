package dev.seifeddinedridi.codingchallenges;

import java.util.*;

public class SurroundedRegions {

    public void solve(char[][] board) {
        var m = board.length;
        var n = board[0].length;
        var i = 1;
        var j = 1;
        var visitedCells = new boolean[m][n];
        while (i < m) {
            var visitedNodeIds = new HashSet<Integer>();
            if (!visitedCells[i][j] && board[i][j] == 'O'
                    && !isConnectedToPerimeter(board, m, n, visitedNodeIds, i, j)) {
                // Mark all visited nodes as visited and replace their 'O' with 'X'
                for (var nodeId : visitedNodeIds) {
                    var xi = nodeId / n;
                    var xj = nodeId % n;
                    board[xi][xj] = 'X';
                    visitedCells[xi][xj] = true;
                }
            }
            j++;
            if (j == n) {
                i++;
                j = 0;
            }
        }
    }

    public void solveBFS(char[][] board) {
        // A region has to be surrounded by X from all 4 directions
        // A cell is surrounded if it its upper, lower, left and right cells are all X
        // Or is adjacent to another by another 0 from one or more sides

        // A valid region should not be on the border
        // Create a boolean field marking which regions have to be flipped
        // Discard the bit field when the region is not valid
        var m = board.length;
        var n = board[m - 1].length;
        var visitedCells = new boolean[m][n];
        var i = 1;
        var j = 1;
        var queue = new LinkedList<Integer>();
        while (i < m) {
            while (i < m && (board[i][j] == 'X' || visitedCells[i][j])) {
                j++;
                if (j == n) {
                    i++;
                    j = 0;
                }
            }
            if (i < m && j < n) {
                queue.add(i * n + j);
            }
            var isValidRegion = true;
            var visitedCellsSet = new ArrayList<List<Integer>>();
            while (!queue.isEmpty()) {
                var nodeId = queue.poll();
                var xi = nodeId / n;
                var xj = nodeId % n;
                // The current cell is on the border so it is not part of a valid region
                if (xi == 0 || xi == m - 1 || xj == 0 || xj == n - 1) {
                    isValidRegion = false;
                }
                visitedCells[xi][xj] = true;
                visitedCellsSet.add(List.of(xi, xj));
                // Top
                if (xi > 0 && board[xi - 1][xj] == 'O' && !visitedCells[xi - 1][xj]) {
                    queue.add((xi - 1) * n + xj);
                }
                // Bottom
                if (xi + 1 < m && board[xi + 1][xj] == 'O' && !visitedCells[xi + 1][xj]) {
                    queue.add((xi + 1) * n + xj);
                }
                // // Left
                if (xj > 0 && board[xi][xj - 1] == 'O' && !visitedCells[xi][xj - 1]) {
                    queue.add(xi * n + xj - 1);
                }
                // Right
                if (xj + 1 < n && board[xi][xj + 1] == 'O' && !visitedCells[xi][xj + 1]) {
                    queue.add(xi * n + xj + 1);
                }
            }
            if (isValidRegion) {
                for (var node : visitedCellsSet) {
                    board[node.get(0)][node.get(1)] = 'X';
                }
            }
        }
    }

    private boolean isConnectedToPerimeter(char[][] board, int m, int n, Set<Integer> visitedNodes, int i, int j) {
        if ((i == 0 || i == m - 1 || j == 0 || j == n - 1)) {
            // We ended up on a cell that has a 'O'
            return board[i][j] == 'O';
        }
        // We should not be traversing the nodes unless the current node has a 'O' and it has not been visited
        var ans = false;
        if (!visitedNodes.contains(i * n + j)) {
            visitedNodes.add(i * n + j);
            ans = (i + 1 < m && board[i + 1][j] == 'O' && isConnectedToPerimeter(board, m, n, visitedNodes, i + 1, j))
                    || (i > 0 && board[i - 1][j] == 'O' && isConnectedToPerimeter(board, m, n, visitedNodes, i - 1, j))
                    || (j + 1 < n && board[i][j + 1] == 'O' && isConnectedToPerimeter(board, m, n, visitedNodes, i, j + 1))
                    || (j > 0 && board[i][j - 1] == 'O' && isConnectedToPerimeter(board, m, n, visitedNodes, i, j - 1));
        }
        return ans;
    }
}
