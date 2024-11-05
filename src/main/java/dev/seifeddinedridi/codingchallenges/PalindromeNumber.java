package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/palindrome-number

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        var reverse = 0;
        var y = x;
        while (y != 0) {
            var remainder = y % 10;
            reverse = reverse * 10 + remainder;
            y /= 10;
        }
        return reverse == x;
    }
}