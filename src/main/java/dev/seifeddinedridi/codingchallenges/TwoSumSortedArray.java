package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSumSortedArray {
    public int[] twoSum(int[] numbers, int target) {
        // Maybe we can use two pointers?
        int i1 = 0;
        int i2 = numbers.length - 1;
        while (i1 < i2) {
            var sum = numbers[i1] + numbers[i2];
            if (sum == target) {
                return new int[] {i1 + 1, i2 + 1};
            } else if (sum > target) {
                i2--;
            } else {
                i1++;
            }
        }
        return new int[] {-1, -1};
    }

    int[] twoSum2(int[] numbers, int target) {
        // We have a sorted array
        // We can the numbers in a set
        // For each value in the set
        // If the value is < target and there exists target - currentValue return the indices of those two numbers
        var map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], new ArrayList<>());
            }
            map.get(numbers[i]).add(i);
        }
        for (var e : map.entrySet()) {
            if (map.containsKey(target - e.getKey())) {
                if (target - e.getKey() == e.getKey()) {
                    var first = e.getValue().getFirst() + 1;
                    var second = map.get(target - e.getKey()).get(1) + 1;
                    return new int[] {Math.min(first, second), Math.max(first, second)};
                }
                var first = e.getValue().getFirst() + 1;
                var second = map.get(target - e.getKey()).get(0) + 1;
                return new int[] {Math.min(first, second), Math.max(first, second)};
            }
        }
        return new int[] {-1, -1};
    }
}