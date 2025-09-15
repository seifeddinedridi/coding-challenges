package dev.seifeddinedridi.codingchallenges;

public class StringCompression {

    public int compress(char[] chars) {
        var i = 0;
        var globalIndex = 0;
        while (i < chars.length) {
            int count = 0;
            var currentIndex = i;
            while (i < chars.length && chars[i] == chars[currentIndex]) {
                i++;
                count++;
            }
            chars[globalIndex++] = chars[currentIndex];
            if (count > 1) {
                var digitsCount = countDigits(count);
                writeCount(chars, globalIndex, count, digitsCount);
                globalIndex += digitsCount;
            }
        }
        return globalIndex;
    }

    private void writeCount(char[] chars, int i, int number, int digitsCount) {
        var offset = digitsCount - 1;
        while (number > 0) {
            var n = number % 10;
            chars[i + offset] = Character.forDigit(n, 10);
            number = number / 10;
            offset--;
        }
    }

    private int countDigits(int x) {
        var count = 1;
        while (x / 10 > 0) {
            x = x / 10;
            count++;
        }
        return count;
    }
}
