package dev.seifeddinedridi.codingchallenges;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        var sortedProjects = IntStream.range(0, profits.length)
                .mapToObj(i -> List.of(capital[i], profits[i]))
                .sorted(Comparator.comparingInt(List::getFirst))
                .toList();
        var sortedProfits = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
        var i = 0;
        while (k > 0) {
            while (i < sortedProjects.size() && w >= sortedProjects.get(i).get(0)) {
                sortedProfits.offer(sortedProjects.get(i).get(1));
                i++;
            }
            if (sortedProfits.isEmpty()) {
                break;
            }
            w += sortedProfits.poll();
            k--;
        }
        return w;
    }
}
