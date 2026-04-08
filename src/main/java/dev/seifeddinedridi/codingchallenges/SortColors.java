package dev.seifeddinedridi.codingchallenges;

public class SortColors {
    public void sortColors(int[] nums) {
        // Red
        int redCount = 0, greenCount = 0, blueCount = 0;
        for (int num : nums) {
            if (num == 0) {
                redCount++;
            } else if (num == 1) {
                greenCount++;
            } else if (num == 2) {
                blueCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (redCount > 0) {
                nums[i] = 0;
                redCount--;
            } else if (greenCount > 0) {
                nums[i] = 1;
                greenCount--;
            } else if (blueCount > 0) {
                nums[i] = 2;
                blueCount--;
            }
        }
    }
}
