package dev.seifeddinedridi.codingchallenges;

import java.util.HashMap;

public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        var map = new HashMap<Integer, Integer>();
        var count = 0;
        for (int[] row : grid) {
            var key = 0;
            for (var c = 0; c < grid.length; c++) {
                key += key * 10 + row[c];
            }
            map.compute(key, (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
        }
        for (var c = 0; c < grid.length; c++) {
            var key = 0;
            for (int[] ints : grid) {
                key += key * 10 + ints[c];
            }
            if (map.containsKey(key)) {
                count += map.get(key);
            }
        }
        return count;
    }
}
