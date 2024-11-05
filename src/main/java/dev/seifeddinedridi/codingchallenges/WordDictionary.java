package dev.seifeddinedridi.codingchallenges;

public class WordDictionary {

    private static class TrieNode {
        boolean isTerminal;
        TrieNode[] children = new TrieNode[26];

        TrieNode() {}

        TrieNode(boolean isTerminal) {
            this.isTerminal = isTerminal;
        }
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        var node = root;
        for (int i = 0; i < word.length(); i++) {
            var c = word.charAt(i);
            int ci = c - 'a';
            if (node.children[ci] == null) {
                node.children[ci] = new TrieNode();
            }
            node = node.children[ci];
        }
        node.isTerminal = true;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(TrieNode node, String word, int index) {
        if (index <= word.length()) {
            if (index == word.length()) {
                return node.isTerminal;
            } else {
                var c = word.charAt(index);
                var ci = c - 'a';
                if (c != '.' && node.children[ci] == null) {
                    return false;
                } else if (c == '.') {
                    for (var n : node.children) {
                        if (n != null && search(n, word, index + 1)) {
                            return true;
                        }
                    }
                } else {
                    return search(node.children[ci], word, index + 1);
                }
            }
        }
        return false;
    }
}
