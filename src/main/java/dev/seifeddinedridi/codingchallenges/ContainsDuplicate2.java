package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/contains-duplicate-ii

import java.util.HashMap;
import java.util.HashSet;

class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicateMapSolution(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}