package dev.seifeddinedridi.codingchallenges;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        var minLength = Integer.MAX_VALUE;
        for (var s : strs) {
            minLength = Math.min(minLength, s.length());
        }
        for (int i = 0; i < minLength; i++) {
            var c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minLength);
    }
}
