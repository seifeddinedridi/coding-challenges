package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/house-robber

class HouseRobber {
    
    public int rob(int[] nums) {
        // h1 | h2 | h3 | h4 | h5
        var robbery1 = 0;
        var robbery2 = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            // Rob the current house?
            // Skip the current house if the previous house was robbed?
            var temp = Math.max(nums[i] + robbery2, robbery1);
            robbery2 = robbery1;
            robbery1 = temp;
        }
        return robbery1;
    }
    
    public int robRecursive(int[] nums) {
        var cache = new int[nums.length + 1];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
        return rob(nums, 0, cache);
    }

    private int rob(int[] nums, int currentHouseIndex, int[] cache) {
        if (currentHouseIndex >= nums.length) {
            return 0;
        }
        var robReward = nums[currentHouseIndex];
        if (cache[currentHouseIndex + 1] == -1) {
            cache[currentHouseIndex + 1] = rob(nums, currentHouseIndex + 2, cache);
        }
        robReward += cache[currentHouseIndex + 1];
        var notRobReward = 0;
        if (cache[currentHouseIndex] == -1) {
            cache[currentHouseIndex] = rob(nums, currentHouseIndex + 1, cache);
        }
        notRobReward += cache[currentHouseIndex];
        return Math.max(robReward, notRobReward);
    }
}