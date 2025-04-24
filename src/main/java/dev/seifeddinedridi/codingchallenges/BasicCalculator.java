package dev.seifeddinedridi.codingchallenges;

import java.util.LinkedList;

public class BasicCalculator {

    public int calculate(String s) {
        return processExpression(s);
    }

    private int processExpression(String s) {
        var result = 0;
        var currentNumber = 0;
        byte sign = 1;
        var stack = new LinkedList<Integer>();
        for (var c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                currentNumber = currentNumber * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                result += sign * currentNumber;
                sign = (byte) (c == '+' ? 1 : -1);
                currentNumber = 0;
            } else if (c == '(') {
                stack.push((int) sign);
                stack.push(result);
                currentNumber = 0;
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * currentNumber;
                result = stack.pop() + stack.pop() * result;
                currentNumber = 0;
                sign = 1;
            }
        }
        return result + sign * currentNumber;
    }

    private int processExpressionSlow(String s, int[] i) {
        var currentToken = new char[10];
        var currentTokenIndex = 0;
        var stack = new LinkedList<String>();
        var isPreviousOperator = false;
        var isPreviousSignOperator = false;
        while (i[0] < s.length()) {
            skipSpaces(s, i);
            // Buffer numbers
            while (i[0] < s.length() && s.charAt(i[0]) >= '0'
                    && s.charAt(i[0]) <= '9') {
                currentToken[currentTokenIndex++] = s.charAt(i[0]);
                i[0]++;
            }
            // Save the previously saved number
            if (currentTokenIndex > 0) {
                // If the previous token is sign then pop it
                // And use it to change the current number's sign
                var token = new String(currentToken, 0, currentTokenIndex);
                if (isPreviousSignOperator) {
                    var sign = stack.removeFirst().equals("+") ? 1 : -1;
                    stack.addLast(String.valueOf(sign * Integer.parseInt(token)));
                } else {
                    stack.addLast(token);
                }
                isPreviousSignOperator = false;
                isPreviousOperator = false;
                currentTokenIndex = 0;
            }
            // Compress the stack when the size reaches 3
            if (stack.size() == 3) {
                compressStack(stack);
            }
            if (i[0] < s.length()) {
                var c = s.charAt(i[0]);
                if (c == '(') {
                    // Recurse
                    i[0]++;
                    var sign = 1;
                    if (isPreviousSignOperator) {
                        sign = stack.removeFirst().equals("+") ? 1 : -1;
                    }
                    var value = sign * processExpressionSlow(s, i);
                    stack.addLast(String.valueOf(value));
                    isPreviousOperator = false;
                } else if (c == ')') {
                    isPreviousOperator = false;
                    try {
                        return stack.isEmpty() ? 0 : Integer.parseInt(stack.poll());
                    } catch (NumberFormatException ex) {
                        return 0;
                    }
                } else if (c == '+' || c == '-') {
                    isPreviousSignOperator = isPreviousOperator || stack.isEmpty();
                    stack.addFirst(String.valueOf(c));
                    isPreviousOperator = true;
                }
            }
            i[0]++;
        }
        if (stack.size() >= 2) {
            return compressStack(stack);
        }
        return stack.isEmpty() ? 0 : Integer.parseInt(stack.poll());
    }

    private void skipSpaces(String s, int[] i) {
        while (i[0] < s.length() && s.charAt(i[0]) == ' ') {
            i[0]++;
        }
    }

    private Integer compressStack(LinkedList<String> stack) {
        if (stack.size() == 2) {
            var sign = stack.removeFirst().equals("+") ? 1 : -1;
            var value = Integer.parseInt(stack.removeLast());
            stack.add(String.valueOf(sign * value));
            return sign * value;
        }
        // First element is the operator
        // The next two elements are the operands
        var operand2 = stack.removeLast();
        var operand1 = stack.removeLast();
        var operator = stack.removeLast();
        int value;
        if (operator.equals("+")) {
            value = Integer.parseInt(operand1) + Integer.parseInt(operand2);
        } else {
            value = Integer.parseInt(operand1) - Integer.parseInt(operand2);
        }
        stack.add(String.valueOf(value));
        return value;
    }
}
