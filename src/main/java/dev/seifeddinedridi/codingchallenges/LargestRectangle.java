package dev.seifeddinedridi.codingchallenges;

import java.util.Stack;

public class LargestRectangle {
    public int largestRectangleArea(int[] heights) {
        int largestRectange = 0;
        var previousSmaller = new Stack<Integer>();
        for (int i = 0; i <= heights.length; i++) {
            int currentHeight = (i == heights.length) ? 0 : heights[i];
            while (!previousSmaller.isEmpty() && heights[previousSmaller.peek()] >= currentHeight) {
                int height = heights[previousSmaller.pop()];
                int width = previousSmaller.isEmpty() ? i : (i - previousSmaller.peek() - 1);
                largestRectange = Math.max(largestRectange, width * height);
            }
            if (i < heights.length) {
                previousSmaller.push(i);
            }
        }
        return largestRectange;
    }
}
