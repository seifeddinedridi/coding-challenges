package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        var wordsFreq = new HashMap<String, Integer>();
        for (var w : words) {
            wordsFreq.merge(w, 1, Integer::sum);
        }
        var ans = new ArrayList<Integer>();
        var wordLength = words[0].length();
        var wordCount = words.length;
        for (var i = 0; i < wordLength; i++) {
            var l = i;
            var r = i;
            var sWordsFreq = new HashMap<String, Integer>();
            while (r + wordLength <= s.length()) {
                // Extract current word
                var w = s.substring(r, r + wordLength);
                r = r + wordLength;
                if (!wordsFreq.containsKey(w)) {
                    l = r;
                    sWordsFreq.clear();
                    continue;
                }
                sWordsFreq.merge(w, 1, Integer::sum);
                // If the number of words exceed the count
                // Remove words from the left side
                while (sWordsFreq.get(w) > wordsFreq.get(w)) {
                    var toBeRemoved = s.substring(l, l + wordLength);
                    l += wordLength;
                    if (sWordsFreq.merge(toBeRemoved, -1, Integer::sum) == 0) {
                        sWordsFreq.remove(toBeRemoved);
                    }
                }
                if (r - l == wordCount * wordLength) {
                    ans.add(l);
                }
            }
        }
        return ans;
    }
}
