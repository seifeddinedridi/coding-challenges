package dev.seifeddinedridi.codingchallenges;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {

    public long totalCost(int[] costs, int k, int candidates) {
        var workerCosts = new LinkedList<Integer>();
        for (var cost : costs) {
            workerCosts.add(cost);
        }
        var totalCost = 0L;
        // Pull the first candidates and the last candidates from the queue
        var minWorkerCostFirst = new PriorityQueue<Integer>();
        var count = 0;
        while (!workerCosts.isEmpty() && count < candidates) {
            minWorkerCostFirst.add(workerCosts.pollFirst());
            count++;
        }
        count = 0;
        var minWorkerCostLast = new PriorityQueue<Integer>();
        while (!workerCosts.isEmpty() && count < candidates) {
            minWorkerCostLast.add(workerCosts.pollLast());
            count++;
        }
        for (int i = 0; i < k; i++) {
            if (minWorkerCostFirst.size() < candidates && !workerCosts.isEmpty()) {
                minWorkerCostFirst.add(workerCosts.pollFirst());
            }
            if (minWorkerCostLast.size() < candidates && !workerCosts.isEmpty()) {
                minWorkerCostLast.add(workerCosts.pollLast());
            }
            var firstWorkerCost = Integer.MAX_VALUE;
            if (!minWorkerCostFirst.isEmpty()) {
                firstWorkerCost = minWorkerCostFirst.peek();
            }
            var lastWorkerCost = Integer.MAX_VALUE;
            if (!minWorkerCostLast.isEmpty()) {
                lastWorkerCost = minWorkerCostLast.peek();
            }
            if (firstWorkerCost <= lastWorkerCost) {
                minWorkerCostFirst.poll();
                totalCost += firstWorkerCost;
            } else {
                minWorkerCostLast.poll();
                totalCost += lastWorkerCost;
            }
        }
        return totalCost;
    }
}
