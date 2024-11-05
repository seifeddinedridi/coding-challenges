package dev.seifeddinedridi.codingchallenges;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        var ans = new HashMap<String, List<String>>();
        for (var word : strs) {
            var count = new int[26];
            for (var c : word.toCharArray()) {
                count[c - 'a'] += 1;
            }
            var key = String.valueOf(Arrays.hashCode(count));
            ans.computeIfAbsent(key, k -> new ArrayList<>());
            ans.get(key).add(word);
        }
        for (var l : ans.values()) {
            l.sort(Comparator.naturalOrder());
        }
        return new ArrayList<>(ans.values());
    }

    public List<List<String>> groupAnagramsSorting(String[] strs) {
        var ans = new HashMap<String, List<String>>();
        for (var word : strs) {
            var key = word.chars()
                    .mapToObj(String::valueOf)
                    .sorted()
                    .collect(Collectors.joining(""));
            ans.computeIfAbsent(key, k -> new ArrayList<>());
            ans.get(key).add(word);
        }
        return new ArrayList<>(ans.values());
    }
}
