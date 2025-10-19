package dev.seifeddinedridi.codingchallenges;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        var stack = new Stack<Character>();
        for (var i = s.length() - 1; i >= 0; i--) {
            stack.push(s.charAt(i));
        }
        return decodeString(stack);
    }

    private String decodeString(Stack<Character> stack) {
        var sb = new StringBuilder();
        int multiplier = 0;
        while (!stack.isEmpty()) {
            var c = stack.pop();
            if (c >= '0' && c <= '9') {
                // Check for a number
                multiplier = multiplier * 10 + (c - '0');
            } else if (c == '[') {
                // Check for an open bracket
                sb.append(decodeString(stack).repeat(multiplier));
                multiplier = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
