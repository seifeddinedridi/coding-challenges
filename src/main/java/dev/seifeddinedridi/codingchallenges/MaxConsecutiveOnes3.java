package dev.seifeddinedridi.codingchallenges;

public class MaxConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        int count = 0;
        int zeroesCount = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroesCount++;
            }
            // Check if no 0 are left and another zero was hit
            while (zeroesCount > k) {
                // Remove the leftmost element
                if (nums[left] == 0) {
                    // Reclaim a 0
                    zeroesCount--;
                }
                left++;
            }
            right++;
            count = Math.max(count, right - left);
        }
        return count;
    }
}
