package dev.seifeddinedridi.codingchallenges;

public class GameOfLife {

    private static final int ALIVE_TO_DEAD_CODE = 2;
    private static final int DEAD_TO_ALIVE_CODE = 3;

    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        var m = board.length;
        var n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canApplyRule1(board, i, j) || canApplyRule3(board, i, j)) {
                    board[i][j] = ALIVE_TO_DEAD_CODE;
                } else if (canApplyRule2(board, i, j)) {
                    board[i][j] = 1;
                } else if (canApplyRule4(board, i, j)) {
                    board[i][j] = DEAD_TO_ALIVE_CODE;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == 1 || board[i][j] == DEAD_TO_ALIVE_CODE ? 1 : 0;
            }
        }
    }

    private boolean canApplyRule1(int[][] board, int i, int j) {
        return (board[i][j] == 1 || board[i][j] == ALIVE_TO_DEAD_CODE) && countAliveCells(board, i, j) < 2;
    }

    private boolean canApplyRule2(int[][] board, int i, int j) {
        var aliveCells = countAliveCells(board, i, j);
        return (board[i][j] == 1 || board[i][j] == ALIVE_TO_DEAD_CODE) && (aliveCells == 2 || aliveCells == 3);
    }

    private boolean canApplyRule3(int[][] board, int i, int j) {
        return (board[i][j] == 1 || board[i][j] == ALIVE_TO_DEAD_CODE) && countAliveCells(board, i, j) > 3;
    }

    private boolean canApplyRule4(int[][] board, int i, int j) {
        return (board[i][j] == 0 || board[i][j] == DEAD_TO_ALIVE_CODE) && countAliveCells(board, i, j) == 3;
    }

    private int countAliveCells(int[][] board, int i, int j) {
        if (board.length == 0 || board[0].length == 0) {
            return 0;
        }
        var count = 0;
        var m = board.length;
        var n = board[0].length;
        for (int x = i - 1; x <= Math.min(i + 1, m - 1); x++) {
            if (x < 0) {
                continue;
            }
            for (int y = j - 1; y <= Math.min(j + 1, n - 1); y++) {
                if (y < 0) {
                    continue;
                }
                count += board[x][y] == 1 || board[x][y] == ALIVE_TO_DEAD_CODE ? 1 : 0;
            }
        }
        return count - board[i][j];
    }
}
