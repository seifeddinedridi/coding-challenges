package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/minimum-size-subarray-sum

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        // The naive solution is to check all subarrays whose sum is greater than or equal to target
        // N
        // N - 1
        // N - 2
        // N - 3
        // ...
        // 1
        // O(N * (N + 1) / 2) = O(N^2 + N)
        var left = 0;
        var right = 0;
        var minLength = Integer.MAX_VALUE;
        var currentSum = 0;
        // [2,3,1,2,4,3]
        while (left <= right) {
            if (currentSum >= target) {
                minLength = Math.min(minLength, right - left);
                currentSum -= nums[left];
                left++;
            } else if (right < nums.length) {
                currentSum += nums[right];
                right++;
            } else {
                break;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}