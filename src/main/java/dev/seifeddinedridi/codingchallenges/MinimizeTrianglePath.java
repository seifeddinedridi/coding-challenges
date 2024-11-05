package dev.seifeddinedridi.codingchallenges;

import java.util.List;
import java.util.Map;

public class MinimizeTrianglePath {
    public int minimumTotal(List<List<Integer>> triangle) {
        // At the current row, we can either move to (r + 1, i) or (r + 1, i + 1)
        // return minimumTotal(triangle, 0, 0, new HashMap<String, Integer>());

        // Look up (r - 1, i) and (r - 1, i - 1), find the minimum and store it in the current cell
        // Compare found minimum with the minimum from the right side
        // When it is not possible to go up AT ALL then that node is the head of the triangle
        // We can traverse the triangle column-wise
        var rowSize = triangle.size();
        var data = new int[rowSize + 1];
        for (int r = rowSize - 1; r >= 0; r--) {
            for (int c = 0; c < triangle.get(r).size(); c++) {
                data[c] = Math.min(data[c], data[c + 1]) + triangle.get(r).get(c);
            }
        }
        return data[0];
    }

    public int minimumTotalON2(List<List<Integer>> triangle) {
        var data = new int[triangle.size()][];
        for (var i = 0; i < triangle.size(); i++) {
            data[i] = new int[triangle.get(i).size()];
        }
        data[0][0] = triangle.getFirst().getFirst();
        var minimumGlobal = data[0][0];
        for (int r = 1; r < triangle.size(); r++) {
            data[r][0] = data[r - 1][0] + triangle.get(r).getFirst();
            var minimumLocal = data[r][0];
            for (int i = 1; i < triangle.get(r).size(); i++) {
                int opt = triangle.get(r).get(i);
                var rMinusOne = r - 1;
                var iMinusOne = i - 1;
                if (i < triangle.get(rMinusOne).size()) {
                    // Look directly up
                    // Lookup and one step to the left
                    opt += Math.min(data[rMinusOne][iMinusOne], data[rMinusOne][i]);
                } else {
                    // Look up and one step to the left
                    opt += data[rMinusOne][iMinusOne];
                }
                data[r][i] = opt;
                minimumLocal = Math.min(minimumLocal, data[r][i]);
            }
            minimumGlobal = minimumLocal;
        }
        return minimumGlobal;
    }

    public int minimumTotal(List<List<Integer>> triangle, int r, int i, Map<String, Integer> cache) {
        if (r == triangle.size() - 1) {
            return triangle.get(r).get(i);
        } else if (r < triangle.size()) {
            var delta = triangle.get(r).get(i);
            var key1 = (r + 1) + "_" + i;
            int opt1;
            if (!cache.containsKey(key1)) {
                opt1 = minimumTotal(triangle, r + 1, i, cache);
                cache.put(key1, opt1);
            } else {
                opt1 = cache.get(key1);
            }
            var key2 = (r + 1) + "_" + (i + 1);
            int opt2;
            if (!cache.containsKey(key2)) {
                opt2 = minimumTotal(triangle, r + 1, i + 1, cache);
                cache.put(key2, opt2);
            } else {
                opt2 = cache.get(key2);
            }
            return delta + Math.min(opt1, opt2);
        }
        return 0;
    }
}
