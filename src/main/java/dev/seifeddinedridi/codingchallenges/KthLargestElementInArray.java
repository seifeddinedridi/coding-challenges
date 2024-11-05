package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/kth-largest-element-in-an-array

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        // Sort the array
        // return nums[nums.length - k] if (nums.length >= k) else -1

        // [3,2,1,5,6,4], k =2
        // n=3, heap=[3]
        // n=2, heap=[3, 2]
        // n=1, heap=[3, 2, 1]
        // n=5, heap=[5, 3, 2]
        // n=6, heap=[6, 5, 3]
        // n=4, heap=[6, 5, 4]

        var heap = new PriorityQueue<Integer>();
        for (var n : nums) {
            while (!heap.isEmpty() && heap.size() > k) {
                heap.poll();
            }
            heap.offer(n);
        }
        while (!heap.isEmpty() && heap.size() > k) {
            heap.poll();
        }
        return heap.isEmpty() ? -1 : heap.poll();
    }
}