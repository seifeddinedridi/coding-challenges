package dev.seifeddinedridi.codingchallenges;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // Find the largest index k such as nums[k] < nums[k + 1]
        var k = -1;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            // nums is the last permutation, reverse nums in place
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // Find the largest index l > k, such as nums[k] < nums[l]
        var l = 0;
        for (int i = nums.length - 1; i > k ; i--) {
            if (nums[k] < nums[i]) {
                l = i;
                break;
            }
        }
        // Swap nums[k] and nums[l]
        var temp = nums[k];
        nums[k] = nums[l];
        nums[l] = temp;
        // Reverse nums starting from index k + 1
        reverse(nums, k + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            var temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
