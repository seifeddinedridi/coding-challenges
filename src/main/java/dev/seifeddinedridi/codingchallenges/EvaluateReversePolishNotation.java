package dev.seifeddinedridi.codingchallenges;

import java.util.LinkedList;
import java.util.Set;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        var stack = new LinkedList<String>();
        for (var token : tokens) {
            stack.push(token);
        }
        return evalRPN(stack);
    }

    public int evalRPN(LinkedList<String> stack) {
        if (stack.isEmpty() || stack.size() < 3) {
            return !stack.isEmpty() ? Integer.parseInt(stack.pop()) : 0;
        } else {
            var operator = stack.pop();
            String op2;
            int op2Value;
            if (Set.of("+", "-", "*", "/").contains(stack.peek())) {
                // Recursively evaluate the expression
                op2Value = evalRPN(stack);
            } else {
                op2 = stack.pop();
                op2Value = Integer.parseInt(op2);
            }
            String op1;
            int op1Value;
            if (Set.of("+", "-", "*", "/").contains(stack.peek())) {
                // Recursively evaluate the expression
                op1Value = evalRPN(stack);
            } else {
                op1 = stack.pop();
                op1Value = Integer.parseInt(op1);
            }
            return switch (operator) {
                case "+" -> op1Value + op2Value;
                case "-" -> op1Value - op2Value;
                case "*" -> op1Value * op2Value;
                case "/" -> op1Value / op2Value;
                default -> 0;
            };
        }
    }
}
