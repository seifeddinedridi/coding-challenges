package dev.seifeddinedridi.codingchallenges;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        var pairs = new int[spells.length];
        Arrays.sort(potions);
        for (var i = 0; i < spells.length; i++) {
            int left = 0, right = potions.length;
            var index = potions.length;
            while (left < right) {
                var mid = (left + right) / 2;
                var strength = (long) spells[i] * potions[mid];
                if (strength >= success) {
                    // Move to the left side because we want to find the weakest potion that satisfies the strength criteria
                    right = mid;
                    index = mid;
                } else {
                    left = mid + 1;
                }
            }
            pairs[i] = potions.length - index;
        }
        return pairs;
    }
}
