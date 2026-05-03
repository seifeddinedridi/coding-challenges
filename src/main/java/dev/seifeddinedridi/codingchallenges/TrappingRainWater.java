package dev.seifeddinedridi.codingchallenges;

import java.util.Stack;

public class TrappingRainWater {
    public int trap(int[] height) {
        int trappedWater = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                var top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                var w = i - stack.peek() - 1;
                var h = Math.min(height[i], height[stack.peek()]) - height[top];
                trappedWater += w * h;
            }
            stack.push(i);
        }
        return trappedWater;
    }
}
