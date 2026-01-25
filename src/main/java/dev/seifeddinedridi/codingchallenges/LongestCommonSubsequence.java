package dev.seifeddinedridi.codingchallenges;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() > text2.length()) {
            var temp = text1;
            text1 = text2;
            text2 = temp;
        }
        var dp = new int[text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            var prev = 0;
            for (int j = 1; j <= text2.length(); j++) {
                var temp = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = 1 + prev;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                prev = temp;
            }
        }
        return dp[text2.length()];
    }
}
