package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii

public class BestTimeToSellAndBuyAStock2 {
    public int maxProfit(int[] prices) {
        // We use the idea of hypothetical buy-sell
        // When are we sure that a sell date is the best date?
        var maxProfit = 0;
        //     7 | 1 | 5 | 3 | 6 | 4
        // 7 | 0 | 0 | 0 | 0 | 0 | 0
        // 1 | 0 | 0 | 4 | 2 | 5 | 3
        // 5 | 0 | 0 | 0 | 0 | 1 | 0
        // 3 | 0 | 0 | 0 | 0 | 3 | 1
        // 6 | 0 | 0 | 0 | 0 | 0 | 0
        // 4 | 0 | 0 | 0 | 0 | 0 | 0

        //     1 | 2 | 3 | 4 | 5
        // 1 | 0 | 1 | 2 | 3 | 4
        // 2 | 0 | 0 | 1 | 2 | 3
        // 3 | 0 | 0 | 0 | 1 | 2
        // 4 | 0 | 0 | 0 | 0 | 1
        // 5 | 0 | 0 | 0 | 0 | 0
        // We have to keep track of when a stock was bought or sold
        // To store the profits relative to the selling of the current stock
        var right = prices.length - 1;
        var left = right - 1;
        while (left >= 0) {
            maxProfit += Math.max(prices[right] - prices[left], 0);
            right--;
            left = right - 1;
        }
        return maxProfit;
    }
    
    public int maxProfitRecursive(int[] prices) {
        // For this problem, the key information is that we know the future
        // We know the stock prices
        // Look at the stock price in the future, if it will increase then buy it
        // Else move to the next day
        // On each day, either sell or buy stocks
        // maximumProf = sum((p_j - p_i))
        // Exponential time complexity O(2^prices.length)
        return maxProfit(prices, 0, -1);
    }

    private int maxProfit(int[] prices, int currentDay, int boughtStockIndex) {
        if (currentDay >= prices.length) {
            // We have to sell the stock
            if (boughtStockIndex != -1) {
                return prices[currentDay - 1] - prices[boughtStockIndex];
            }
            return 0;
        }
        if (boughtStockIndex == -1) {
            // We didn't buy any stock earlier
            // Skip or buy
            return Math.max(maxProfit(prices, currentDay + 1, -1),
                maxProfit(prices, currentDay + 1, currentDay));
        } else {
            // We already have a stock
            // Either sell or skip
            var sellProfit = prices[currentDay] - prices[boughtStockIndex];
            if (sellProfit < 0) {
                // Do not sell the stock at a loss
                // Skip selling
                return maxProfit(prices, currentDay + 1, boughtStockIndex);
            }
            return Math.max(sellProfit + maxProfit(prices, currentDay + 1, -1),
                maxProfit(prices, currentDay + 1, boughtStockIndex));
        }
    }
}