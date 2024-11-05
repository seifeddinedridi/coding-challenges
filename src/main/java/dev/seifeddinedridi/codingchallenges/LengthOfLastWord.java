package dev.seifeddinedridi.codingchallenges;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        var trimmedS = s.trim();
        var i = trimmedS.length() - 1;
        while (i >= 0) {
            if (trimmedS.charAt(i) == ' ') {
                return trimmedS.length() - 1 - i;
            }
            i--;
        }
        return i < 0 ? trimmedS.length() : 0;
    }
}
