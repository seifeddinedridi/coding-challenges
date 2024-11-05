package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/remove-duplicates-from-sorted-array

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        var k = 0;
        var i = 0;
        while (i < nums.length) {
            var j = i + 1;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            nums[k++] = nums[i];
            i = j;
        }
        return k;
    }
}