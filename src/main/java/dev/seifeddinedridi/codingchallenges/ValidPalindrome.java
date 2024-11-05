package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/valid-palindrome

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // Convert a string into a normalized form
        // Then use two pointers, one starts from the first char
        // The other starts from the last char
        // Compare the chars at the 2 pointers until the pointers overlap
        // In which case return true or if the chars are different return false
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            }
        }
        var normalized = sb.toString().toLowerCase();
        int i = 0;
        int j = normalized.length() - 1;
        while (i < j) {
            if (normalized.charAt(i) != normalized.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}