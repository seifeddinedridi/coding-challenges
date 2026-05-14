package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        var pascalTriangle = new ArrayList<List<Integer>>();
        pascalTriangle.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            var row = new ArrayList<Integer>();
            var previousRow = pascalTriangle.get(i - 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || i == j) {
                    row.add(1);
                } else {
                    row.add(previousRow.get(j - 1) + previousRow.get(j));
                }
            }
            pascalTriangle.add(row);
        }
        return pascalTriangle;
    }
}
