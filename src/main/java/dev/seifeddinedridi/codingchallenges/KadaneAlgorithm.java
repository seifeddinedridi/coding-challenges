package dev.seifeddinedridi.codingchallenges;

public class KadaneAlgorithm {

    public static int largestSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        var currentSum = nums[0];
        var maxSum = nums[0];
        for (var i = 1; i < nums.length; i++) {
            currentSum = Math.max(0, currentSum);
            currentSum += nums[i];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(largestSum(new int[]{4, -1, 2, -7, 3, 4}));
        System.out.println(largestSum(new int[]{1, 2, 3, 0, 5, 5, 5}));
    }
}
