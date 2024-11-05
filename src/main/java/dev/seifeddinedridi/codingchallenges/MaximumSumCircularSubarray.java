package dev.seifeddinedridi.codingchallenges;

public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        var currentSum = nums[0];
        var currentSumMin = nums[0];
        var maxSum = nums[0];
        var minSum = nums[0];
        var totalSum = nums[0];
        var i = 1;
        while (i < nums.length) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            if (currentSumMin > 0) {
                currentSumMin = 0;
            }
            currentSum += nums[i];
            totalSum += nums[i];
            currentSumMin += nums[i];
            maxSum = Math.max(maxSum, currentSum);
            minSum = Math.min(minSum, currentSumMin);
            i++;
        }
        return maxSum < 0 ? maxSum : Math.max(maxSum, totalSum - minSum);
    }
}
