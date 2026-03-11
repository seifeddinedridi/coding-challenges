package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        var lastIndices = new int[26];
        for (int i = 0; i < s.length(); i++) {
            var idx = s.charAt(i) - 'a';
            lastIndices[idx] = i;
        }
        var partition = new ArrayList<Integer>();
        int farthest = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            var idx = s.charAt(i) - 'a';
            farthest = Math.max(lastIndices[idx], farthest);
            if (farthest == i) {
                partition.add(farthest - left + 1);
                left = i + 1;
            }
        }
        return partition;
    }
}
