package dev.seifeddinedridi.codingchallenges;

import java.util.Stack;

public class TrappingRainWater {

    public int trap(int[] height) {
        var trappedWater = 0;
        var left = 0;
        var right = height.length - 1;
        var leftMax = height[left];
        var rightMax = height[right];
        while (left < right) {
            if (leftMax < rightMax) {
                // Move left
                left++;
                leftMax = Math.max(height[left], leftMax);
                // Water can be trapped
                trappedWater += leftMax - height[left];
            } else {
                // Move right
                right--;
                rightMax = Math.max(height[right], rightMax);
                // Water can be trapped
                trappedWater += rightMax - height[right];
            }
        }
        return trappedWater;
    }

    public int trapStack(int[] height) {
        var stack = new Stack<Integer>();
        var trappedWater = 0;
        for (int h : height) {
            if (stack.isEmpty()) {
                stack.push(h);
            } else {
                if (stack.firstElement() <= h) {
                    // Start popping elements
                    var first = stack.firstElement();
                    while (!stack.isEmpty()) {
                        var current = stack.pop();
                        trappedWater += first - current;
                    }
                }
                stack.push(h);
            }
        }
        if (height.length > 0) {
            var last = height[height.length - 1];
            while (!stack.isEmpty()) {
                var current = stack.pop();
                if (current > last) {
                    last = current;
                } else {
                    trappedWater += last - current;
                }
            }
        }
        return trappedWater;
    }
}
