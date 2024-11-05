package dev.seifeddinedridi.codingchallenges;

public class ReverseBits {

    public int reverseBits(int n) {
        int flipped = 0;
        for (int i = 0; i <= 31; i++) {
            var mask = ((n >> i) & 1) << (31 - i);
            flipped = flipped | mask;
        }
        return flipped;
    }
}
