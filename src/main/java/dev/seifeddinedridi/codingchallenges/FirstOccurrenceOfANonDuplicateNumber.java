package dev.seifeddinedridi.codingchallenges;

import java.util.HashMap;

public class FirstOccurrenceOfANonDuplicateNumber {

    static int getFirstNonDuplicate(int[] numbers) {
        var map = new HashMap<Integer, Integer>();
        for (var n : numbers) {
            map.merge(n, 1, Integer::sum);
        }
        for (var n : numbers) {
            if (map.containsKey(n) && map.get(n) == 1) {
                return n;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        var numbers = new int[]{1, 1, 2, 3, 3};
        System.out.println(getFirstNonDuplicate(numbers));
    }
}
