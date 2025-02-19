package dev.seifeddinedridi.codingchallenges;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    int search(int[] nums, int target, int start, int end) {
        if (end - start <= 3) {
            for (int i = 0; i < end - start; i++) {
                if (target == nums[i + start]) {
                    return i + start;
                }
            }
            return -1;
        }
        int median = (start + end) / 2;
        if (nums[median] >= nums[end - 1]) {
            while (median < nums.length && nums[median] > nums[end - 1]) {
                // Shift median to the right
                median++;
            }
        } else if (nums[median] <= nums[start]) {
            while (median >= 0 && nums[median] < nums[start]) {
                // Shift median to the left
                median--;
            }
            if (nums[median] >= nums[start]) {
                median++;
            }
        }
        if (target >= nums[start] && target <= nums[median - 1]) {
            return search(nums, target, start, median);
        } else if (target >= nums[median] && target <= nums[end - 1]) {
            return search(nums, target, median, end);
        }
        return -1;
    }
}
