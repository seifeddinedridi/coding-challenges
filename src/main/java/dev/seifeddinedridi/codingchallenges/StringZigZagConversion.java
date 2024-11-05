package dev.seifeddinedridi.codingchallenges;

public class StringZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        var sb = new StringBuilder();
        var r = 0;
        var charCursor = 0;
        int direction = 0; // 0 for down-then-up, 1 for up-then-down
        while (r < numRows && r < s.length()) {
            sb.append(s.charAt(charCursor));
            // Now update the cursor
            if (r == 0) {
                // Target position is (r, c + 1)
                charCursor += 2 * (numRows - 1 - r);
            } else {
                // Target position is (r, c + 1)
                if (direction == 0) {
                    // Down-then-up
                    charCursor += 2 * (numRows - 1 - r);
                    direction = 1;
                } else {
                    // Up-then-down
                    charCursor += 2 * r;
                    direction = (r == numRows - 1 ? 1 : 0);
                }
            }
            if (charCursor >= s.length()) {
                r++;
                charCursor = r;
                direction = (r == numRows - 1 ? 1 : 0);
            }
        }
        return sb.toString();
    }
}
