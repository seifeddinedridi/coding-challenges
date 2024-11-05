package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/summary-ranges

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        var rangeStart = 0; // To keep track of the start of the current range
        var ranges = new ArrayList<String>();
        if (nums.length == 0) {
            return ranges;
        }
        // rangeStart = 0
        // i = 1, nums[1] - nums[0] = 1 => false
        // i = 2, nums[2] - nums[1] = bignumber, true
        // then nums[0] -> nums[1] and rangeStart = 2
        for (int i = 1; i < nums.length; i++) {
            // Check if the current "breaks the range"
            if (((long) nums[i] - nums[i - 1]) > 1L) {
                // Range continuity was broken
                if (i - 1 - rangeStart > 0) {
                    ranges.add(nums[rangeStart]
                    + "->" + nums[i - 1]);
                } else {
                    ranges.add(String.valueOf(nums[rangeStart]));
                }
                rangeStart = i;
            }
        }
        if (rangeStart < nums.length - 1) {
            ranges.add(nums[rangeStart]
                    + "->" + nums[nums.length - 1]);
        } else {
            ranges.add(String.valueOf(nums[rangeStart]));
        }
        return ranges;
    }
}