package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        var powerList = new ArrayList<List<Integer>>();
        subsets(powerList, new Stack<>(), nums, 0);
        return powerList;
    }

    private void subsets(List<List<Integer>> powerList, Stack<Integer> stack, int[] nums, int index) {
        if (index >= nums.length) {
            powerList.add(new ArrayList<>(stack));
            return;
        }
        stack.push(nums[index]);
        subsets(powerList, stack, nums, index + 1);
        stack.pop();
        subsets(powerList, stack, nums, index + 1);
    }
}
