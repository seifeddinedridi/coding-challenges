package dev.seifeddinedridi.codingchallenges;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<Integer>();
    }

    public int ping(int t) {
        var lowerBound = t - 3000;
        while (!queue.isEmpty() && queue.peek() < lowerBound) {
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }
}
