package dev.seifeddinedridi.codingchallenges;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        var bestL = 0;
        var bestR = 0;
        var longestPalindromeLength = 0;
        for (int i = 0; i < s.length(); i++) {
            // Odd palindromes
            var l = i;
            var r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (longestPalindromeLength < r - l + 1) {
                    longestPalindromeLength = r - l + 1;
                    bestL = l;
                    bestR = r;
                }
                l--;
                r++;
            }
            // Even palindromes
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (longestPalindromeLength < r - l + 1) {
                    longestPalindromeLength = r - l + 1;
                    bestL = l;
                    bestR = r;
                }
                l--;
                r++;
            }
        }
        return s.substring(bestL, bestR + 1);
    }
}
