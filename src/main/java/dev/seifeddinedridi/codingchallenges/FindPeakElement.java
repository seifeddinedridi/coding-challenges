package dev.seifeddinedridi.codingchallenges;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length);
    }

    private int findPeakElement(int[] nums, int start, int end) {
        if (end - start <= 1) {
            return start;
        }
        var mid = (start + end) / 2;
        if (mid + 1 < nums.length && nums[mid] < nums[mid + 1]) {
            return findPeakElement(nums, mid + 1, end);
        } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
            return findPeakElement(nums, start, mid);
        } else {
            return mid;
        }
    }
}
