package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/implement-trie-prefix-tree

public class TriePrefixTree {

    private static class TrieNode {
        TrieNode[] children;
        boolean isTerminal;

        TrieNode(TrieNode[] children, boolean isTerminal) {
            this.children = children;
            this.isTerminal = isTerminal;
        }
    }

    private final TrieNode root;

    public TriePrefixTree() {
        this.root = new TrieNode(new TrieNode[26], false);
    }
    
    public void insert(String word) {
        var node = root;
        for (int i = 0; i < word.length(); i++) {
            // Check if the char exists on the current node
            var currentChar = word.charAt(i);
            var charIndex = Character.toLowerCase(currentChar) - 'a';
            if (node.children[charIndex] == null) {
                node.children[charIndex] = new TrieNode(new TrieNode[26], false);
            }
            node = node.children[charIndex];
        }
        if (node != root) {
            node.isTerminal = true;
        }
    }

    public boolean search(String word, boolean startsWith) {
        var node = root;
        for (int i = 0; i < word.length(); i++) {
            var currentChar = word.charAt(i);
            var charIndex = Character.toLowerCase(currentChar) - 'a';
            node = node.children[charIndex];
            if (node == null) {
                return false;
            }
        }
        return node.isTerminal || startsWith;
    }

    public boolean search(String word) {
        return search(word, false);
    }

    public boolean startsWith(String prefix) {
        return search(prefix, true);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */