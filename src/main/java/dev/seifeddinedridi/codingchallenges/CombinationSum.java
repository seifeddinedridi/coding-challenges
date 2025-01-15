package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // We have 2 types of combinations:
        // 1. A combination of the same number, ex. [2, 2, 2]
        // 2. A combination of different numbers, ex. [1, 2, 3]
        // For the first case, we can check that by dividing target with said number
        var combinations = new ArrayList<List<Integer>>();
        combinationSum(candidates, target, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    void combinationSum(int[] candidates, int target, int index,
                        List<Integer> currentCombination, List<List<Integer>> combinations) {
        if (index >= candidates.length) {
            return;
        }
        if (target == 0) {
            combinations.add(new ArrayList<>(currentCombination));
        } else if (target > 0) {
            currentCombination.add(candidates[index]);
            combinationSum(candidates, target - candidates[index], index, currentCombination, combinations);
            currentCombination.removeLast();
            combinationSum(candidates, target, index + 1, currentCombination, combinations);
        }
    }
}
