package dev.seifeddinedridi.codingchallenges;

public class CalculateSquareRoot {

    public int mySqrtLinear(int x) {
        long t = 1;
        var tt = t * t;
        while (x >= tt) {
            t++;
            tt = t * t;
        }
        return (int) (t - 1);
    }

    public int mySqrtLinear2(int x) {
        var low = 1;
        var high = x;
        while (low <= high) {
            long mid = (high + low) / 2;
            if (mid == x / mid) {
                return (int) mid;
            } else if (mid > x / mid) {
                high = (int) (mid - 1);
            } else {
                low = (int) (mid + 1);
            }
        }
        return high;
    }

    int mySqrt(int x)  {
        if (x <= 1) {
            return x;
        }
        double root;
        double y = x;
        while (true) {
            root = (y + ((double) x / y)) * 0.5;
            if (Math.abs(root - y) < 0.001) {
                break;
            }
            y = root;
        }
        return (int) root;
    }
}
