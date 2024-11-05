package dev.seifeddinedridi.codingchallenges;

public class Power {

    private static final double EPSILON  = 0.0000001;

    public static double myPow(double x, int n) {
        if (n == 0 || x == 0.0) {
            return x == 0.0 ? 0 : 1.0;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1.0 / x;
        }
        var absN = Math.abs((long) n);
        // ans = powerRecursive(x, absN);
        var end = absN;
        var ans = 1.0;
        while (end != 0) {
            if ((end & 1) == 1) {
                ans *= x;
            }
            x *= x;
            end /= 2;
        }
        if (n < 0) {
            ans = 1.0 / ans;
        }
        return ans;
    }

    // 2^8 -> 16*16
    // 2^4 -> 16
    // 2^2 -> 4
    // 2^1 -> 2

    // 2 ^ 9 -> 16*16*2
    // 2 ^ 4 -> 16
    // 2 ^ 2 -> 4
    // 2 ^ 1 -> 2
    private static double powerRecursive(double x, long n) {
        if (n <= 1) {
            return x;
        }
        var val = powerRecursive(x, n / 2);
        val *= val;
        if ((n & 1) == 1) {
            val *= x;
        }
        return val;
    }

    public double myPow2(double x, int n) {
        var delta = Math.abs(Math.abs(x) - 1.0);
        var absN = Math.abs((long) n);
        if (n == 0) {
            return 1.0;
        } else if (delta <= EPSILON) {
            // Application of binomial approximation
            // https://en.wikipedia.org/wiki/Binomial_approximation
            if (x < 0.0) {
                return ((absN & 1) == 1) ? -(1.0 + delta * n) : (1.0 + delta * n);
            } else {
                return 1.0 + delta * n;
            }
        }
        var ans = 1.0;
        if (x == 2.0) {
            var shift = 32;
            for (long i = 0; i < absN / shift; i+= shift) {
                ans *= (1L << shift);
            }
            if (absN % shift != 0) {
                ans *= (1L << (absN % shift));
            }
        } else {
            for (long i = 0; i < absN; i++) {
                ans *= x;
            }
        }
        if (n < 0) {
            ans = 1.0 / ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        var x = 2.0;
        var n = 10;
        System.out.println("Reference=" + myPow(x, n));
        System.out.println("Recursive=" + powerRecursive(x, n));
    }
}
