package dev.seifeddinedridi.codingchallenges;

public class TrailingZeroesInFactorial {

    public int trailingZeroes(int n) {
        // Count the minimum the number of 2s and 5s in the constituting numbers forming the factorial of n
        var numberOfFives = 0;
        var iter = 0;
        while (iter <= n) {
            var temp = iter;
            while (temp != 0) {
                if (temp % 5 != 0) {
                    break;
                }
                numberOfFives++;
                temp /= 5;
            }
            iter += 5;
        }
        return numberOfFives;
    }

    public int trailingZeroesFast(int n) {
        int c = 0;
        while (n != 0) {
            n /= 5;
            c += n;
        }
        return c;
    }
}
