package dev.seifeddinedridi.codingchallenges;

public class LongestSubarrayOfOnesAfterDeletingOneElement {

    public int longestSubarray(int[] nums) {
        int deletedElementIndex = -1;
        int left = 0, right = 0;
        int longestSubArray = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                if (deletedElementIndex != -1) {
                    // Reset
                    left = deletedElementIndex + 1;
                    deletedElementIndex = right;
                } else {
                    deletedElementIndex = right;
                }
            }
            longestSubArray = Math.max(longestSubArray, right - left);
            right++;
        }
        return longestSubArray;
    }
}
