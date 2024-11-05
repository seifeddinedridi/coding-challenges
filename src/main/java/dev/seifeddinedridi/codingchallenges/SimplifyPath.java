package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/simplify-path

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        var stack = new Stack<String>();
        for (var token : path.replaceAll("//", "/").split("/")) {
            if (token.isEmpty()) {
                continue;
            }
            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                // Else there is an error
            } else if (token.matches("[a-zA-Z0-9\\.\\/_]+")) {
                if (!token.equals(".")) {
                    stack.push(token);
                }
            }
        }
        var sb = new StringBuilder();
        if (stack.isEmpty()) {
            stack.push("");
        }
        while (!stack.isEmpty()) {
            var s = stack.pop();
            sb.insert(0, s);
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}