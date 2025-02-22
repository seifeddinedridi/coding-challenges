package dev.seifeddinedridi.codingchallenges;

public class CountNumberOfBitsSetTo1 {

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (n >> i) & 1;
        }
        return count;
    }
}
