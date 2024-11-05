package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/longest-increasing-subsequence

import java.util.Map;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // We can use a 2D loop to start the intermediate results.
        // What is the longest subsequence considering 1 elements = 1
        // What is the longest subsequence considering a max of 2 elements?
        // ...
        // How to implement a decision tree using a 2D matrix?
        //   10 9 2 5 3 7 101 18
        // 0 0  0 0 0 0 0  0  0
        // 1 1  1 1 1 1 1  1  1
        // 2 1  1 1 1 1 1  2  1
        // 3 1  1 1 1 1 1  3  1    
        // 4
        // 5
        // 6
        // 7
        // 8

//   0 1 0 3 2 3
// 4 
// 3
// 2
// 1
// 0 
        var data = new int[nums.length];
        data[nums.length - 1] = 1;
        var max = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            // Longest increasing subsequence (LIS) starting from index i until the end. Max=nums[i]
            // Here we need to loop through data and find a potentially better solution
            data[i] = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    data[i] = Math.max(data[i], data[j] + 1);
                }
            }
            max = Math.max(max, data[i]);
        }
        return max;
        // var data = new HashMap<String, Integer>();
        // return findMax(nums, 0, Integer.MIN_VALUE, data);
        // At each step, consider to update the max or not update the max. In the end we pick the output that maximizes the subsequence length
        // data[j][i - 1] contains the longest subsequence considering i elements
        // Update max     => max = nums[i]
        // NOT update max =>
        // How to track the output of each decision?
        // var data = new int[nums.length + 1][nums.length];
        // var max = Integer.MIN_VALUE;
        // for (int j = 1; j <= nums.length; j++) {
        //     max = Math.max(max, nums[j]);
        //     for (int i = 0; i < nums.length; i++) {
        //         // Compare with previous
        //         if (j == 1) {
        //             data[j][i] = 1;
        //         } else if (i > 0) {
        //             var increment = 0;
        //             if (i > 0 && nums[i] > max) {
        //                 // Exclude or include?
        //                 increment = 1;
        //                 data[j][i] = Math.max(data[j][i], data[j][i]);
        //             }
        //             data[j][i] = Math.max(data[j - 1][i], i > 0 ? data[j][i - 1] : 0) + increment;
        //         }
        //     }
        // }
        // return data[nums.length][nums.length - 1];
    }

    private int findMax(int[] nums, int index, int max, Map<String, Integer> data) {
        if (index >= nums.length) {
            return 0;
        }
        var key1 = index + 1 + "|" + max;
        // Exclude or include?
        if (!data.containsKey(key1)) {
            data.put(key1, findMax(nums, index + 1, max, data));
        }
        if (nums[index] > max) {
            var key2 = index + 1 + "|" + nums[index];
            if (!data.containsKey(key2)) {
                data.put(key2, findMax(nums, index + 1, nums[index], data));
            }
            return Math.max(data.get(key1), data.get(key2) + 1);
        } else {
            return data.get(key1);
        }
    }
}