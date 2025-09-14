package dev.seifeddinedridi.codingchallenges;

public class GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        var s1 = str1;
        var s2 = str2;
        if (str1.length() > str2.length()) {
            s1 = str2;
            s2 = str1;
        }
        String out = "";
        for (int i = 1; i <= s1.length(); i++) {
            if (s2.length() % i != 0 || s1.length() % i != 0) {
                continue;
            }
            var x = s1.substring(0, i);
            var c1 = x.repeat(s2.length() / i);
            var c2 = x.repeat(s1.length() / i);
            if (c1.equals(s2) && c2.equals(s1)) {
                out = x;
            }
        }
        return out;
    }

    public String gcdOfStringsFast(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int lenGCD = gcd(str1.length(), str2.length());
        return str1.substring(0, lenGCD);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            var temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
