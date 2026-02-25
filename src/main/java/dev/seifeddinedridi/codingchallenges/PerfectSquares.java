package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;

public class PerfectSquares {
    public int numSquares(int n) {
        var s = (int) Math.sqrt(n);
        if (n <= 1) {
            return Math.max(n, 0);
        } else if (s * s == n) {
            return 1;
        }
        var dp = new ArrayList<Integer>();
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            dp.add(i * i);
        }
        for (int i = 0; i < dp.size(); i++) {
            var x = dp.get(i);
            for (Integer integer : dp) {
                if (x + integer == n) {
                    return 2;
                }
            }
        }
        for (int i = 0; i < dp.size(); i++) {
            var x = dp.get(i);
            for (int j = 0; j < dp.size(); j++) {
                var y = dp.get(j);
                for (Integer integer : dp) {
                    if (x + y + integer == n) {
                        return 3;
                    }
                }
            }
        }
        return 4;
    }
}
