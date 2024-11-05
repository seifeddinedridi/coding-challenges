package dev.seifeddinedridi.codingchallenges;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        var dp = new boolean[s1.length() + 1][s2.length() + 1];
        // An empty string can always be built using two other empty strings
        dp[0][0] = true;
        for (int i = 1; i <= s2.length(); i++) {
            dp[0][i] = s3.charAt(i - 1) == s2.charAt(i - 1) && dp[0][i - 1];
        }
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = s3.charAt(i - 1) == s1.charAt(i - 1) && dp[i - 1][0];
        }
        for (int r = 1; r <= s1.length(); r++) {
            for (int c = 1; c <= s2.length(); c++) {
                var current = s3.charAt(r + c - 1);
                dp[r][c] = (dp[r - 1][c] && current == s1.charAt(r - 1))
                        || (dp[r][c - 1] && current == s2.charAt(c - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    private boolean isInterleavingStrings(String s1, String s2, String s3,
                                          int i1, int i2, int i3) {
        if (i3 == s3.length()) {
            return i1 == s1.length() && i2 == s2.length();
        }
        if (i1 < s1.length() && i2 < s2.length()) {
            if (s1.charAt(i1) == s2.charAt(i2) && s3.charAt(i3) == s1.charAt(i1)) {
                return isInterleavingStrings(s1, s2, s3, i1 + 1, i2, i3 + 1)
                        || isInterleavingStrings(s1, s2, s3, i1, i2 + 1, i3 + 1);
            } else if (s3.charAt(i3) == s1.charAt(i1)) {
                return isInterleavingStrings(s1, s2, s3, i1 + 1, i2, i3 + 1);
            } else if (s3.charAt(i3) == s2.charAt(i2)) {
                return isInterleavingStrings(s1, s2, s3, i1, i2 + 1, i3 + 1);
            }
        } else if (i1 < s1.length()) {
            while (i1 < s1.length() && i3 < s3.length()
                    && s3.charAt(i3) == s1.charAt(i1)) {
                i1++;
                i3++;
            }
            return i1 == s1.length() && i3 == s3.length();
        } else if (i2 < s2.length()) {
            while (i2 < s2.length() && i3 < s3.length()
                    && s3.charAt(i3) == s2.charAt(i2)) {
                i2++;
                i3++;
            }
            return i2 == s2.length() && i3 == s3.length();
        }
        return false;
    }
}
