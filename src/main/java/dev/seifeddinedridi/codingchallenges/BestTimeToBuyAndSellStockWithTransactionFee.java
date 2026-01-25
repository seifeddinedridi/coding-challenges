package dev.seifeddinedridi.codingchallenges;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) {
            return 0;
        }
        var buy = -prices[0];
        var sell = 0;
        for (int i = 1; i < prices.length; i++) {
            var previousBuy = buy;
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, prices[i] + previousBuy - fee);
        }
        return sell;
    }
}
