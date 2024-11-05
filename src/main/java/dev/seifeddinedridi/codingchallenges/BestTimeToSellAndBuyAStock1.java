package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

import java.util.LinkedList;

public class BestTimeToSellAndBuyAStock1 {
    public int maxProfit(int[] prices) {
        // We have to keep buying stocks when the price is lowest and sell it when the price is highest
        // Price is lowest has to come before price is the highest
        // Keep track of the history of prices
        var diff = 0;
        var queue = new LinkedList<Integer>();
        for (int i = 0; i < prices.length; i++) {
            while (!queue.isEmpty() && prices[queue.peek()] > prices[i]) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                diff = Math.max(diff, prices[i] - prices[queue.peek()]);
            }
            queue.add(i);
        }
        return diff;
    }
}