package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/remove-element

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        var k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}