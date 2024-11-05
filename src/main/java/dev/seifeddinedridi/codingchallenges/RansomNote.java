package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/ransom-note

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        var alphabet = new int[26];
        for (var c : magazine.toCharArray()) {
            alphabet[c - 'a']++;
        }
        for (var c : ransomNote.toCharArray()) {
            if (alphabet[c - 'a'] == 0) {
                return false;
            }
            alphabet[c - 'a']--;
        }
        return true;
    }
}