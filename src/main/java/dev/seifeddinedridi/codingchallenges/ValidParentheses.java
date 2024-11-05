package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/valid-parentheses

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        for (var c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                case '}':
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    var cc = stack.pop();
                    if (c == '}' && cc != '{') {
                        return false;
                    } else if (c == ')' && cc != '(') {
                        return false;
                    } else if (c == ']' && cc != '[') {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}