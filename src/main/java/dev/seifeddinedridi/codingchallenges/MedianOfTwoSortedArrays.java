package dev.seifeddinedridi.codingchallenges;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0, index2 = 0;
        int value1 = 0, value2 = 0;
        for (int i = 0; i <= (nums1.length + nums2.length) / 2; i++) {
            value1 = value2;
            var v1 = Integer.MAX_VALUE;
            if (index1 < nums1.length) {
                v1 = nums1[index1];
            }
            var v2 = Integer.MAX_VALUE;
            if (index2 < nums2.length) {
                v2 = nums2[index2];
            }
            if (v1 < v2) {
                value2 = v1;
                index1++;
            } else {
                value2 = v2;
                index2++;
            }
        }
        if (((nums1.length + nums2.length) & 1) == 1) {
            // Array size is odd
            return value2;
        } else {
            return (value1 + value2) / 2.0;
        }
    }

    public double findMedianSortedArraysSort(int[] nums1, int[] nums2) {
        var ans = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, ans, 0, nums1.length);
        System.arraycopy(nums2, 0, ans, nums1.length, nums2.length);
        Arrays.sort(ans);
        var mid = ans.length / 2;
        if ((ans.length & 1) == 1) {
            // Array size is odd
            return ans[mid];
        } else {
            return (ans[mid - 1] + ans[mid]) / 2.0;
        }
    }
}
