package dev.seifeddinedridi.codingchallenges;

import java.util.Set;

public class StringCompression2 {

    public int getLengthOfOptimalCompression(String s, int k) {
        var cache = new int[k + 1][s.length() + 1][s.length() + 1][26];
        return findMinStringLength(s.toCharArray(), k, 0, 0, '0', cache);
    }

    public int findMinStringLength(char[] chars, int charsLeft, int currentIndex, int previousCount, char previousChar, int [][][][] cache) {
        if (charsLeft < 0) {
            return Integer.MAX_VALUE;
        }
        if (chars.length - currentIndex == charsLeft) {
            return 0;
        }
        if (previousChar != '0' && cache[charsLeft][currentIndex][previousCount][previousChar - 'a'] != 0) {
            return cache[charsLeft][currentIndex][previousCount][previousChar - 'a'];
        }
        int ans;
        if (chars[currentIndex] == previousChar) {
            // Only include the current character
            // No need to delete the same character over and over again
            var increment = Set.of(1, 9, 99).contains(previousCount) ? 1 : 0;
            ans = increment + findMinStringLength(chars, charsLeft, currentIndex + 1, previousCount + 1, previousChar, cache);
        } else {
            ans = Math.min(
                    // Once a character is included, it will remain being included
                    // Include
                    1 + findMinStringLength(chars, charsLeft, currentIndex + 1, 1, chars[currentIndex], cache),
                    // Exclude so keep the current character streak
                    findMinStringLength(chars, charsLeft - 1, currentIndex + 1, previousCount, previousChar, cache)
            );
        }
        if (previousChar != '0') {
            cache[charsLeft][currentIndex][previousCount][previousChar - 'a'] = ans;
        }
        return ans;
    }
}
