package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/climbing-stairs

class ClimbingStairs {
    public int climbStairs(int n) {
        // How many ways can we reach n?
        // If n is odd then steps = 2
        // If n is even then steps = 1

        // Use recursion. At each step, either step by 1 or step 2
        // n = 3
        // 0 1 2 3
        // data[3] = 0
        // data[2] = 1
        // data[1] = 2
        // data[0] = 2
        var data = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            data[i] = (data[i + 1] != 0 ? data[i + 1] : 0) + (i + 2 == n ? 1 : 0) + (i + 1 == n ? 1 : 0);
            if (i + 2 <= n) {
                data[i] += data[i + 2];
            }
        }
        return data[0];
        // return climb(n, 0);
    }

    public int climb(int n, int level) {
        if (level == n) {
            return 1;
        } else if (level < n) {
            return climb(n, level + 1) + climb(n, level + 2);
        }
        return 0;
    }
}