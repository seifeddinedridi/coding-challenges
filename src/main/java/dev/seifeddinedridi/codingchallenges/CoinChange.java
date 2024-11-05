package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/coin-change

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        // coins is a set
        // there are infinite number of arrangements of coins where the sum is equal to amount
        // however we only want the arrangement that has the least number of coins
        var data = new int[amount][coins.length];
        for (int a = 1; a <= amount; a++) {
            for (int i = 0; i < coins.length; i++) {
                if (a != coins[i]) {
                    // We are allowed to use more than one coin
                    if (i > 0 && data[a - 1][i - 1] != 0) {
                        // We have already found a solution that is minimal
                        data[a - 1][i] = data[a - 1][i - 1];
                    }
                    if (a >= coins[i] && (data[a - 1][i] != 0 || data[a - 1 - coins[i]][i] != 0)) {
                        // No solutions so far
                        // We can look "up"
                        int s1 = data[a - 1][i] != 0 ? data[a - 1][i] : Integer.MAX_VALUE;
                        int s2 = data[a - 1 - coins[i]][i] != 0 ? data[a - 1 - coins[i]][i] + 1 : Integer.MAX_VALUE;
                        data[a - 1][i] = Math.min(s1, s2);
                    }
                } else {
                    data[a - 1][i] = 1;
                }
            }
        }
        //   1 2 5
        // 0 0 0 0
        // 1 1 1 1 
        // 2 1 1 1
        // 3 1 2 2
        // 4 0 2 2
        // 5 0 3 1
        // 6 0 3 3
        // 7 0 4 4
        // 8 0 4 4
        // 9 0 5 5
        //10 0 5 5
        //11 0 6 6
        return data[amount - 1][coins.length - 1] == 0 || data[amount - 1][coins.length - 1] == Integer.MAX_VALUE ? -1 : data[amount - 1][coins.length - 1];
    }
}