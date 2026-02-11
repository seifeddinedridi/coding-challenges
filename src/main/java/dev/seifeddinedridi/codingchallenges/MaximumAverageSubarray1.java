package dev.seifeddinedridi.codingchallenges;

public class MaximumAverageSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        var max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                sum += nums[i];
            } else {
                max = Math.max(max, sum);
                sum += nums[i];
                sum -= nums[i - k];
            }
        }
        max = Math.max(max, sum);
        return (max / (double) k);
    }
}
