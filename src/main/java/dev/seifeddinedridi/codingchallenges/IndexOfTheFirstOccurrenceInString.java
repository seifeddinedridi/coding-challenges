package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string

public class IndexOfTheFirstOccurrenceInString {
    public int strStr(String haystack, String needle) {
        // We have to loop over each character of the first string and check if the current char starts with the first
        // char from the second string. If it does, check subsequent chars if they match or not.
        //If they do, return the index of the char from the outer loop, if not move to the index
        // of the char that didn't match with the second string's char
        for (int i = 0; i < haystack.length() + 1 - needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}