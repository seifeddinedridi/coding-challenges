package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/roman-to-integer

public class RomanToInteger {
    public int romanToInt(String s) {
        int ans = 0;
        var i = 0;
        while (i < s.length()) {
            var c = s.charAt(i);
            ans += getValue(c);
            if (i < s.length() - 1) {
                var next = s.charAt(i + 1);
                if ((c == 'I' && (next == 'V' || next == 'X'))
                    || (c == 'X' && (next == 'L' || next == 'C'))
                    || (c == 'C' && (next == 'D' || next == 'M'))) {
                    ans += getValue(next) - 2 * getValue(c);
                    i++;
                }
            }
            i++;
        }
        return ans;
    }

    private int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }
}