package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/merge-sorted-array

public class MergeTwoSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Push forward all the m elements toward the end
        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }
        int i = n;
        int j = 0;
        int k = 0;
        while (k < m + n) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    nums1[k] = nums1[i++];
                } else {
                    nums1[k] = nums2[j++];
                }
            } else if (i < nums1.length) {
                // We consumed all n elements
                nums1[k] = nums1[i++];
            } else {
                // We consumed all m elements
                nums1[k] = nums2[j++];
            }
            k++;
        }
    }
}