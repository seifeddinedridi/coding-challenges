package dev.seifeddinedridi.codingchallenges;

public class Tribonacci {

    public int tribonacci(int n) {
        if (n <= 2) {
            return n == 0 ? 0 : 1;
        }
        var tribonacci = new int[n + 1];
        tribonacci[0] = 0;
        tribonacci[1] = tribonacci[2] = 1;
        for (int i = 3; i <= n; i++) {
            tribonacci[i] = tribonacci[i - 3] + tribonacci[i - 2] + tribonacci[i - 1];
        }
        return tribonacci[n];
    }
}
