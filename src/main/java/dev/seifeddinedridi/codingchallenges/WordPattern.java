package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/word-pattern

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        // Split the string s by empty space
        // If the number of words in s is different than the number of characters in pattern
        // Return false otherwise true
        // Map the characters to the words in s (map only once)
        // Reconstruct the string s and see if it matches the given input
        var words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        var charMapping = new HashMap<Character, String>();
        for (var i = 0; i < pattern.length(); i++) {
            var c = pattern.charAt(i);
            if (!charMapping.containsKey(c)) {
                // Characters should not map to the same words
                if (charMapping.containsValue(words[i])) {
                    return false;
                }
                charMapping.put(c, words[i]);
            } else if (!charMapping.get(c).equals(words[i])) {
                return false;
            }
        }
        return true;
    }
}