package dev.seifeddinedridi.codingchallenges;

import java.util.HashMap;

public class CloseStrings {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        var word1Map = new int[26];
        var word2Map = new int[26];
        for (var i = 0; i < word1.length(); i++) {
            var c1 = Character.valueOf(word1.charAt(i));
            word1Map[c1 - 'a']++;
            var c2 = Character.valueOf(word2.charAt(i));
            word2Map[c2 - 'a']++;
        }
        for (var i = 0; i < word1Map.length; i++) {
            if ((word1Map[i] == 0 && word2Map[i] != 0)
            || word1Map[i] != 0 && word2Map[i] == 0) {
                return false;
            }
        }
        var reverseWord1Map = new HashMap<Integer, Integer>();
        for (var i = 0; i < word1Map.length; i++) {
            if (word1Map[i] == 0) {
                continue;
            }
            reverseWord1Map.compute(word1Map[i], (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
        }
        for (var i = 0; i < word2Map.length; i++) {
            if (word2Map[i] == 0) {
                continue;
            }
            if (!reverseWord1Map.containsKey(word2Map[i])
                || reverseWord1Map.get(word2Map[i]) == 0) {
                return false;
            }
            reverseWord1Map.compute(word2Map[i], (k, v) -> {
                if (v == 1) {
                    return null;
                }
                return v - 1;
            });
        }
        return true;
    }
}
