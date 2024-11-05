package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/isomorphic-strings

import java.util.HashSet;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if (s.equalsIgnoreCase(t)) {
            return true;
        }
        // I think we can use a 2D map
        //    0 1 2
        // a  1 0 0
        // d  0 1 1
        // d  0 1 1

        //    0 1 2
        // e  1 0 0
        // g  0 1 1
        // g  0 1 1
        var set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                continue;
            }
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                var f1 = s.charAt(j) == s.charAt(i);
                var f2 = t.charAt(j) == t.charAt(i);
                if (f1 != f2) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        var set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("Seifu", "fieS"));
        System.out.println(isIsomorphic2("Seifu", "fieS"));
    }
}