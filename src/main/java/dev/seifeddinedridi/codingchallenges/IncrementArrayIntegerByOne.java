package dev.seifeddinedridi.codingchallenges;

import java.util.LinkedList;

public class IncrementArrayIntegerByOne {

    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1]++;
            return digits;
        } else {
            var incrementedDigits = new LinkedList<Integer>();
            var index = digits.length - 1;
            var carryOver = (digits[index] + 1) / 10;
            incrementedDigits.add((digits[index] + 1) % 10);
            index--;
            while (index >= 0 || carryOver > 0) {
                var v = (index >= 0 ? digits[index] : 0) + carryOver;
                incrementedDigits.addFirst(v % 10);
                carryOver = v / 10;
                index--;
            }
            return incrementedDigits.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
