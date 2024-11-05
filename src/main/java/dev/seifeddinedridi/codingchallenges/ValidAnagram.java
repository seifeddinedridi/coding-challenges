package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/valid-anagram

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        var a1 = s.toCharArray();
        Arrays.sort(a1);
        var a2 = t.toCharArray();
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }
}