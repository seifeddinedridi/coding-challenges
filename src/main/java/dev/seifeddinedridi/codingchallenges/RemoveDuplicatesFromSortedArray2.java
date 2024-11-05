package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii

public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        // For each element, loop from that index until a different value is found
        // Insert the element the found value at the current available slot in the array
        // Or the number of duplicates exceed 2
        // If the latter is true restart at the currentIndex + 1.

        // 0 0 0 1 2 3
        // 0 0 1 2 3 3

        // 1 1 1 2 2 3
        // 1 1 2 2 3 3
        var removedElements = 0;
        var i = 0;
        while (i < nums.length - removedElements) {
            var count = 1;
            var j = i + 1;
            while (j < nums.length - removedElements) {
                if (nums[j] == nums[j - 1]) {
                    count++;
                } else {
                    break;
                }
                j++;
            }
            // There are two cases
            // If j == nums.length - 1 then we can truncate the array at index i +1 and break from the loop
            // Else if count > 2 then we need to shift all the elements start from index j and put them at index i + 1
            if (count >= 3) {
                // Shift elements to the left by (j - i) steps to the index i + 1
                var shifts = j - 1 - (i + 2) + 1;
                shiftLeft(nums, j - 1, shifts);
                removedElements += count - 2;
                // j=6 shiftLeft(nums, 5, 2)
                //0,0,1,1,1,1,2,3,3
                //0 0 1 1 2 3 3
                // 0 0 1 
            }
            i++;
        }
        return nums.length - removedElements;
    }

    private void shiftLeft(int[] nums, int start, int steps) {
        if (start - steps >= 0) {
            for (int i = start; i < nums.length; i++) {
                nums[i - steps] = nums[i];
            }
        }
    }
}