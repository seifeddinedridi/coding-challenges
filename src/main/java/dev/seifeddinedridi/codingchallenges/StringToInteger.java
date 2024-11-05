package dev.seifeddinedridi.codingchallenges;

public class StringToInteger {

    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        double ans = 0;
        var startIndex = 0;
        int sign = 1;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            sign = s.charAt(0) == '-' ? -1 : 1;
            startIndex++;
        }
        var i = startIndex;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                ans = ans * 10 + ((int) s.charAt(i) - 48);
            } else {
                break;
            }
            i++;
        }
        return (int) Math.max(Integer.MIN_VALUE, Math.min(ans * sign, Integer.MAX_VALUE));
    }
}
