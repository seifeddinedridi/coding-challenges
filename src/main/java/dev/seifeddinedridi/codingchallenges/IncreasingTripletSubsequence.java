package dev.seifeddinedridi.codingchallenges;

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        var first = Integer.MAX_VALUE;
        var second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num; // smallest so far
            } else if (num <= second) {
                second = num; // second smallest
            } else {
                // Found a third number greater than both
                return true;
            }
        }
        return false;
    }

    public boolean increasingTripletOld(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        var minArray = new int[nums.length - 1];
        // Find the min up to index i
        var min = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            min = Math.min(nums[i], min);
            minArray[i] = min;
        }
        var max = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 1; i--) {
            if (nums[i] < max && nums[i] > minArray[i]) {
                return true;
            }
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return false;
    }
}
