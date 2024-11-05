package dev.seifeddinedridi.codingchallenges

import kotlin.math.max

class LongestConsecutiveSequence {

    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val set = nums.toSet()
        var longestSequence = Int.MIN_VALUE
        for (v in set) {
            if (!set.contains(v - 1)) {
                var ans = 1
                var currentValue = v - 1
                while (set.contains(currentValue)) {
                    ans += 1
                    currentValue -=1
                }
                currentValue = v + 1
                while (set.contains(currentValue)) {
                    ans += 1
                    currentValue +=1
                }
                longestSequence = max(longestSequence, ans)
            }
        }
        return longestSequence
    }
}