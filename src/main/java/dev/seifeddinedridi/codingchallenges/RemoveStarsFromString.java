package dev.seifeddinedridi.codingchallenges;

import java.util.Stack;

public class RemoveStarsFromString {

    public String removeStars(String s) {
        var chars = new Stack<String>();
        for (var i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                chars.push(String.valueOf(s.charAt(i)));
            } else {
                chars.pop();
            }
        }
        return String.join("", chars.toArray(new String[]{}));
    }
}
