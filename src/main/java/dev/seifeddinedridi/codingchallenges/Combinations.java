package dev.seifeddinedridi.codingchallenges;

import java.util.List;
import java.util.ArrayList;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        // 1 = the minimum number
        // n = the maximum number
        // k = the size of permutation
        // k-tuple of numbers in the range [1, n]
        var outPermutations = new ArrayList<List<Integer>>();
        var currentPermutation = new ArrayList<Integer>();
        combine(n, k, 0, 0, currentPermutation, outPermutations);
        return outPermutations;
    }

    private void combine(int n, int k, int currentN, int currentSize,
        List<Integer> currentPermutation, List<List<Integer>> outPermutations) {
        if (currentSize == k) {
            outPermutations.add(new ArrayList<>(currentPermutation));
        } else {
            for (int i = currentN + 1; i <= n; i++) {
                currentPermutation.add(i);
                // depth-first traversal
                combine(n, k, i, currentSize + 1, currentPermutation, outPermutations);
                currentPermutation.remove(currentPermutation.size() - 1);
            }
        }
    }
}