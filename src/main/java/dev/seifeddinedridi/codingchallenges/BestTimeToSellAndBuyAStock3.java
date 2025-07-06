package dev.seifeddinedridi.codingchallenges;

public class BestTimeToSellAndBuyAStock3 {

    public int maxProfit(int[] prices) {
        // (s2 - b2) + (s1 - b1)
        // s2 - (b2 - (s1 - b1))
        int buyStock1 = Integer.MAX_VALUE;
        int costOfBuyingStock2 = Integer.MAX_VALUE;
        int profitStock1 = 0;
        int profitStock2 = 0;
        for (var p : prices) {
            buyStock1 = Math.min(buyStock1, p);
            profitStock1 = Math.max(profitStock1, p - buyStock1);
            costOfBuyingStock2 = Math.min(costOfBuyingStock2, p - profitStock1);
            profitStock2 = Math.max(profitStock2, p - costOfBuyingStock2);
        }
        return profitStock2;
    }

    public int maxProfitSlow(int[] prices) {
        var maxRangeLTR = maxRangeLTR(prices);
        var maxRangeRTL = maxRangeRTL(prices);
        int maxProfit = 0;
        for (int buyDay = 0; buyDay < prices.length; buyDay++) {
            maxProfit = Math.max(maxProfit, maxRangeLTR[buyDay] + maxRangeRTL[buyDay + 1]);
        }
        return maxProfit;
    }

    private int[] maxRangeLTR(int[] prices) {
        var maxRange = new int[prices.length + 1];
        int maxIndex = 0, minIndex = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            var v = prices[i];
            if (v < prices[minIndex]) {
                minIndex = i;
            }
            if (v > prices[maxIndex]) {
                maxIndex = i;
            }
            if (minIndex > maxIndex) {
                // Reset
                maxIndex = minIndex;
            }
            maxProfit = Math.max(maxProfit, prices[maxIndex] - prices[minIndex]);
            maxRange[i] = maxProfit;
        }
        return maxRange;
    }

    private int[] maxRangeRTL(int[] prices) {
        var maxRange = new int[prices.length + 1];
        int maxIndex = prices.length - 1, minIndex = prices.length - 1;
        int maxProfit = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            var v = prices[i];
            if (v < prices[minIndex]) {
                minIndex = i;
            }
            if (v > prices[maxIndex]) {
                maxIndex = i;
            }
            if (minIndex > maxIndex) {
                // Reset
                minIndex = maxIndex;
            }
            maxProfit = Math.max(maxProfit, prices[maxIndex] - prices[minIndex]);
            maxRange[i] = maxProfit;
        }
        return maxRange;
    }
}
