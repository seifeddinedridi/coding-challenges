package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/jump-game

import java.util.HashSet;
import java.util.LinkedList;

public class JumpGame {
    public boolean canJump(int[] nums) {
        var targetCell = nums.length - 1;
        var currentCell = targetCell - 1;
        while (currentCell >= 0 && targetCell > 0) {
            if (currentCell + nums[currentCell] >= targetCell) {
                if (currentCell == 0) {
                    return true;
                }
                targetCell = currentCell;
            }
            currentCell--;
        }
        return targetCell == 0;
    }
    
    public boolean canJumpGreedy(int[] nums) {
        var currentCell = nums.length - 1;
        while (currentCell > 0) {
            var copy = currentCell;
            for (var i = 0; i < currentCell; i++) {
                if (i + nums[i] >= currentCell) {
                    if (i == 0) {
                        return true;
                    }
                    currentCell = i;
                    break;
                }
            }
            if (copy == currentCell) {
                return false;
            }
        }
        return true;
    }

    public boolean canJumpBFS(int[] nums) {
        // We walk backwards start from the last element until we reach the first element
        // This algorithm is like a BFS (breath-first-search)
        var queue = new LinkedList<Integer>();
        queue.add(nums.length - 1);
        var visited = new HashSet<Integer>();
        while (!queue.isEmpty()) {
            var secondaryQueue = new LinkedList<Integer>(); 
            while (!queue.isEmpty()) {
                var currentCell = queue.poll();
                if (currentCell == 0) {
                    return true;
                }
                if (!visited.contains(currentCell)) {
                    // Find the cell that we can jump from towards the current cell
                    for (var i = 0; i < currentCell; i++) {
                        if (i + nums[i] >= currentCell) {
                            if (i == 0) {
                                return true;
                            }
                            secondaryQueue.push(i);
                            break;
                        }
                    }
                    visited.add(currentCell);
                }
            }
            queue.addAll(secondaryQueue);
        }
        return false;
    }
}