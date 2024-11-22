package dev.seifeddinedridi.codingchallenges;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfShotArrows {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
        var shortArrowsCount = 0;
        int i = 0;
        while (i < points.length) {
            var j = i + 1;
            var x2 = points[i][1];
            while (j < points.length && points[j][0] <= x2) {
                x2 = Math.min(points[j][1], x2);
                j++;
            }
            shortArrowsCount++;
            i = j;
        }
        return shortArrowsCount;
    }
}
