package dev.seifeddinedridi.codingchallenges;

public class BestTimeToSellAndBuyAStock4 {

    public int maxProfit(int k, int[] prices) {
        // (s_k - b_k) + (s_k1 - b_k1) + (s_k2 - b_k2) + ... + + (s_1 - b_k1)
        int[] dp = new int[k * 2];
        for (int j = 0; j < dp.length; j++) {
            if ((j & 1) == 0) {
                dp[j] = Integer.MAX_VALUE; // Entries to minimize
            } else {
                dp[j] = 0; // Entries to maximize
            }
        }
        for (int price : prices) {
            dp[0] = Math.min(dp[0], price);
            for (int j = 1; j < dp.length; j++) {
                if ((j & 1) == 0) {
                    // Minimize
                    dp[j] = Math.min(dp[j], price - dp[j - 1]);
                } else {
                    // Maximize
                    dp[j] = Math.max(dp[j], price - dp[j - 1]);
                }
            }
        }
        return dp[dp.length - 1];
    }
}
