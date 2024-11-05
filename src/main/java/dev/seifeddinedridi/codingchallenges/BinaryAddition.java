package dev.seifeddinedridi.codingchallenges;

public class BinaryAddition {

    public String addBinary(String a, String b) {
        // Maximum value for a pair of digits written in base 10 is 18 = 9 + 9
        // The leftover is 8 and the carryover is 10
        // leftover = (a1 + a2) % 10
        // carryover = (a1 + a2) / 10
        var carryOver = 0;
        var i = a.length() - 1;
        var j = b.length() - 1;
        var sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carryOver > 0) {
            var x = (i >= 0 && a.charAt(i) == '1') ? 1 : 0;
            var y = (j >= 0 && b.charAt(j) == '1') ? 1 : 0;
            var sum = x + y + carryOver;
            sb.append(sum % 2);
            carryOver = sum / 2;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
