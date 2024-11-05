package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/majority-element

import java.util.HashMap;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        var count = 0;
        var majorityElement = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majorityElement) {
                count++;
            } else {
                count--;
                if (count < 0) {
                    majorityElement = nums[i];
                    count = 1;
                }
            }
        }
        return majorityElement;
    }

    public int majorityElementMapSolution(int[] nums) {
        // Return the most frequest element
        var frequencies = new HashMap<Integer, Integer>();
        var highestFrequency = 0;
        var elementValue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!frequencies.containsKey(nums[i])) {
                frequencies.put(nums[i], 0);
            }
            frequencies.put(nums[i], 1 + frequencies.get(nums[i]));
            if (frequencies.get(nums[i]) > highestFrequency) {
                highestFrequency = frequencies.get(nums[i]);
                elementValue = nums[i];
            }
        }
        return elementValue;
    }
}