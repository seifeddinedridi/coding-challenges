package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/rotate-array

public class RotateArray {
    public void rotate2(int[] nums, int k) {
        if (nums.length <= 1 || nums.length == k) {
            return;
        }
        var ans = new int[nums.length];
        var last = nums[nums.length - 1];
        for (int j = nums.length - 1; j >= 0 ; j--) {
            ans[(j + k) % nums.length] = nums[j];
        }
        // 1 2 3 4 5 6 7 (k=2)
        // 6 7 1 2 3 4 5
        System.arraycopy(ans, 0, nums, 0, nums.length);
    }

    public void rotate(int[] nums, int k) {
        if (nums.length <= 1 || nums.length == k) {
            return;
        }
        k = k % nums.length;
        // Rotate the whole array
        reverse(nums, 0, nums.length);
        // Rotate the first k elements
        reverse(nums, 0, k);
        // Rotate the remaining elements
        reverse(nums, k, nums.length);
    }

    public void reverse(int[] nums, int start, int end) {
        var size = end - start;
        for (int i = start; i < start + size / 2; i++) {
            var temp = nums[end - i + start - 1];
            nums[end - i + start - 1] = nums[i];
            nums[i] = temp;
        }
    }
}