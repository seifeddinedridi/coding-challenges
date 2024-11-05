package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/letter-combinations-of-a-phone-number

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

    static final String[] strings = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        var out = new ArrayList<String>();
        addLetters(digits, 0, "", out);
        return out;
    }

    void addLetters(String digits, int index, String prefix, List<String> out) {
        if (index < digits.length()) {
            var charIndex = digits.charAt(index) - '2';
            var string = strings[charIndex];
            for (var c : string.toCharArray()) {
                addLetters(digits, index + 1, prefix + c, out);
            }
        } else {
            if (!prefix.isEmpty()) {
                out.add(prefix);
            }
        }
    }
}