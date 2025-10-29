package dev.seifeddinedridi.codingchallenges;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        var minIntervalsCount = 0;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));
        var currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            // Check for overlaps
            if (currentInterval[1] > intervals[i][0]) {
                minIntervalsCount++;
            } else {
                currentInterval = intervals[i];
            }
        }
        return minIntervalsCount;
    }
}
