package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/word-break

import java.util.List;
import java.util.Map;

public class WordBread {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Find all possible sets from a word
        // For each set find out if the set is a subset of the target set
        // Stop if the a result is found

        // We have to make sure out algorithm is order-independant
        // Use a matrix where the column represents words and the rows are iterations
        // s=cars
        //   car | ca | rs
        // 1 s   | rs | ca
        // 2 s   | "" | ""  
        //return wordBreak(s, wordDict, new HashMap<>());
        var cache = new boolean[s.length() + 1];
        cache[s.length()] = true;
        // a|aaa|aaa
        // [aaaa, aaa]
        for (int i = s.length() - 1; i >= 0; i--) {
            for (var word : wordDict) {
                // We could be forming more words actually
                if (s.substring(i).startsWith(word)) {
                    cache[i] = cache[i + word.length()];
                    if (cache[i]) {
                        break;
                    }
                }
            }
        }
        return cache[0];
    }

    public boolean wordBreak(String s, List<String> wordDict, Map<String, Boolean> cache) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        for (var word : wordDict) {
            var index = s.indexOf(word);
            if (index >= 0) {
                // The string contains word
                // We can end up with 1 or 2 substrings
                if (index == 0) {
                    // We have one string left
                    var newS = s.substring(word.length());
                    if (!cache.containsKey(newS)) {
                        cache.put(newS, wordBreak(newS, wordDict, cache));
                    }
                    if (cache.get(newS)) {
                        return true;
                    }
                } else if (index + word.length() == s.length()) {
                    // We have one string left
                    var newS = s.substring(0, index);
                    if (!cache.containsKey(newS)) {
                        cache.put(newS, wordBreak(newS, wordDict, cache));
                    }
                    if (cache.get(newS)) {
                        return true;
                    }
                } else if (index >= 1 && index + word.length() < s.length() - 1) {
                    // We have two strings left
                    var first = s.substring(0, index);
                    var second = s.substring(index + word.length());
                    if (!cache.containsKey(first)) {
                        cache.put(first, wordBreak(first, wordDict, cache));
                    }
                    if (!cache.containsKey(second)) {
                        cache.put(second, wordBreak(second, wordDict, cache));
                    }
                    // Both must return true
                    if (cache.get(first) && cache.get(second)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }
}