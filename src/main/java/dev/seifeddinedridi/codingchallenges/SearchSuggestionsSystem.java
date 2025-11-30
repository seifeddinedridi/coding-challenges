package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {

    record TrieNode(TrieNode[] children, List<Integer> wordIndices) {
        public TrieNode() {
            this(new TrieNode[26], new ArrayList<>());
        }

        public TrieNode(TrieNode[] children, List<Integer> wordIndices) {
            this.children = children;
            this.wordIndices = wordIndices;
        }
    }

    static class Trie {

        private final TrieNode root;

        private Trie() {
            this.root = new TrieNode();
        }

        public Trie(String[] words) {
            this.root = new TrieNode();
            for (var i = 0; i < words.length; i++) {
                addWord(words[i], i);
            }
        }

        public void addWord(String word, int wordIndex) {
            var node = root;
            for (int i = 0; i < word.length(); i++) {
                var nodeIndex = word.charAt(i) - 'a';
                if (node.children[nodeIndex] == null) {
                    node.children[nodeIndex] = new TrieNode();
                }
                if (node.children[nodeIndex].wordIndices.size() < 3) {
                    node.children[nodeIndex].wordIndices.add(wordIndex);
                }
                node = node.children[nodeIndex];
            }
        }

        public List<List<String>> findWords(String[] words, String searchWord) {
            var foundWords = new ArrayList<List<String>>();
            var node = root;
            for (int i = 0; i < searchWord.length(); i++) {
                var nodeIndex = searchWord.charAt(i) - 'a';
                if (node.children[nodeIndex] == null) {
                    for (int j = i; j < searchWord.length(); j++) {
                        foundWords.add(List.of());
                    }
                    break;
                }
                // A matching word was found
                var wordList = new ArrayList<String>();
                for (var wordIndex : node.children[nodeIndex].wordIndices) {
                    wordList.add(words[wordIndex]);
                }
                foundWords.add(wordList);
                node = node.children[nodeIndex];
            }
            return foundWords;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if (products == null || searchWord == null) {
            return null;
        }
        Arrays.sort(products);
        var trie = new Trie(products);
        return trie.findWords(products, searchWord);
    }
}
