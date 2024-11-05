package dev.seifeddinedridi.codingchallenges;

import java.util.*;

public class KPairsSmallestSums {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        var heap = new PriorityQueue<List<Integer>>(Comparator.comparingInt(l -> l.getFirst() + l.get(1)));

        heap.add(List.of(nums1[0], nums2[0], 0, 0));
        var visited = new HashSet<List<Integer>>();
        var ans = new ArrayList<List<Integer>>();
        while (k > 0 && !heap.isEmpty()) {
            var pair = heap.poll();
            ans.add(List.of(pair.get(0), pair.get(1)));
            var x = pair.get(2);
            var y = pair.get(3);
            if (x + 1 < nums1.length && !visited.contains(List.of(x + 1, y))) {
                visited.add(List.of(x + 1, y));
                heap.add(List.of(nums1[x + 1], nums2[y], x + 1, y));
            }
            if (y + 1 < nums2.length && !visited.contains(List.of(x, y + 1))) {
                visited.add(List.of(x, y + 1));
                heap.add(List.of(nums1[x], nums2[y + 1], x, y + 1));
            }
            k--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(kSmallestPairs(new int[]{1, 2, 3}, new int[]{1, 2, 3}, 3));
    }
}
