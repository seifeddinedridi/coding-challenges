package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayDeque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k) {
            return new int[]{};
        }
        var stack = new ArrayDeque<Integer>();
        var maxes = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] <= nums[i]) {
                stack.pollLast();
            }
            stack.offer(i);
            while (i >= k && stack.peekFirst() <= i - k) {
                stack.pollFirst();
            }
            if (i >= k - 1 && !stack.isEmpty()) {
                maxes[index++] = nums[stack.peekFirst()];
            }
        }
        return maxes;
    }
}
