package dev.seifeddinedridi.codingchallenges;

import java.util.*;

public class MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        var sortedIndices = new Integer[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            sortedIndices[i] = i;
        }
        Arrays.sort(sortedIndices, Comparator.comparingInt(i -> -nums2[i]));
        var minHeap = new PriorityQueue<Integer>();
        var maxSum = 0L;
        var maxScore = 0L;
        for (Integer sortedIndex : sortedIndices) {
            minHeap.add(nums1[sortedIndex]);
            maxSum += nums1[sortedIndex];
            if (minHeap.size() > k) {
                maxSum -= minHeap.poll();
            }
            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, maxSum * nums2[sortedIndex]);
            }
        }
        return maxScore;
    }
}
