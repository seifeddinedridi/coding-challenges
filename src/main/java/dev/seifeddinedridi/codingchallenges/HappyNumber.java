package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/happy-number

class HappyNumber {
    public boolean isHappy(int n) {
        var n_slow = n;
        var n_fast = n;
        while (true) {
            var slow = sumOfDigitsSquared(n_slow);
            var fast = sumOfDigitsSquared(sumOfDigitsSquared(n_fast));
            if (slow == 1 || fast == 1) {
                return true;
            } else if (fast == slow) {
                return false;
            }
            n_slow = slow;
            n_fast = fast;
        }
    }

    private int sumOfDigitsSquared(int n) {
        var sum = 0;
        // 19 = 10^1 * 1 + 9 * 10^0
        // 182 = 10^2*1 + 10^1*8 + 10^0*2
        while (n > 0) {
            var d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }
}