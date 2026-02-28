package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return List.of();
        }
        var pArray = createCharCountMap(p);
        var wArray = createCharCountMap(s.substring(0, p.length()));
        var indices = new ArrayList<Integer>();
        var array = s.toCharArray();
        for (int i = p.length(); i < array.length; i++) {
            if (Arrays.equals(wArray, pArray)) {
                indices.add(i - p.length());
            }
            int i1 = array[i - p.length()] - 'a';
            wArray[i1] = wArray[i1] - 1;
            wArray[array[i] - 'a']++;
        }
        if (Arrays.equals(wArray, pArray)) {
            indices.add(s.length() - p.length());
        }
        return indices;
    }

    private int[] createCharCountMap(String s) {
        var array = new int[26];
        for (var c : s.toCharArray()) {
            array[c - 'a']++;
        }
        return array;
    }
}
