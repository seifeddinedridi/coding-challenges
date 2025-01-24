package dev.seifeddinedridi.codingchallenges;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.isEmpty()) {
            return word2.length();
        } else if (word2 == null || word2.isEmpty()) {
            return word1.length();
        }
        int[][] cache = new int[word1.length()][word2.length()];
        cache[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
        for (int i = 1; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(0)) {
                cache[i][0] = i;
            } else {
                cache[i][0] = 1 + cache[i - 1][0];
            }
        }
        for (int i = 1; i < word2.length(); i++) {
            if (word1.charAt(0) == word2.charAt(i)) {
                cache[0][i] += i;
            } else {
                cache[0][i] = 1 + cache[0][i - 1];
            }
        }
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                var offset = word1.charAt(i) == word2.charAt(j) ? 0 : 1;
                cache[i][j] = Math.min(offset + cache[i - 1][j - 1],
                        Math.min(1 + cache[i - 1][j], 1 + cache[i][j - 1]));
            }
        }
        return cache[word1.length() - 1][word2.length() - 1];
    }
}
