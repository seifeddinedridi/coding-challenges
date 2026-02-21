package dev.seifeddinedridi.codingchallenges;

public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        int minProduct = nums[0], maxProduct = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                var temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            maxProduct = Math.max(nums[i], nums[i] * maxProduct);
            minProduct = Math.min(nums[i], nums[i] * minProduct);
            max = Math.max(max, maxProduct);
        }
        return max;
    }
}
