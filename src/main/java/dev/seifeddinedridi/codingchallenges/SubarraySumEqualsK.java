package dev.seifeddinedridi.codingchallenges;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        var sum = 0;
        int count = 0;
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            var prefixSum = sum - k;
            if (map.containsKey(prefixSum)) {
                count += map.get(prefixSum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
