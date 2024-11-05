package dev.seifeddinedridi.codingchallenges;

import java.util.Arrays;

public class HIndex {

    public int hIndex(int[] citations) {
        if (citations.length == 1) {
            return citations[0] == 0 ? 0 : 1;
        }
        var hIndex = 0;
        // Does the author have H papers that have been cited at least H times?
        // We have to traverse the full range from [0 - Max Citations]
        Arrays.sort(citations);
        var i = citations[citations.length - 1];
        var index = citations.length - 1;
        while (i >= 0) {
            // Move to the first element that is less than citations[index]
            while (index >= 0 && citations[index] >= i) {
                index--;
            }
            var count = citations.length - index - 1;
            if (count >= i) {
                hIndex = i;
                break;
            }
            i--;
        }
        return hIndex;
    }
}
