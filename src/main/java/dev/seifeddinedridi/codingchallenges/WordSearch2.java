package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordSearch2 {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        var trie = buildTrie(words);
        var uniqueWords = Set.of(words).size();
        var foundWords = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (trie.children[board[i][j] - 'a'] != null) {
                    searchWords(board, i, j, foundWords, trie);
                    if (foundWords.size() == uniqueWords) {
                        break;
                    }
                }
            }
        }
        return foundWords;
    }

    private TrieNode buildTrie(String[] words) {
        var root = new TrieNode();
        for (var word : words) {
            var node = root;
            for (var c : word.toCharArray()) {
                // Check if the char exists on the current node
                var charIndex = c - 'a';
                if (node.children[charIndex] == null) {
                    node.children[charIndex] = new TrieNode();
                }
                node = node.children[charIndex];
            }
            node.word = word;
        }
        return root;
    }

    private void searchWords(char[][] board, int i, int j, List<String> foundWords, TrieNode trie) {
        var c = board[i][j];
        if (c == 0) {
            return;
        }
        var next = trie.children[c - 'a'];
        if (next == null) {
            return;
        }
        if (next.word != null) {
            // Found one
            foundWords.add(next.word);
            // Remove duplicates
            next.word = null;
        }
        board[i][j] = 0;
        if (i + 1 < board.length)
            searchWords(board, i + 1, j, foundWords, next);
        if (i > 0)
            searchWords(board, i - 1, j, foundWords, next);
        if (j + 1 < board[i].length)
            searchWords(board, i, j + 1, foundWords, next);
        if (j > 0)
            searchWords(board, i, j - 1, foundWords, next);
        board[i][j] = c;
    }
}
