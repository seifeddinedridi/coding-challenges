package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/longest-substring-without-repeating-characters

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }
        var longestSubstring = 1;
        var charSet = new HashSet<Character>();
        var left = 0;
        var right = 1;
        charSet.add(s.charAt(left));
        while (left < right && right < s.length()) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
            } else {
                while (left <= right && charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
            longestSubstring = Math.max(longestSubstring, right - left + 1);
            right++;
        }
        return longestSubstring;
    }
}