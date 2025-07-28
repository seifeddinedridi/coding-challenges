package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        var uniqueCombos = new ArrayList<List<Integer>>();
        combinationSum3(0, k, n, new ArrayList<>(3), uniqueCombos);
        return uniqueCombos;
    }

    private void combinationSum3(int current, int k, int n, List<Integer> currentCombo, List<List<Integer>> uniqueCombos) {
        if (n < 0 || k == 0) {
            return;
        }
        if (n == 0 && currentCombo.size() == k) {
            uniqueCombos.add(new ArrayList<>(currentCombo));
            return;
        }
        for (int x = current + 1; x <= 9; x++) {
            currentCombo.add(x);
            combinationSum3(x, k, n - x, currentCombo, uniqueCombos);
            currentCombo.removeLast();
        }
    }
}
