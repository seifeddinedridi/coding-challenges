package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        var parentheses = new ArrayList<String>();
        var str = new char[n * 2];
        generateParenthesis(str, 0, 0, 0, parentheses);
        return parentheses;
    }

    private void generateParenthesis(char[] str, int index, int usedLeft, int usedRight, List<String> parentheses) {
        if (index == str.length) {
            parentheses.add(new String(str));
            return;
        }
        var availableCount = str.length - index;
        var forceOpen = usedLeft == usedRight;
        var forceClose = availableCount == (usedLeft - usedRight);
        var openOrClose = availableCount > (usedLeft - usedRight) && usedLeft > usedRight;
        if (forceOpen || openOrClose) {
            str[index] = '(';
            generateParenthesis(str, index + 1, usedLeft + 1,
                    usedRight, parentheses);
            str[index] = ' ';
        }
        if (forceClose || openOrClose) {
            str[index] = ')';
            generateParenthesis(str, index + 1, usedLeft, usedRight + 1, parentheses);
            str[index] = ' ';
        }
    }
}
