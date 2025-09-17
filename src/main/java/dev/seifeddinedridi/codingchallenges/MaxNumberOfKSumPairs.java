package dev.seifeddinedridi.codingchallenges;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int firstIndex = 0, lastIndex = nums.length - 1;
        int maxOperations = 0;
        while (firstIndex < lastIndex) {
            var sum = nums[firstIndex] + nums[lastIndex];
            if (sum == k) {
                maxOperations++;
                firstIndex++;
                lastIndex--;
            } else if (sum < k) {
                firstIndex++;
            } else {
                lastIndex--;
            }
        }
        return maxOperations;
    }
}
