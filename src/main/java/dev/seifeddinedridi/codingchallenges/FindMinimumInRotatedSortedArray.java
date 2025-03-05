package dev.seifeddinedridi.codingchallenges;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length);
    }

    public int findMin(int[] nums, int start, int end) {
        if (end - start == 1) {
            return nums[start];
        } else if (end - start == 2) {
            return Math.min(nums[start], nums[end - 1]);
        }
        int median = (start + end) / 2;
        if (Math.min(nums[0], nums[median - 1]) < Math.min(nums[median], nums[end - 1])) {
            return findMin(nums, start, median);
        } else {
            return findMin(nums, median, end);
        }
    }
}
