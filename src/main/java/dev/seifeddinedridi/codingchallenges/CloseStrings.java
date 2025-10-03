package dev.seifeddinedridi.codingchallenges;

import java.util.HashMap;

public class CloseStrings {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        var word1Map = new HashMap<Character, Integer>();
        var word2Map = new HashMap<Character, Integer>();
        for (var i = 0; i < word1.length(); i++) {
            var c1 = Character.valueOf(word1.charAt(i));
            word1Map.compute(c1, (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
            var c2 = Character.valueOf(word2.charAt(i));
            word2Map.compute(c2, (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
        }
        if (!word1Map.keySet().equals(word2Map.keySet())) {
            return false;
        }
        var reverseWord1Map = new HashMap<Integer, Integer>();
        for (var e : word1Map.entrySet()) {
            reverseWord1Map.compute(e.getValue(), (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
        }
        for (var e : word2Map.entrySet()) {
            if (!reverseWord1Map.containsKey(e.getValue())
                    || reverseWord1Map.get(e.getValue()) == 0) {
                return false;
            }
            reverseWord1Map.compute(e.getValue(), (k, v) -> {
                if (v == 1) {
                    return null;
                }
                return v - 1;
            });
        }
        return true;
    }
}
