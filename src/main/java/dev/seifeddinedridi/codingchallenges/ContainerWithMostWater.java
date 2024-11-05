package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/container-with-most-water

import java.util.LinkedList;

class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        // The height array is not sorted
        // The biggest rectangle is formed by the two lines that has the least difference in height
        // and are the furthest apart

        // Naive solution is O(N^2)
        
        int i1 = 0;
        int i2 = height.length - 1;
        var max = 0;
        while (i1 < i2) {
            max = Math.max(max, Math.min(height[i2], height[i1]) * (i2 - i1));
            if (height[i1] < height[i2]) {
                i1++;
            } else {
                i2--;
            }
        }
        // var max = Math.min(height[i2], height[i1]) * (i2 - i1);
        // while (i2 >= 0) {
        //     var temp = i1;
        //     // We have to limit this while loop
        //     // There must a smart way of doing that
        //     // We should not be going forward if the height has decreased
        //     while (temp < height.length && temp < i2) {
        //         var area = Math.min(height[i2], height[temp]) * (i2 - temp);
        //         if (area > max) {
        //             max = area;
        //             i1 = temp;
        //         }
        //         temp++;
        //     }
        //     i2--;
        // }
        return max;
    }
    
    public int maxArea2(int[] height) {
        // Find the largest rectangle
        // We have to keep track of the largest line
        // We should pop out the line that reduces the size of the rectangle
        // Go backward in the stack until the current area is bigger than the max?
        var heap = new LinkedList<Integer>();
        var max = 0;
        for (int i = 0; i < height.length; i++) {
            while (!heap.isEmpty()
                && max > Math.min(height[i], height[heap.peekLast()]) * (i - heap.peekLast())) {
                heap.poll();
            }
            if (heap.isEmpty()) {
                max = Math.min(height[i], height[0]) * i;
            } else {
                max = Math.min(height[i], height[heap.peekLast()]) * (i - heap.peekLast());
            }
            heap.add(i);
        }
        return max;
    }
}