package dev.seifeddinedridi.codingchallenges;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        var ans = new int[intervals.length][2];
        var i = 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        var outSize = 0;
        while (i < intervals.length) {
            var s = intervals[i][0];
            var e = intervals[i][1];
            var j = i + 1;
            while (j < intervals.length) {
                var s1 = intervals[j][0];
                var e1 = intervals[j][1];
                if (((s >= s1 && s <= e1) || (e >= s1 && e <= e1)
                        || ((s1 >= s && s1 <= e) || (e1 >= s && e1 <= e)))) {
                    s = Math.min(s, s1);
                    e = Math.max(e, e1);
                    j++;
                } else {
                    break;
                }
            }
            i = j;
            ans[outSize][0] = s;
            ans[outSize][1] = e;
            outSize++;
        }
        var out = new int[outSize][2];
        System.arraycopy(ans, 0, out, 0, outSize);
        return out;
    }
}
