package dev.seifeddinedridi.codingchallenges

import java.util.*

class OnlineStockSpan {
    
    private val prices = mutableListOf<Int>()
    private val stack = Stack<Int>()
    
    fun next(price: Int): Int {
        prices.add(price)
        while (stack.isNotEmpty() && prices[stack.peek()] <= prices.last()) {
            stack.pop()
        }
        val span = if (stack.isEmpty()) prices.size else prices.size - 1 - stack.peek()
        stack.push(prices.size - 1)
        return span
    }
}
