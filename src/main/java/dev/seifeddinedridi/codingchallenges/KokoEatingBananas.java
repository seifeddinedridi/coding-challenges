package dev.seifeddinedridi.codingchallenges;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        var max = 0;
        for (var pile : piles) {
            max = Math.max(max, pile);
        }
        int left = 1, right = max;
        while (left <= right) {
            var k = (left + right) / 2;
            var hours = hoursNeeded(piles, k);
            if (hours <= h) {
                // The rate is too fast, slow it down
                right = k - 1;
            } else {
                // The rate is too slow, speed it up
                left = k + 1;
            }
        }
        return left;
    }

    private long hoursNeeded(int[] piles, int k) {
        var hours = 0L;
        for (var pile : piles) {
            hours += (pile + k - 1) / k;
        }
        return hours;
    }
}
