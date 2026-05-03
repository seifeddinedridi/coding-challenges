package dev.seifeddinedridi.codingchallenges;

public class FirstMissingPositiveInteger {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] > nums.length) {
                nums[i] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                swap(nums, i, 0);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int prev) {
        var temp = nums[i];
        nums[i] = prev;
        if (temp != 0 && nums[temp - 1] != temp) {
            swap(nums, temp - 1, temp);
        }
    }
}
