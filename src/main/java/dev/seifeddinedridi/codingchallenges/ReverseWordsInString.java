package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/reverse-words-in-a-string

public class ReverseWordsInString {
    public String reverseWords(String s) {
        var sb = new StringBuilder();
        var isPrevSpace = true;
        var indexOfLastSpacePos = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            var c = s.charAt(i);
            if (c == ' ' && !isPrevSpace) {
                if (sb.length() >= 1) {
                    sb.append(" ");
                }
                sb.append(s, i + 1, indexOfLastSpacePos);
            }
            if (c == ' ') {
                isPrevSpace = true;
                indexOfLastSpacePos = i;
            } else {
                isPrevSpace = false;
            }
        }
        if (indexOfLastSpacePos > 0) {
            if (sb.length() >= 1) {
                sb.append(" ");
            }
            sb.append(s, 0, indexOfLastSpacePos);
        }
        return sb.toString();
    }
}