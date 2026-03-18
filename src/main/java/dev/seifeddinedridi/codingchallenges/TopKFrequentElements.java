package dev.seifeddinedridi.codingchallenges;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        var frequencies = new HashMap<Integer, Integer>();
        for (var n : nums) {
            frequencies.put(n, frequencies.getOrDefault(n, 0) + 1);
        }
        var heap = new PriorityQueue<Integer>((n1, n2) -> frequencies.get(n1).compareTo(frequencies.get(n2)));
        for (var n : frequencies.keySet()) {
            heap.offer(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        var i = 0;
        var mostFrequents = new int[k];
        while (i < k) {
            mostFrequents[i++] = heap.poll();
        }
        return mostFrequents;
    }
}
