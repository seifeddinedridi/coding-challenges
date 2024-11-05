package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/is-subsequence

public class IsSubsequenceAccepted {
    public boolean isSubsequence(String s, String t) {
        // The number of unique characters in s must be > the number of unique characters in t
        int i1 = 0;
        int i2 = 0;
        while (i1 < s.length() && i2 < t.length()) {
            if (s.charAt(i1) != t.charAt(i2)) {
                i2++;
            } else {
                i1++;
                i2++;
            }
        }
        return i1 == s.length();
    }
}