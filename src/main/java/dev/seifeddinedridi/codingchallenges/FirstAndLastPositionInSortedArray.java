package dev.seifeddinedridi.codingchallenges;

public class FirstAndLastPositionInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        var firstIndex = findIndexOf(nums, target, 0, nums.length, true);
        var lastIndex = findIndexOf(nums, target, 0, nums.length, false);
        return new int[] { firstIndex, lastIndex };
    }

    private int findIndexOf(int[] nums, int target, int start, int end, boolean leftBias) {
        if (end - start <= 1) {
            return nums[start] == target ? start : -1;
        }
        int median = (start + end) / 2;
        if (target < nums[median]) {
            return findIndexOf(nums, target, start, median, leftBias);
        } else if (target > nums[median]) {
            return findIndexOf(nums, target, median, end, leftBias);
        } else {
            int index = -1;
            if (leftBias) {
                index = findIndexOf(nums, target, start, median, leftBias);
            } else {
                index = findIndexOf(nums, target, median, end, leftBias);
            }
            if (index == -1) {
                return median;
            }
            return index;
        }
    }
}
