package dev.seifeddinedridi.codingchallenges;

import java.util.Arrays;

public class SingleNumberInArrayWhereEverOtherElementOccurs3Times {

    public static int singleNumberLinear(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int num : nums) {
                bitCount += (num >> i) & 1;
            }
            result |= (bitCount % 3) << i;
        }
        return result;
    }

    public static int singleNumber(int[] nums) {
        // Store in numbers in a Map<Integer, Integer>
        // Iterate over the map to find the number that occurs exactly once
        // Space: O(N) Time: O(N)
        Arrays.sort(nums);
        var i = 0;
        while (i < nums.length) {
            var j = i + 1;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            if (j == i + 1) {
                return nums[i];
            }
            i = j;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 1, 1, 2, 2, 2, 3, 4, 4, 4};
        System.out.println(singleNumberLinear(ints));
        System.out.println(singleNumber(ints));
    }
}
