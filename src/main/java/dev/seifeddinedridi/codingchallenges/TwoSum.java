package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/two-sum

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        var nums2 = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            nums2[i][0] = nums[i];
            nums2[i][1] = i;
        }
        Arrays.sort(nums2, (n1, n2) -> {
            return n1[0] - n2[0];
        });
        var left = 0;
        var right = nums2.length - 1;
        var ans = new int[2];
        while (left < right) {
            var currentSum = nums2[left][0] + nums2[right][0];
            if (currentSum == target) {
                ans[0] = nums2[left][1];
                ans[1] = nums2[right][1];
                break;
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}