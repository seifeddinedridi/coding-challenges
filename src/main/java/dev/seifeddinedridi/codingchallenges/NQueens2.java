package dev.seifeddinedridi.codingchallenges;

class NQueens2 {

    private static final int BITS_PER_CELL = 1;
    private static final int CELLS_PER_ROW = 16 / BITS_PER_CELL; // = 16

    public int totalNQueens(int n) {
        // we need columns
        var count = new int[] {0};
        canVisit(0, 0, 0, 0, n, count);
        return count[0];
    }

    private void canVisit(int r, int column, int diagonalLeft, int diagonalRight, int n, int[] count) {
        if (r == n) {
            count[0]++;
            return;
        }
        for (int c = 0; c < n; c++) {
            var isColSafe = ((1 << (n - 1 - c)) & column) == 0;
            var isDiagonaLSafe = ((1 << (r + c)) & diagonalLeft) == 0;
            var isDiagonaRSafe = ((1 << (n - r + c)) & diagonalRight) == 0;
            if (isColSafe && isDiagonaLSafe && isDiagonaRSafe) {
                // Place a queen
                canVisit(r + 1, (1 << (n - 1- c)) | column,
                    (1 << (r + c)) | diagonalLeft,
                    (1 << (n - r + c)) | diagonalRight, n, count);
            }
        }
    }

    public int totalNQueensSlow(int n) {
        var map = new short[n];
        var count = new int[] {0};
        canVisit(map, 0, count);
        return count[0];
    }

    private void canVisit(short[] map, int r, int[] count) {
        if (r == map.length) {
            count[0]++;
            return;
        }
        for (int c = 0; c < map.length; c++) {
            if (isSafe(map, r, c)) {
                // Place a queen
                setValue(map, r, c, true);
                canVisit(map, r + 1, count);
                // Unplace the queen
                setValue(map, r, c, false);
            }
        }
    }

    private boolean isSafe(short[] map, int r, int c) {
        int rr = r;
        int cc = c;
        // Diagonal check left
        while (r >= 0 && c >= 0) {
            if (getValue(map, r, c)) {
                return false;
            }
            r--;
            c--;
        }
        r = rr;
        c = cc;
        // Diagonal check right
        while (r >= 0 && c < map.length) {
            if (getValue(map, r, c)) {
                return false;
            }
            r--;
            c++;
        }
        r = rr;
        c = cc;
        // Column check top
        while (r >= 0) {
            if (getValue(map, r, c)) {
                return false;
            }
            r--;
        }
        return true;
    }

    private boolean getValue(short[] map, int row, int col) {
        int shift = (CELLS_PER_ROW - 1 - col) * BITS_PER_CELL;
        return ((map[row] >> shift) & 0x1) == 1;
    }

    // Set 1-bit cell at (row, col) to value (0..1)
    private void setValue(short[] map, int row, int col, boolean value) {
        var shift = (CELLS_PER_ROW - 1 - col) * BITS_PER_CELL;
        var mask = 0x1 << shift;
        map[row] &= (short) ~mask; // Clear the 1 bit
        map[row] |= (short) ((value ? 1 : 0) << shift); // Set new value
    }
}
