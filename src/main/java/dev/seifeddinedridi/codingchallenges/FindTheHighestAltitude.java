package dev.seifeddinedridi.codingchallenges;

public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int highestAltitude = 0, g = 0;
        for (var v : gain) {
            g += v;
            highestAltitude = Math.max(highestAltitude, g);
        }
        return highestAltitude;
    }
}
