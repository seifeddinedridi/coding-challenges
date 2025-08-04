package dev.seifeddinedridi.codingchallenges;

public class MaxVowelsInSubstringOfGivenLength {

    public int maxVowels(String s, int k) {
        var maxVowels = 0;
        var vowelsCount = 0;
        var alphabet = new boolean[26];
        alphabet[0] = true;
        alphabet['e' - 'a'] = true;
        alphabet['i' - 'a'] = true;
        alphabet['o' - 'a'] = true;
        alphabet['u' - 'a'] = true;
        for (var i = 0; i < s.length(); i++) {
            if (i >= k && alphabet[s.charAt(i - k) - 'a']) {
                vowelsCount--;
            }
            var idx = s.charAt(i) - 'a';
            vowelsCount += alphabet[idx] ? 1 : 0;
            maxVowels = Math.max(maxVowels, vowelsCount);
        }
        return maxVowels;
    }
}
