package dev.seifeddinedridi.codingchallenges;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class RepeatedDnaSequence {

    public List<String> findRepeatedDnaSequences(String s) {
        var size = 10;
        if (s.length() < size) {
            return List.of();
        }
        var processedSubstrings = new HashSet<String>();
        var ans = new HashSet<String>();
        for (var i = 0; i <= s.length() - size; i++) {
            var substring = s.substring(i, i + size);
            if (!processedSubstrings.add(substring)) {
                ans.add(substring);
            }
        }
        return new ArrayList(ans);
    }
}
