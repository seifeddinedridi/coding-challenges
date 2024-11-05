package dev.seifeddinedridi.codingchallenges;

import java.util.Arrays;

public class SingleNumberInArrayWhereEverOtherElementOccursTwice {

    public int singleNumber(int[] nums) {
        // Xor of two equal numbers equals 0
        var ans = 0;
        for (var n : nums) {
            ans ^= n;
        }
        return ans;
    }

    public int singleNumberArraySort(int[] nums) {
        Arrays.sort(nums);
        var i = 0;
        var j = 1;
        while (i < nums.length && j < nums.length && nums[i] == nums[j]) {
            i += 2;
            j += 2;
        }
        if (i < nums.length) {
            return nums[i];
        }
        return -1;
    }
}
