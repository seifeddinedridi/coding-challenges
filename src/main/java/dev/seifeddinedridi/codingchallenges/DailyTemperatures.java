package dev.seifeddinedridi.codingchallenges;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        var answer = new int[temperatures.length];
        var i = 0;
        var stack = new Stack<Integer>();
        while (i < temperatures.length) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                var idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
            i++;
        }
        return answer;
    }
}
