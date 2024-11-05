package dev.seifeddinedridi.codingchallenges

class PartitionEqualSubsetSum {
    fun canPartition(a: IntArray): Boolean {
        var target = a.sum()
        if (target % 2 != 0) {
            return false
        }
        target /= 2
        val data = Array(target + 1) { Array(a.size + 1) { false } }
        for (i in a.indices) {
            data[0][i] = true
        }
        for (t in 1 .. target) {
            for (i in 1 .. a.size) {
                // Can the array up to element i contain a subarray with sum equals to t
                if (t >= a[i - 1]) {
                    data[t][i] = data[t - a[i - 1]][i - 1] || data[t][i - 1]
                } else {
                    // The current element has to be excluded
                    data[t][i] = data[t][i - 1]
                }
            }
        }
        return data[target][a.size]
    }
}