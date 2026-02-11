package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var set1 = new HashSet<Integer>();
        for (var n : nums1) {
            set1.add(n);
        }
        var set2 = new HashSet<Integer>();
        for (var n : nums2) {
            set2.add(n);
            set1.remove(n);
        }
        for (var n : nums1) {
            set2.remove(n);
        }
        return List.of(new ArrayList<>(set1), new ArrayList<>(set2));
    }
}
