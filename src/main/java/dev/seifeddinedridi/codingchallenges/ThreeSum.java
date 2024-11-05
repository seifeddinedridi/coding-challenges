package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/3sum

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        var out = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            var start = i + 1;
            var end = nums.length - 1;
            while (start < end) {
                if (start > i + 1 && nums[start] == nums[start - 1]) {
                    start++;
                    continue;
                }
                if (end < nums.length -1 && nums[end] == nums[end + 1]) {
                    end--;
                    continue;
                }
                var sum = nums[i] + nums[start] +  + nums[end];
                if (sum == 0) {
                    out.add(List.of(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return out;
    }
    
    public List<List<Integer>> threeSumMap(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        var out = new HashMap<String, List<Integer>>();
        for (int i1 = 0; i1 < nums.length; i1++) {
            for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                var k = nums[i1] + nums[i2];
                if (map.containsKey(-k)) {
                    var index = map.get(-k);
                    if (index != i1 && index != i2) {
                        var a = nums[i1];
                        var b = nums[i2];
                        var c = -k;
                        int min = Math.min(a, Math.min(b, c));
                        int max = Math.max(a, Math.max(b, c));
                        int mid =  a + b + c - min - max;
                        String key = min + "_" + mid + "_" + max;
                        if (!out.containsKey(key)) {
                            out.put(key, List.of(nums[i1], nums[i2], nums[index]));
                        }
                    }
                }
            }
        }
        return new ArrayList<>(out.values());
    }
    
    public List<List<Integer>> threeSumRecursive(int[] nums) {
        // Create an empty list for storing the answer
        // Start from index 0 recursively call a function to include and exclude the element
        // pointed by that index and keep track of acculumated sum for each case
        // Reset the culumative sum when the number of elements is >= 3
        // Add the current triplet if the sum is 0 and the number of elements is 3
        var ans = new HashSet<List<Integer>>();
        arraySum(0, nums, 0, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }

    private void arraySum(int index, int[] nums, int currentSum, List<Integer> currentTriplet, Set<List<Integer>> out) {
        if (index >= nums.length || currentTriplet.size() >= 3) {
            if (currentTriplet.size() == 3 && currentSum == 0) {
                Collections.sort(currentTriplet);
                out.add(currentTriplet);
                currentTriplet = new ArrayList<>();
            }
            if (index >= nums.length) {
                return;
            }
        }
        // Include
        var currentTriplet1 = new ArrayList<Integer>(currentTriplet);
        currentTriplet1.add(nums[index]);
        arraySum(index + 1, nums, currentSum + nums[index], currentTriplet1, out);
        // Exclude
        arraySum(index + 1, nums, currentSum, currentTriplet, out);
    }
}