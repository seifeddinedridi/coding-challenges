package dev.seifeddinedridi.codingchallenges;

public class SortedArrayFindInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            var mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // target == nums[mid]
                // We found the right position
                return mid;
            }
        }
        return left;
    }
}
