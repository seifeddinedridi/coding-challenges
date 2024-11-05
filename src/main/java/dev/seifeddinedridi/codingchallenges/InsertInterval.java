package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        if (newInterval.length == 0) {
            return intervals;
        }
        var s = newInterval[0];
        var e = newInterval[1];
        for (var interval : intervals) {
            var s1 = interval[0];
            var e1 = interval[1];
            if ((s >= s1 && s <= e1) || (e >= s1 && e <= e1)) {
                s = Math.min(s, s1);
                e = Math.max(e, e1);
            }
        }
        var list = new ArrayList<int[]>();
        var i = 0;
        var newIntervalInsertionIndex = 0;
        var added = false;
        while (i < intervals.length) {
            var interval = intervals[i];
            var s1 = interval[0];
            var e1 = interval[1];
            var overlapping = (((s1 >= s && s1 <= e) || (e1 >= s && e1 <= e))
                    || ((s >= s1 && s <= e1) || (e >= s1 && e <= e1)));
            if (overlapping && !added) {
                list.add(new int[]{ s, e });
                added = true;
            } else if (!overlapping) {
                list.add(new int[]{ s1, e1 });
                if (s1 < s) {
                    newIntervalInsertionIndex++;
                }
            }
            i++;
        }
        if (!added) {
            list.add(newIntervalInsertionIndex, new int[]{ s, e });
        }
        return list.toArray(new int[list.size()][]);
    }
}
