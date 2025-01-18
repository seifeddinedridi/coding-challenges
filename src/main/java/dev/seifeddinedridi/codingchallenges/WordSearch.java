package dev.seifeddinedridi.codingchallenges;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty()
                || board.length == 0
                || board.length * board[0].length < word.length()) {
            return false;
        } else if (board.length == 1) {
            return new String(board[0]).contains(word)
                    || new StringBuilder(new String(board[0])).reverse().toString().equals(word);
        }
        var initial = word.charAt(0);
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (initial == board[r][c]
                        && exist(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int r, int c, int index) {
        if (index == word.length() - 1 && word.charAt(index) == board[r][c]) {
            return true;
        } else if (word.charAt(index) != board[r][c]
                || board[r][c] == '.') {
            return false;
        }
        board[r][c] = '.';
        var offsets = new int[] {-1, 1};
        for (var offset : offsets) {
            if (c + offset < 0 || c + offset >= board[r].length) {
                continue;
            }
            if (exist(board, word, r, c + offset, index + 1)) {
                return true;
            }
        }
        for (var offset : offsets) {
            if (r + offset < 0 || r + offset >= board.length) {
                continue;
            }
            if (exist(board, word, r + offset, c, index + 1)) {
                return true;
            }
        }
        board[r][c] = word.charAt(index);
        return false;
    }
}
