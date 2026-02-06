package dev.seifeddinedridi.codingchallenges;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        // minCost(index) = cost(index) + min(minCost(index + 1), minCost(index + 2))
        var dp = new int[cost.length + 2];
        for (int i = cost.length - 1; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }
}
