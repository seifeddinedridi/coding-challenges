package dev.seifeddinedridi.codingchallenges;

public class DominoAndTrominoTiling {
    public int numTilings(int n) {
        if (n <= 1) {
            if (n == 1) {
                return 1;
            }
            return 0;
        }
        // 1: 1
        // 2: 2
        // 3: 5   = 2*2 + 1
        // 4: 11  = 5*2 + 1
        // 5: 24  = 11*2 + 2
        // 6: 53  = 24*2 + 5
        // 7: 117 = 53*2 + 11
        var count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            long res = count[i - 1] * 2L;
            if (i >= 3) {
                res += count[i - 3];
            }
            count[i] = (int) (res % 1_000_000_007);
        }
        return count[n];
    }
}
