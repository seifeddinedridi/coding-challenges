package dev.seifeddinedridi.codingchallenges;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s.equals(t)) {
            return s;
        }
        var tCharFreq = new int[52];
        var expectedCharCount = t.length();
        for (int i = 0; i < t.length(); i++) {
            tCharFreq[charToIndex(t.charAt(i))]++;
        }
        int left = 0, right = 0;
        int bestLeft = 0, bestRight = 100001;
        while (right < s.length()) {
            var c = charToIndex(s.charAt(right));
            if (tCharFreq[c] > 0) {
                expectedCharCount--;
            }
            tCharFreq[c]--;
            while (expectedCharCount == 0) {
                if (1 + right - left < bestRight - bestLeft) {
                    bestLeft = left;
                    bestRight = right + 1;
                }
                c = charToIndex(s.charAt(left));
                tCharFreq[c]++;
                if (tCharFreq[c] > 0) {
                    expectedCharCount++;
                }
                left++;
            }
            right++;
        }
        return bestRight != 100_001 ? s.substring(bestLeft, bestRight) : "";
    }

    private int charToIndex(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        }
        return (c - 'A') + 26;
    }
}
