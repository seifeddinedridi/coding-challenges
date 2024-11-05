package dev.seifeddinedridi.codingchallenges;

public class NumberRangeBitwiseAND {

    public int rangeBitwiseAnd(int left, int right) {
        // First of all generate all the numbers in the range [left, right]
        // Apply the AND operator on the generated numbers

        // 0 =  0000
        // 1 =  0001
        // 2 =  0010
        // 3 =  0011
        // 4 =  0100
        // 5 =  0101
        // 6 =  0110
        // 7 =  0111
        // 8 =  1000
        // 9 =  1001
        // 10 = 1010

        // Find the common prefix of the binary representations of left and right numbers
        var ans = 0;
        // 5 =  0101
        // 7 =  0111

        // 0
        // 01
        // 010
        // 0101
        for (int i = 30; i >= 0; i--) {
            var x = (left & (1 << i)) >>> i;
            var y = (right & (1 << i)) >>> i;
            if (x == y) {
                ans |= (x << i);
            } else if (y == 1) {
                break;
            }
        }
        return ans;

        // Return the number with the least number of bits
        // whose bits exist in the other numbers
        // How do we know if a bit at position i exists at the same position
        // in all the numbers in the range?

        // I have to interpret this problem differently but how?
        // The resultant number is less than the max in the range, and could be less than the min in the range
        // What does the AND operator do? It is a sort of consensus, if the 2 bits says "yes" then the output will be "yes" otherwise it will be a "no".

        // The number of numbers for a given range is too big

        // Try to activate all the bits the least significant and most significant bits
        // Filter on the numbers less than the max
        // Apply AND operator on them and store the result in the same number

        // The output is controlled by the bits in the min number
        // From the min number we have to find out which MORE bits that we activate
        // in order to get a number less than the max
    }
}
