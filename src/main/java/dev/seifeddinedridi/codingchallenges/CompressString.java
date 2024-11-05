package dev.seifeddinedridi.codingchallenges;

public class CompressString {

    public static char[] compress(char[] chars) {
        var nbNeededSlots = 0;
        var i = 0;
        while (i < chars.length) {
            var j = i + 1;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            nbNeededSlots += 1 + String.valueOf(j - i).length();
            i = j;
        }
        if (nbNeededSlots > chars.length) {
            // Resizing is needed, not possible to resize in place
            var dest = new char[nbNeededSlots];
            System.arraycopy(chars, 0, dest, 0, chars.length);
            chars = dest;
        }
        i = 0;
        while (i < nbNeededSlots) {
            var j = i + 1;
            var count = 1;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
                count++;
            }
            if (count == 1) {
                shiftRight(chars, j, 1);
            } else if (count > 2) {
                shiftLeft(chars, j, count - 2);
            }
            i++;
            for (var c : String.valueOf(count).toCharArray()) {
                chars[i++] = c;
            }
        }
        while (i < chars.length) {
            chars[i++] = ' ';
        }
        return chars;
    }

    private static void shiftRight(char[] chars, int from, int offset) {
        // >>>>>>>>>>>>>>
        // Free up space to insert the character count
        // Shift all characters whose indices >= from to the right by one position
        for (int k = chars.length - 1 - offset; k >= from; k--) {
            chars[k + offset] = chars[k];
            chars[k] = ' ';
        }
    }

    private static void shiftLeft(char[] chars, int from, int offset) {
        // <<<<<<<<<<<<<
        // Compress space since we only need one slot to insert the character offset
        // Shift all characters whose index >= from to the left by (offset - 2) positions
        // The number 2: one slot for the character itself and another slot for the offset
        for (int k = from; k < chars.length; k++) {
            chars[k - offset] = chars[k];
            chars[k] = ' ';
        }
    }

    public static void main(String[] args) {
        System.out.println(compress("abbcdef".toCharArray()));
        System.out.println(compress("aaaaaaaaabbcdef".toCharArray()));
        System.out.println(compress("aaaaaaaaabbcdeeeeeeefzz".toCharArray()));
        System.out.println(compress("abcdef".toCharArray()));
        System.out.println(compress("abbcdeef".toCharArray()));
        System.out.println(compress("aaaaaaaaaa".toCharArray()));
        System.out.println(compress("baaacdef".toCharArray()));
    }
}
