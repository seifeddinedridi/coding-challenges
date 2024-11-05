package dev.seifeddinedridi.codingchallenges;

import java.util.PriorityQueue;

class SmallestInfiniteSet {

    private final PriorityQueue<Integer> heap = new PriorityQueue<>();
    private int nextElement = -1;

    public SmallestInfiniteSet() {
        heap.add(1);
    }

    public int popSmallest() {
        var n = heap.poll();
        if (heap.isEmpty() && n < 1000) {
            // If the heap is empty, that means we haven't added back any element.
            // If there is more than one element, then that means we have added back an element
            heap.add(n + 1);
            nextElement = n + 1;
        }
        return n;
    }

    public void addBack(int num) {
        if (!heap.contains(num) && num < nextElement) {
            heap.add(num);
        }
    }
}
