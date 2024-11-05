package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        var ans = new ArrayList<List<String>>();
        partition(s, 0, new LinkedList<>(), ans);
        return ans;
    }

    public void partition(String s, int currentIndex,
                          LinkedList<String> currentPartitions,
                          List<List<String>> ans) {
        if (currentIndex >= s.length()) {
            ans.add(new ArrayList<>(currentPartitions));
            return;
        }
        for (int l = 1; l < s.length() - currentIndex + 1; l++) {
            var substring = s.substring(currentIndex, currentIndex + l);
            if (isPalindrome(substring)) {
                currentPartitions.addLast(substring);
                partition(s, currentIndex + l, currentPartitions, ans);
                currentPartitions.removeLast();
            }
        }
    }

    private boolean isPalindrome(String word) {
        if (word.isEmpty()) {
            return false;
        }
        var i = 0;
        var j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
