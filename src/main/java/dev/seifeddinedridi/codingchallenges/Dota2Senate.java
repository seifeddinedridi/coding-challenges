package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayDeque;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        var radiants = new ArrayDeque<Integer>();
        var dires = new ArrayDeque<Integer>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiants.offer(i);
            } else {
                dires.offer(i);
            }
        }
        var n = senate.length();
        while (!radiants.isEmpty() && !dires.isEmpty()) {
            var r = radiants.poll();
            var d = dires.poll();
            if (r < d) {
                radiants.offer(r + n);
            } else {
                dires.offer(d + n);
            }
        }
        return radiants.isEmpty() ? "Dire" : "Radiant";
    }

    public String predictPartyVictory2(String senate) {
        if (senate == null || senate.isEmpty()) {
            return null;
        }
        var senates = new ArrayDeque<Character>();
        var radiantDireBanCounts = new int[2];
        for (var c : senate.toCharArray()) {
            if (shouldSkip(c, radiantDireBanCounts)) {
                continue;
            }
            senates.offer(c);
        }
        while (!senates.isEmpty()) {
            var c = senates.poll();
            if (shouldSkip(c, radiantDireBanCounts)) {
                continue;
            }
            if (Math.max(radiantDireBanCounts[0], radiantDireBanCounts[1]) >= senates.size()
                    || senates.isEmpty() || senates.size() == 1) {
                return c == 'R' ? "Radiant" : "Dire";
            }
            senates.offer(c);
        }
        return null;
    }

    private boolean shouldSkip(char c, int[] radiantDireBanCounts) {
        if (c == 'R') {
            if (radiantDireBanCounts[0] > 0) {
                radiantDireBanCounts[0]--;
                return true;
            }
            radiantDireBanCounts[1]++;
        } else {
            if (radiantDireBanCounts[1] > 0) {
                radiantDireBanCounts[1]--;
                return true;
            }
            radiantDireBanCounts[0]++;
        }
        return false;
    }
}
